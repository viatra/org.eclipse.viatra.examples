/*******************************************************************************
 * Copyright (c) 2010-2013, Abel Hegedus, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Abel Hegedus - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.query.runtime.runonce.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.examples.library.Book;
import org.eclipse.viatra.examples.library.BookCategory;
import org.eclipse.viatra.examples.library.LibraryFactory;
import org.eclipse.viatra.examples.library.LibraryPackage;
import org.eclipse.viatra.examples.library.Library;
import org.eclipse.viatra.examples.library.Writer;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineManager;
import org.eclipse.viatra.query.runtime.api.impl.RunOnceQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.IndexingLevel;
import org.eclipse.viatra.query.runtime.base.comprehension.WellbehavingDerivedFeatureRegistry;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

/**
 * Test cases that run different kind of derived features in run-once engine.
 * 
 * @author Abel Hegedus
 *
 */
public class RunOnceTest {
    
	private ResourceSet rs;
	
    /**
     * Prepares a resource set and loads the example model.
     * 
     * @return the library that is the root of the example model 
     */
    private Library prepareModel() {
        String modelPath = "/org.eclipse.viatra.query.runtime.runonce.tests/model/test.library";
        rs = new ResourceSetImpl();
        URI modelUri = URI.createPlatformPluginURI(modelPath, true);
        Resource resource = rs.getResource(modelUri, true);
        return (Library) resource.getContents().get(0);
    }

    /**
     * Test whether a run-once engine returns matches for regular queries.
     */
    @Test
    public void testRegularQuery() {
        Library library = prepareModel();
        
        try {
            //RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
        		ViatraQueryEngine engine = ViatraQueryEngineManager.getInstance().getQueryEngine(new EMFScope(rs));
//            Collection<BooksWithMultipleAuthors.Match> all.Matches = engine.getAllMatches(BooksWithMultipleAuthorsMatcher.querySpecification());
            Collection<BooksWithMultipleAuthors.Match> allMatches = engine.getMatcher(BooksWithMultipleAuthors.Matcher.querySpecification()).getAllMatches();
            assertTrue(allMatches.size() == 2);
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    @Test
    public void testSimpleAttribute() {
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
            Collection<SumOfPagesInLibrary.Match> allMatches = engine.getAllMatches(SumOfPagesInLibrary.Matcher.querySpecification());
            assertTrue(allMatches.size() == 1);
            SumOfPagesInLibrary.Match match = allMatches.iterator().next();
            assertTrue(match.getLibrary().equals(library));
            assertTrue(match.getSumOfPages() == 222);
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    @Test
    public void testSingleReference() {
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
            Collection<SingleAuthoredFirstBooks.Match> allMatches = engine.getAllMatches(SingleAuthoredFirstBooks.Matcher.querySpecification());
            assertTrue(allMatches.size() == 1);
            SingleAuthoredFirstBooks.Match match = allMatches.iterator().next();
            assertTrue(match.getLibrary().equals(library));
            assertTrue(match.getFirstBook().getTitle().equals("Other SciFi"));
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    @Test
    public void testManyReference() {
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
            Collection<LongSciFiBooksOfAuthor.Match> allMatches = engine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            assertTrue(allMatches.size() == 1);
            LongSciFiBooksOfAuthor.Match match = allMatches.iterator().next();
            assertTrue(match.getAuthor().getName().equals("Third Author"));
            assertTrue(match.getBook().getTitle().equals("Other SciFi"));
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    /**
     * This test uses a derived feature that returns different values on subsequent requests.
     * We could use this to test how the engine responds in such cases (e.g. during disposal).
     */
    @Test
    public void testNonDeterministicAttribute() {
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
            Collection<RequestCountOfLibrary.Match> allMatches = engine.getAllMatches(RequestCountOfLibrary.Matcher.querySpecification());
            assertTrue(allMatches.size() == 1);
            RequestCountOfLibrary.Match match = allMatches.iterator().next();
            assertTrue(match.getLibrary().equals(library));
            assertTrue(match.getReqCount() == 2);
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    /**
     * Similar to {@link #testNonDeterministicAttribute()} but with a many reference.
     */
    @Test
    public void testNonDeterministicFeature() {
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine engine = new RunOnceQueryEngine(rs);
            Collection<SomeBooksWithTwoAuthors.Match> allMatches = engine.getAllMatches(SomeBooksWithTwoAuthors.Matcher.querySpecification());
            assertTrue(allMatches.size() == 1);
            SomeBooksWithTwoAuthors.Match match = allMatches.iterator().next();
            assertTrue(match.getLibrary().equals(library));
            assertTrue(match.getBook().getTitle().equals("Twin life"));

            allMatches = engine.getAllMatches(SomeBooksWithTwoAuthors.Matcher.querySpecification());
            assertTrue(allMatches.isEmpty());
            
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    /**
     * The test shows that using an incremental engine with not well-behaving derived features will return 
     * incorrect values if the model changes.
     * @throws ViatraQueryException 
     */
    @Test
    public void testModelModification() throws ViatraQueryException {
        // the results of incremental engine will not be correct
        Library library = prepareModel();
        
        try {
            WellbehavingDerivedFeatureRegistry.registerWellbehavingDerivedPackage(LibraryPackage.eINSTANCE);
            AdvancedViatraQueryEngine engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(rs));
            // this is to allow the normal engine to traverse feature
            LongSciFiBooksOfAuthor.Matcher matcher = engine.getMatcher(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            Collection<LongSciFiBooksOfAuthor.Match> allMatches = matcher.getAllMatches();
            
            RunOnceQueryEngine roengine = new RunOnceQueryEngine(rs);
            Collection<LongSciFiBooksOfAuthor.Match> allROMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            
            assertTrue(allMatches.size() == allROMatches.size());
            LongSciFiBooksOfAuthor.Match match = allMatches.iterator().next();
            LongSciFiBooksOfAuthor.Match romatch = allROMatches.iterator().next();
            assertTrue(match.getAuthor() == romatch.getAuthor());
            Book longBook = romatch.getBook();
            assertTrue(match.getBook() == longBook);
            
            Book b = LibraryFactory.eINSTANCE.createBook();
            b.setTitle("Long book");
            b.setPages(120);
            b.getCategory().add(BookCategory.SCI_FI);
            b.getAuthors().add(library.getWriters().get(0));
            library.getBooks().add(b);
            
            allROMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            allMatches = matcher.getAllMatches();
            assertTrue(allMatches.size() != allROMatches.size());
            assertTrue(allROMatches.size() == 2);
            
            Set<Book> longScifiBooks = new HashSet<Book>();
            for (LongSciFiBooksOfAuthor.Match m : allROMatches) {
                longScifiBooks.add(m.getBook());
            }
            assertTrue(longScifiBooks.contains(b));
            assertTrue(longScifiBooks.contains(longBook));
        } finally {
            WellbehavingDerivedFeatureRegistry.initRegistry();
        }
        
            
    }

    @Test
    public void testSamplingModelModification() {
     // the results of incremental engine will be correct after resampling
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine roengine = new RunOnceQueryEngine(rs);
            AdvancedViatraQueryEngine engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(rs,roengine.getBaseIndexOptions()));
            // TODO remove this once such EClasses are automatically identified
            //engine.getBaseIndex().registerEClasses(Sets.newHashSet(EIQLibraryPackage.eINSTANCE.getBook(), EIQLibraryPackage.eINSTANCE.getWriter()));
            runModelModification(library, roengine, engine);
            
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }
    
    @Test
    public void testSamplingModelModificationInWildCardMode() {
        // the results of incremental engine will be correct after resampling
        Library library = prepareModel();
        
        try {
            RunOnceQueryEngine roengine = new RunOnceQueryEngine(rs);
            BaseIndexOptions baseIndexOptions = roengine.getBaseIndexOptions();
            baseIndexOptions = baseIndexOptions.withWildcardLevel(IndexingLevel.FULL); // ensure all types are indexed
            AdvancedViatraQueryEngine engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(rs,baseIndexOptions));
            runModelModification(library, roengine, engine);
            
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    }

    private void runModelModification(Library library, RunOnceQueryEngine roengine, AdvancedViatraQueryEngine engine)
            throws ViatraQueryException {
        LongSciFiBooksOfAuthor.Matcher matcher = engine.getMatcher(LongSciFiBooksOfAuthor.Matcher.querySpecification());
        Collection<LongSciFiBooksOfAuthor.Match> allMatches = matcher.getAllMatches();
        
        Collection<LongSciFiBooksOfAuthor.Match> allROMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
        
        assertTrue(allMatches.size() == allROMatches.size());
        LongSciFiBooksOfAuthor.Match match = allMatches.iterator().next();
        LongSciFiBooksOfAuthor.Match romatch = allROMatches.iterator().next();
        assertTrue(match.getAuthor() == romatch.getAuthor());
        Book longBook = romatch.getBook();
        assertTrue(match.getBook() == longBook);

        Book b = LibraryFactory.eINSTANCE.createBook();
        b.setTitle("Long book");
        b.setPages(120);
        b.getCategory().add(BookCategory.SCI_FI);
        b.getAuthors().add(library.getWriters().get(0));
        library.getBooks().add(b);
        
        allROMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
        allMatches = matcher.getAllMatches();
        assertTrue(allMatches.size() != allROMatches.size());

        // manually resample values
        engine.getBaseIndex().resampleDerivedFeatures();
        
        allMatches = matcher.getAllMatches();
        assertTrue(allMatches.size() == allROMatches.size());
        assertTrue(allROMatches.size() == 2);
        
        Set<Book> longScifiBooks = new HashSet<Book>();
        for (LongSciFiBooksOfAuthor.Match m : allROMatches) {
            longScifiBooks.add(m.getBook());
        }
        assertTrue(longScifiBooks.contains(b));
        assertTrue(longScifiBooks.contains(longBook));
    }
    
    @Test
    public void testSamplingModelModificationChangeVisitor() {
     // the results of incremental engine will be correct after resampling
        String address = "test";
        Library library = createLibrary(address);
        String title = "test";
        Book book = createBook(library, title, 150, BookCategory.SCI_FI);
        
        try {
            RunOnceQueryEngine roengine = new RunOnceQueryEngine(library);
            AdvancedViatraQueryEngine engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(library,roengine.getBaseIndexOptions()));

            LongSciFiBooksOfAuthor.Matcher matcher = engine.getMatcher(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            Collection<LongSciFiBooksOfAuthor.Match> allMatches = matcher.getAllMatches();
            assertTrue(allMatches.isEmpty());
            
            Writer writer = createWriter(library, "test");
            book.getAuthors().add(writer);
            
            engine.getBaseIndex().resampleDerivedFeatures();
            
            allMatches = matcher.getAllMatches();
            assertTrue(!allMatches.isEmpty());
            LongSciFiBooksOfAuthor.Match match = allMatches.iterator().next();
            assertTrue(match.getAuthor().equals(writer));
            assertTrue(match.getBook().equals(book));
            
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
    
    }
    
    @Test
    public void testAutomaticSamplingModelModification() {
        // the results of run-once engine will be correct after automatic resampling
        String address = "test";
        Library library = createLibrary(address);
        String title = "test";
        Book book = createBook(library, title, 150, BookCategory.SCI_FI);
        
        try {
            RunOnceQueryEngine roengine = new RunOnceQueryEngine(library);
            roengine.setAutomaticResampling(true);
            Collection<LongSciFiBooksOfAuthor.Match> allMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            assertTrue(allMatches.isEmpty());
            
            Writer writer = createWriter(library, "test");
            book.getAuthors().add(writer);
            
            allMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            assertTrue(!allMatches.isEmpty());
            LongSciFiBooksOfAuthor.Match match = allMatches.iterator().next();
            assertTrue(match.getAuthor().equals(writer));
            assertTrue(match.getBook().equals(book));
            
            roengine.setAutomaticResampling(false);
            
            Writer writer2 = createWriter(library, "test2");
            allMatches = roengine.getAllMatches(LongSciFiBooksOfAuthor.Matcher.querySpecification());
            assertTrue(!allMatches.isEmpty());
            
        } catch (ViatraQueryException e) {
            e.printStackTrace();
            fail(e.getShortMessage());
        }
        
    }

    private Writer createWriter(Library library, String name) {
        Writer writer = LibraryFactory.eINSTANCE.createWriter();
        writer.setName(name);
        library.getWriters().add(writer);
        return writer;
    }

    private Book createBook(Library library, String title, int pages, BookCategory cat) {
        Book book = LibraryFactory.eINSTANCE.createBook();
        book.setTitle(title);
        book.setPages(pages);
        book.getCategory().add(cat);
        library.getBooks().add(book);
        return book;
    }

    private Library createLibrary(String address) {
        Library library = LibraryFactory.eINSTANCE.createLibrary();
        library.setAddress(address);
        return library;
    }
    
}
