/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Robert Doczi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.jdt

import com.google.common.base.Preconditions
import com.google.common.base.Splitter
import java.util.HashMap
import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.deployment.common.WaitTransitionMatcher
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException
import org.eclipse.viatra.examples.cps.xform.m2t.util.FormatterUtil
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.CompilationUnit
import org.eclipse.jdt.core.dom.InfixExpression.Operator
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword
import org.eclipse.jdt.core.dom.Name

class Generator {

	extension FormatterUtil helper = new FormatterUtil
	val String PROJECT_NAME
	val ViatraQueryEngine engine

	new(String projectName, ViatraQueryEngine engine) {
		PROJECT_NAME = projectName
		this.engine = engine
	}

	def generateHostCode(DeploymentHost host) throws CPSGeneratorException {
		val ast = AST.newAST(AST.JLS8)
		val cu = ast.newCompilationUnit

		ast.setPackage(cu, '''«PROJECT_NAME».hosts''')

		ast.addImport(cu, "org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application")
		ast.addImport(cu,
			"org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer.CommunicationNetwork")
		ast.addImport(cu, "org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.BaseHost")
		ast.addImport(cu, "com.google.common.collect.Lists")

		for (app : host.applications) {
			ast.addImport(cu, '''«PROJECT_NAME».applications.«app.id.purifyAndToUpperCamel»Application''')
		}

		val hostName = '''Host«host.ip.purifyAndToUpperCamel»'''
		val classDecl = ast.newPublicClass(hostName)
		classDecl.superclassType = ast.newSimpleType("BaseHost")

		val ctor = ast.newMethodDeclaration => [
			constructor = true
			modifiers() += ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			name = ast.newSimpleName(hostName)
			parameters += ast.newVariableDeclaration(false, "CommunicationNetwork", "network")
		]

		val ctorBody = ast.newBlock

		val superCall = ast.newSuperConstructorInvocation => [
			arguments += ast.newSimpleName("network")
		]
		ctorBody.statements += superCall

		val appList = ast.newAssignment => [
			leftHandSide = ast.newSimpleName("applications")
			rightHandSide = ast.newMethodInvocation => [
				expression = ast.newSimpleName("Lists")
				typeArguments += ast.newSimpleType("Application")
				name = ast.newSimpleName("newArrayList")
				for (app : host.applications) {
					arguments += ast.newClassInstanceCreation => [
						type = ast.newSimpleType('''«app.id.purifyAndToUpperCamel»Application''')
						arguments += ast.newThisExpression
					]
				}
			]
		]
		ctorBody.statements += ast.newExpressionStatement(appList)

		ctor.body = ctorBody

		classDecl.bodyDeclarations += ctor

		cu.types += classDecl
		cu.toString
	}

	def generateApplicationCode(DeploymentApplication application) throws CPSGeneratorException {
		val ast = AST.newAST(AST.JLS8)
		val cu = ast.newCompilationUnit

		val behavior = "Behavior" + application.id.purifyAndToUpperCamel
		val appClassName = application.id.purifyAndToUpperCamel + "Application"

		ast.setPackage(cu, '''«PROJECT_NAME».applications''')

		ast.addImport(cu,
			"org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.BaseApplication")
		ast.addImport(cu, "org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.Host")

		ast.addImport(cu, '''«PROJECT_NAME».hosts.statemachines.«behavior»''')

		val classDecl = ast.newPublicClass(appClassName)
		classDecl.superclassType = ast.newParameterizedType(ast.newSimpleType('''BaseApplication''')) => [
			typeArguments += ast.newSimpleType(behavior)
		]

		val idField = ast.newFieldDeclaration(
			ast.newVariableDeclarationFragment => [
				name = ast.newSimpleName("APP_ID")
				initializer = ast.newStringLiteral => [literalValue = application.id]
			]) => [
			it.type = ast.newSimpleType("String")
			modifiers() += #[
				ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD),
				ast.newModifier(ModifierKeyword.STATIC_KEYWORD),
				ast.newModifier(ModifierKeyword.FINAL_KEYWORD)
			]
		]
		classDecl.bodyDeclarations += idField

		val ctor = ast.newMethodDeclaration => [
			constructor = true
			modifiers() += ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			name = ast.newSimpleName(appClassName)
			parameters += ast.newVariableDeclaration(false, "Host", "host")
		]

		val ctorBody = ast.newBlock

		val superCall = ast.newSuperConstructorInvocation => [
			arguments += ast.newSimpleName("host")
		]
		ctorBody.statements += superCall

		if(application?.behavior?.current != null){
			val currentState = ast.newAssignment => [
				leftHandSide = ast.newSimpleName("currentState")
				rightHandSide = ast.newQualifiedName(
					'''«behavior».«application.behavior.current.description.purifyAndToUpperCamel»''')
			]
			ctorBody.statements += ast.newExpressionStatement(currentState)
		}

		ctor.body = ctorBody

		classDecl.bodyDeclarations += ctor

		val idGetter = ast.newMethodDeclaration => [
			modifiers() += #[
				ast.newMarkerAnnotation => [typeName = ast.newSimpleName("Override")],
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			]
			name = ast.newSimpleName("getAppID")
		]

		val getterBody = ast.newBlock => [
			statements += ast.newReturnStatement => [
				expression = ast.newSimpleName("APP_ID")
			]
		]
		idGetter.body = getterBody

		classDecl.bodyDeclarations += idGetter

		cu.types += classDecl
		cu.toString
	}

	def generateBehaviorCode(DeploymentBehavior behavior) throws CPSGeneratorException {
		val ast = AST.newAST(AST.JLS8)
		val cu = ast.newCompilationUnit

		val app = behavior.eContainer as DeploymentApplication
		val behaviorClassName = "Behavior" + app.id.purifyAndToUpperCamel

		ast.setPackage(cu, '''«PROJECT_NAME».hosts.statemachines''')

		ast.addImport(cu, "java.util.List")

		ast.addImport(cu, "org.apache.log4j.Logger")
		ast.addImport(cu, "org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application")
		ast.addImport(cu,
			"org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State")

		ast.addImport(cu, "com.google.common.collect.Lists")

		val enumDecl = ast.newEnumDeclaration => [
			name = ast.newSimpleName(behaviorClassName)
			superInterfaceTypes += #[
				ast.newParameterizedType(ast.newSimpleType("State")) => [
					typeArguments += ast.newSimpleType(behaviorClassName)
				]
			]
			for (state : behavior.states) {
				enumConstants += ast.generateState(state, behaviorClassName)
			}
		]

		val loggerField = ast.newFieldDeclaration(
			ast.newVariableDeclarationFragment => [
				name = ast.newSimpleName("logger")
				initializer = ast.newMethodInvocation => [
					expression = ast.newSimpleName("Logger")
					name = ast.newSimpleName("getLogger")
					arguments += ast.newStringLiteral => [literalValue = "cps.proto.distributed.state"]
				]
			]) => [
			type = ast.newSimpleType("Logger")
			modifiers() += #[
				ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD),
				ast.newModifier(ModifierKeyword.STATIC_KEYWORD)
			]
		]

		var possibleNextStatesMethodDeclaration = ast.newMethodDeclaration => [
			modifiers() += #[
				ast.newMarkerAnnotation => [typeName = ast.newSimpleName("Override")],
				ast.newModifier(ModifierKeyword.ABSTRACT_KEYWORD),
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			]
			name = ast.newSimpleName("possibleNextStates")
			parameters += ast.newVariableDeclaration(false, "Application", "app")
			returnType2 = ast.newParameterizedType(ast.newSimpleType("List")) => [
				typeArguments += ast.newParameterizedType(ast.newSimpleType("State")) => [
					typeArguments += ast.newSimpleType(behaviorClassName)
				]
			]
		]

		val stepToMethodDecl = ast.newMethodDeclaration => [
			modifiers() += #[
				ast.newMarkerAnnotation => [typeName = ast.newSimpleName("Override")],
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			]
			name = ast.newSimpleName("stepTo")
			parameters += ast.newVariableDeclaration(false, behaviorClassName, "nextState")
			parameters += ast.newVariableDeclaration(false, "Application", "app")
			returnType2 = ast.newSimpleType(behaviorClassName)
		]

		val stepToBody = ast.newBlock => [
			statements += ast.newIfStatement => [
				expression = ast.newMethodInvocation => [
					expression = ast.newMethodInvocation => [
						name = ast.newSimpleName("possibleNextStates")
						arguments += ast.newSimpleName("app")
					]
					name = ast.newSimpleName("contains")
					arguments += ast.newSimpleName("nextState")
				]
				thenStatement = ast.newBlock => [
					statements += ast.newExpressionStatement(
						ast.newMethodInvocation => [
							expression = ast.newSimpleName("logger")
							name = ast.newSimpleName("info")
							arguments += ast.newInfixExpression => [
								operator = Operator.PLUS
								leftOperand = ast.newStringLiteral => [literalValue = "Step from "]
								rightOperand = ast.newInfixExpression => [
									operator = Operator.PLUS
									leftOperand = ast.newMethodInvocation => [
										expression = ast.newThisExpression
										name = ast.newSimpleName("name")
									]
									rightOperand = ast.newInfixExpression => [
										operator = Operator.PLUS
										leftOperand = ast.newStringLiteral => [literalValue = " to "]
										rightOperand = ast.newMethodInvocation => [
											expression = ast.newSimpleName("nextState")
											name = ast.newSimpleName("name")
										]
									]
								]
							]
						])
					statements += ast.newReturnStatement => [
						expression = ast.newSimpleName("nextState")
					]
				]
				elseStatement = ast.newExpressionStatement(
					ast.newMethodInvocation => [
						expression = ast.newSimpleName("logger")
						name = ast.newSimpleName("info")
						arguments += ast.newInfixExpression => [
							operator = Operator.PLUS
							leftOperand = ast.newStringLiteral => [literalValue = "!!! Warning: Unable to step from "]
							rightOperand = ast.newInfixExpression => [
								operator = Operator.PLUS
								leftOperand = ast.newMethodInvocation => [
									expression = ast.newThisExpression
									name = ast.newSimpleName("name")
								]
								rightOperand = ast.newInfixExpression => [
									operator = Operator.PLUS
									leftOperand = ast.newStringLiteral => [literalValue = " to "]
									rightOperand = ast.newInfixExpression => [
										operator = Operator.PLUS
										leftOperand = ast.newMethodInvocation => [
											expression = ast.newSimpleName("nextState")
											name = ast.newSimpleName("name")
										]
										rightOperand = ast.newStringLiteral => [ literalValue = " because the target state is not possible state." ]
									]
								]
							]
						]
					])
			]
			statements += ast.newReturnStatement => [expression = ast.newThisExpression]
		]
		stepToMethodDecl.body = stepToBody

		enumDecl.bodyDeclarations += #[
			loggerField,
			possibleNextStatesMethodDeclaration,
			stepToMethodDecl
		]

		cu.types += enumDecl
		cu.toString
	}

	def generateState(AST ast, BehaviorState state, String behaviorClassName) {
		val enumConst = ast.newEnumConstantDeclaration => [
			name = ast.newSimpleName(state.description.purifyAndToUpperCamel)
		]

		val possibleNextStatesMethodDecl = ast.newMethodDeclaration => [
			modifiers() += #[
				ast.newMarkerAnnotation => [typeName = ast.newSimpleName("Override")],
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			]
			name = ast.newSimpleName("possibleNextStates")
			parameters += ast.newVariableDeclaration(false, "Application", "app")
			returnType2 = ast.newParameterizedType(ast.newSimpleType("List")) => [
				typeArguments += ast.newParameterizedType(ast.newSimpleType("State")) => [
					typeArguments += ast.newSimpleType(behaviorClassName)
				]
			]
		]

		val possibleNextStatesBody = ast.newBlock => [
			statements += ast.newVariableDeclarationStatement(
				ast.newVariableDeclarationFragment => [
					name = ast.newSimpleName("possibleStates")
					initializer = ast.newMethodInvocation => [
						expression = ast.newSimpleName("Lists")
						name = ast.newSimpleName("newArrayList")
					]
				]) => [
				type = ast.newParameterizedType(ast.newSimpleType("List")) => [
					typeArguments += ast.newParameterizedType(ast.newSimpleType("State")) => [
						typeArguments += ast.newSimpleType(behaviorClassName)
					]
				]
			]
			for (trgState : state.calculateNeutralStateTransition) {
				statements += ast.newExpressionStatement(
					ast.newMethodInvocation => [
						expression = ast.newSimpleName("possibleStates")
						name = ast.newSimpleName("add")
						arguments += ast.newSimpleName(trgState.description.purifyAndToUpperCamel)
					])
			}
			for (transition : state.calculateSendStateTransition) {
				statements += ast.newExpressionStatement(
					ast.newMethodInvocation => [
						expression = ast.newSimpleName("possibleStates")
						name = ast.newSimpleName("add")
						arguments += ast.newSimpleName(transition.to.description.purifyAndToUpperCamel)
					])
			}
			val map = state.calculateWaitStateTransition
			for (trgTransition : map.keySet) {
				statements += ast.newIfStatement => [
					expression = ast.newMethodInvocation => [
						expression = ast.newSimpleName("app")
						name = ast.newSimpleName("hasMessageFor")
						arguments += ast.newSimpleName(trgTransition.description.purifyAndToUpperCamel)
					]
					thenStatement = ast.newExpressionStatement(
						ast.newMethodInvocation => [
							expression = ast.newSimpleName("possibleStates")
							name = ast.newSimpleName("add")
							arguments += ast.newSimpleName(map.get(trgTransition).description.purifyAndToUpperCamel)
						])
				]
			}
			statements += ast.newReturnStatement => [
				expression = ast.newSimpleName("possibleStates")
			]
		]
		possibleNextStatesMethodDecl.body = possibleNextStatesBody

		val stepToMethodDecl = ast.newMethodDeclaration => [
			modifiers() += #[
				ast.newMarkerAnnotation => [typeName = ast.newSimpleName("Override")],
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
			]
			name = ast.newSimpleName("stepTo")
			parameters += ast.newVariableDeclaration(false, behaviorClassName, "nextState")
			parameters += ast.newVariableDeclaration(false, "Application", "app")
			returnType2 = ast.newSimpleType(behaviorClassName)
		]

		val stepToBody = ast.newBlock => [
			for (transition : state.calculateSendStateTransition) {
				statements += ast.newIfStatement => [
					expression = ast.newInfixExpression => [
						operator = Operator.EQUALS
						leftOperand = ast.newSimpleName("nextState")
						rightOperand = ast.newSimpleName(transition.to.description.purifyAndToUpperCamel)
					]
					thenStatement = ast.newBlock => [
						statements += ast.newExpressionStatement(
							ast.newMethodInvocation => [
								expression = ast.newSimpleName("app")
								name = ast.newSimpleName("sendTrigger")
								for (arg : state.calculateSendTriggerParameters(transition))
									arguments += ast.newStringLiteral => [literalValue = arg]
							])
						statements += ast.newReturnStatement => [
							expression = ast.newSuperMethodInvocation => [
								name = ast.newSimpleName("stepTo")
								arguments += ast.newSimpleName("nextState")
								arguments += ast.newSimpleName("app")
							]
						]
					]
				]
			}
			statements += ast.newReturnStatement => [
				expression = ast.newSuperMethodInvocation => [
					name = ast.newSimpleName("stepTo")
					arguments += ast.newSimpleName("nextState")
					arguments += ast.newSimpleName("app")
				]
			]
		]
		stepToMethodDecl.body = stepToBody

		enumConst.anonymousClassDeclaration = ast.newAnonymousClassDeclaration => [
			bodyDeclarations += possibleNextStatesMethodDecl
			bodyDeclarations += stepToMethodDecl
		]
		enumConst
	}

	def calculateSendTriggerParameters(BehaviorState srcState, BehaviorTransition transition) {
		if (transition != null) {
			#[transition.trigger.head.host.ip, transition.trigger.head.app.id, transition.trigger.head.name]
		} else {
			throw new CPSGeneratorException(
				"#Error: Cannot find transition from " + srcState.name + " to " + transition.to.name)
		}
	}

	def DeploymentHost host(BehaviorTransition transition) {
		val app = transition?.eContainer?.eContainer?.eContainer
		if (app != null && app instanceof DeploymentHost) {
			return app as DeploymentHost
		}
		throw new CPSGeneratorException("#Error: Cannot find Host of the Transition (" + transition.name + ")")
	}

	def DeploymentApplication app(BehaviorTransition transition) {
		val app = transition?.eContainer?.eContainer
		if (app != null && app instanceof DeploymentApplication) {
			return app as DeploymentApplication
		}
		throw new CPSGeneratorException("#Error: Cannot find Application of the Transition (" + transition.name + ")")
	}

	def String name(BehaviorState state) {
		state.description.purifyAndToUpperCamel
	}

	def String name(BehaviorTransition transition) {
		transition.description.purifyAndToUpperCamel
	}

	def calculateWaitStateTransition(BehaviorState srcState) {
		val waitTransitions = srcState.outgoing.filter [ transition |
			return transition.trigger.empty && transition.hasIncomingTrigger
		]
		val map = new HashMap<BehaviorTransition, BehaviorState>

		waitTransitions.forEach [ waitTrans |
			map.put(waitTrans, waitTrans.to)
		]

		return map
	}

	def calculateSendStateTransition(BehaviorState srcState) {
		srcState.outgoing.filter [ transition |
			return !transition.trigger.empty
		]
	}

	def calculateNeutralStateTransition(BehaviorState srcState) {
		srcState.outgoing.filter [ transition |
			return transition.trigger.empty && !transition.hasIncomingTrigger
		].map[transition|transition.to]
	}

	def getHasIncomingTrigger(BehaviorTransition transition) {
		WaitTransitionMatcher.on(engine).hasMatch(transition, null);
	}

	def setPackage(AST ast, CompilationUnit cu, String packageName) {
		val packageDeclaration = ast.newPackageDeclaration => [
			name = ast.newName(packageName)
		]
		cu.setPackage(packageDeclaration)
	}

	def addImport(AST ast, CompilationUnit cu, String importQualifiedName) {
		val importDecl = ast.newImportDeclaration => [
			name = ast.newName(importQualifiedName)
		]
		cu.imports.add(importDecl)
	}

	def newPublicClass(AST ast, String className) {
		val classDecl = ast.newTypeDeclaration => [
			interface = false
			name = ast.newSimpleName(className)
		]
		classDecl.modifiers() += ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD)
		classDecl
	}

	def newVariableDeclaration(AST ast, boolean isArray, String type, String name) {
		ast.newSingleVariableDeclaration => [
			if (isArray) {
				it.type = ast.newArrayType(ast.newSimpleType(type))
			} else {
				it.type = ast.newSimpleType(type)
			}
			it.name = ast.newSimpleName(name)
		]
	}

	def newSimpleType(AST ast, String typeName) {
		Preconditions.checkArgument(!typeName.contains('.'),
			'''Cannot create type from type name >«typeName»< The name cannot be qualified.''')
		ast.newSimpleType(ast.newSimpleName(typeName))
	}

	def newQualifiedName(AST ast, String name) {
		Preconditions.checkArgument(name.contains('.'),
			'''Cannot create qualified name from name >«name»<. The name provided is not qualified.''')

		if (name.contains('.')) {
			var Name qName;
			val tokens = Splitter.on('.').split(name)
			val tokenIt = tokens.iterator

			qName = ast.newSimpleName(tokenIt.next)

			while (tokenIt.hasNext) {
				qName = ast.newQualifiedName(qName, ast.newSimpleName(tokenIt.next))
			}
			qName
		}
	}
}
