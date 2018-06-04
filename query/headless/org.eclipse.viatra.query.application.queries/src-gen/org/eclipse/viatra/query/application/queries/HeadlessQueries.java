/**
 * Generated from platform:/resource/org.eclipse.viatra.query.application.queries/src/org/eclipse/viatra/query/application/queries/headlessQueries.vql
 */
package org.eclipse.viatra.query.application.queries;

import org.eclipse.viatra.query.application.queries.ClassesInPackage;
import org.eclipse.viatra.query.application.queries.ClassesInPackageHierarchy;
import org.eclipse.viatra.query.application.queries.EClass;
import org.eclipse.viatra.query.application.queries.EClassNames;
import org.eclipse.viatra.query.application.queries.EClassNamesKeyword;
import org.eclipse.viatra.query.application.queries.EObject;
import org.eclipse.viatra.query.application.queries.EPackage;
import org.eclipse.viatra.query.application.queries.SubPackage;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in headlessQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file headlessQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.eclipse.viatra.query.application.queries, the group contains the definition of the following patterns: <ul>
 * <li>eClassNames</li>
 * <li>eClassNamesKeyword</li>
 * <li>eObject</li>
 * <li>classesInPackage</li>
 * <li>subPackage</li>
 * <li>classesInPackageHierarchy</li>
 * <li>ePackage</li>
 * <li>eClass</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class HeadlessQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static HeadlessQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new HeadlessQueries();
    }
    return INSTANCE;
  }
  
  private static HeadlessQueries INSTANCE;
  
  private HeadlessQueries() {
    querySpecifications.add(EClassNames.instance());
    querySpecifications.add(EClassNamesKeyword.instance());
    querySpecifications.add(EObject.instance());
    querySpecifications.add(ClassesInPackage.instance());
    querySpecifications.add(SubPackage.instance());
    querySpecifications.add(ClassesInPackageHierarchy.instance());
    querySpecifications.add(EPackage.instance());
    querySpecifications.add(EClass.instance());
  }
  
  public EClassNames getEClassNames() {
    return EClassNames.instance();
  }
  
  public EClassNames.Matcher getEClassNames(final ViatraQueryEngine engine) {
    return EClassNames.Matcher.on(engine);
  }
  
  public EClassNamesKeyword getEClassNamesKeyword() {
    return EClassNamesKeyword.instance();
  }
  
  public EClassNamesKeyword.Matcher getEClassNamesKeyword(final ViatraQueryEngine engine) {
    return EClassNamesKeyword.Matcher.on(engine);
  }
  
  public EObject getEObject() {
    return EObject.instance();
  }
  
  public EObject.Matcher getEObject(final ViatraQueryEngine engine) {
    return EObject.Matcher.on(engine);
  }
  
  public ClassesInPackage getClassesInPackage() {
    return ClassesInPackage.instance();
  }
  
  public ClassesInPackage.Matcher getClassesInPackage(final ViatraQueryEngine engine) {
    return ClassesInPackage.Matcher.on(engine);
  }
  
  public SubPackage getSubPackage() {
    return SubPackage.instance();
  }
  
  public SubPackage.Matcher getSubPackage(final ViatraQueryEngine engine) {
    return SubPackage.Matcher.on(engine);
  }
  
  public ClassesInPackageHierarchy getClassesInPackageHierarchy() {
    return ClassesInPackageHierarchy.instance();
  }
  
  public ClassesInPackageHierarchy.Matcher getClassesInPackageHierarchy(final ViatraQueryEngine engine) {
    return ClassesInPackageHierarchy.Matcher.on(engine);
  }
  
  public EPackage getEPackage() {
    return EPackage.instance();
  }
  
  public EPackage.Matcher getEPackage(final ViatraQueryEngine engine) {
    return EPackage.Matcher.on(engine);
  }
  
  public EClass getEClass() {
    return EClass.instance();
  }
  
  public EClass.Matcher getEClass(final ViatraQueryEngine engine) {
    return EClass.Matcher.on(engine);
  }
}
