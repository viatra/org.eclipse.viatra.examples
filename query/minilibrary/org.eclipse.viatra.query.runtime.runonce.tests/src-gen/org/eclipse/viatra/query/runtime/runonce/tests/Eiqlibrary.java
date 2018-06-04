/**
 * Generated from platform:/resource/org.eclipse.viatra.query.runtime.runonce.tests/src/org/eclipse/viatra/query/runtime/runonce/tests/eiqlibrary.vql
 */
package org.eclipse.viatra.query.runtime.runonce.tests;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.runonce.tests.BookAuthors;
import org.eclipse.viatra.query.runtime.runonce.tests.BooksWithMultipleAuthors;
import org.eclipse.viatra.query.runtime.runonce.tests.LongSciFiBooksOfAuthor;
import org.eclipse.viatra.query.runtime.runonce.tests.RequestCountOfLibrary;
import org.eclipse.viatra.query.runtime.runonce.tests.SingleAuthoredFirstBooks;
import org.eclipse.viatra.query.runtime.runonce.tests.SomeBooksWithTwoAuthors;
import org.eclipse.viatra.query.runtime.runonce.tests.SumOfPagesInLibrary;

/**
 * A pattern group formed of all public patterns defined in eiqlibrary.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file eiqlibrary.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.eclipse.viatra.query.runtime.runonce.tests, the group contains the definition of the following patterns: <ul>
 * <li>bookAuthors</li>
 * <li>booksWithMultipleAuthors</li>
 * <li>sumOfPagesInLibrary</li>
 * <li>singleAuthoredFirstBooks</li>
 * <li>longSciFiBooksOfAuthor</li>
 * <li>requestCountOfLibrary</li>
 * <li>someBooksWithTwoAuthors</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Eiqlibrary extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Eiqlibrary instance() {
    if (INSTANCE == null) {
        INSTANCE = new Eiqlibrary();
    }
    return INSTANCE;
  }
  
  private static Eiqlibrary INSTANCE;
  
  private Eiqlibrary() {
    querySpecifications.add(BookAuthors.instance());
    querySpecifications.add(BooksWithMultipleAuthors.instance());
    querySpecifications.add(SumOfPagesInLibrary.instance());
    querySpecifications.add(SingleAuthoredFirstBooks.instance());
    querySpecifications.add(LongSciFiBooksOfAuthor.instance());
    querySpecifications.add(RequestCountOfLibrary.instance());
    querySpecifications.add(SomeBooksWithTwoAuthors.instance());
  }
  
  public BookAuthors getBookAuthors() {
    return BookAuthors.instance();
  }
  
  public BookAuthors.Matcher getBookAuthors(final ViatraQueryEngine engine) {
    return BookAuthors.Matcher.on(engine);
  }
  
  public BooksWithMultipleAuthors getBooksWithMultipleAuthors() {
    return BooksWithMultipleAuthors.instance();
  }
  
  public BooksWithMultipleAuthors.Matcher getBooksWithMultipleAuthors(final ViatraQueryEngine engine) {
    return BooksWithMultipleAuthors.Matcher.on(engine);
  }
  
  public SumOfPagesInLibrary getSumOfPagesInLibrary() {
    return SumOfPagesInLibrary.instance();
  }
  
  public SumOfPagesInLibrary.Matcher getSumOfPagesInLibrary(final ViatraQueryEngine engine) {
    return SumOfPagesInLibrary.Matcher.on(engine);
  }
  
  public SingleAuthoredFirstBooks getSingleAuthoredFirstBooks() {
    return SingleAuthoredFirstBooks.instance();
  }
  
  public SingleAuthoredFirstBooks.Matcher getSingleAuthoredFirstBooks(final ViatraQueryEngine engine) {
    return SingleAuthoredFirstBooks.Matcher.on(engine);
  }
  
  public LongSciFiBooksOfAuthor getLongSciFiBooksOfAuthor() {
    return LongSciFiBooksOfAuthor.instance();
  }
  
  public LongSciFiBooksOfAuthor.Matcher getLongSciFiBooksOfAuthor(final ViatraQueryEngine engine) {
    return LongSciFiBooksOfAuthor.Matcher.on(engine);
  }
  
  public RequestCountOfLibrary getRequestCountOfLibrary() {
    return RequestCountOfLibrary.instance();
  }
  
  public RequestCountOfLibrary.Matcher getRequestCountOfLibrary(final ViatraQueryEngine engine) {
    return RequestCountOfLibrary.Matcher.on(engine);
  }
  
  public SomeBooksWithTwoAuthors getSomeBooksWithTwoAuthors() {
    return SomeBooksWithTwoAuthors.instance();
  }
  
  public SomeBooksWithTwoAuthors.Matcher getSomeBooksWithTwoAuthors(final ViatraQueryEngine engine) {
    return SomeBooksWithTwoAuthors.Matcher.on(engine);
  }
}
