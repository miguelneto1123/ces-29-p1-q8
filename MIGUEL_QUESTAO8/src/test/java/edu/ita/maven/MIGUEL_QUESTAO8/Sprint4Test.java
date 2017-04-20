package edu.ita.maven.MIGUEL_QUESTAO8;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.ita.maven.Interfaces.Book;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Sprint4Test extends TestCase {
    Librarian lib;
    LibrarySystem lsys;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Sprint4Test( String testName )
    {
        super( testName );
        lsys = new LibrarySystem();
        lib = new Librarian(lsys);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Sprint4Test.class );
    }
    
    /**
     * From here on we'll have the tests. Please note that every
     * test must begin with test* so that maven-surefire-plugin
     * tests it
     */
	
    public void testStatus()
    {
    	User u1 = new User();
    	User u2 = new User();
    	User u3 = new User();

		Book b1 = mock(Book.class);
		Book b2 = mock(Book.class);
		Book b3 = mock(Book.class);
		
		lsys.addBook(b1);
		lsys.addBook(b2);
		lsys.addBook(b3);
		lib.addUser(u1);
		lib.addUser(u2);
		lib.addUser(u3);
		
		lib.addLoan(b2, u2);
		lib.addLoan(b3, u3);
		lsys.blockUserByDebit(u3);
		lsys.blockUserByLateness(u2, b2);
		
		assertEquals("Normal", u1.checkMyself(lsys));
		assertEquals("Debit blocked", u3.checkMyself(lsys));
		assertEquals("Late loan blocked", u2.checkMyself(lsys));
    }
    
    public void testLoanList()
    {
    	User u = new User();
    	
    	Book b1 = mock(Book.class);
    	Book b2 = mock(Book.class);
    	Book b3 = mock(Book.class);
		
		lsys.addBook(b1);
		lsys.addBook(b2);
		lsys.addBook(b3);
		lsys.addUser(u);
		
		lib.addLoan(b1, u);
		lib.addLoan(b2, u);
		lib.addLoan(b3, u);
		
		List<Book> l = new ArrayList<Book>();
		l.add(b1);
		l.add(b2);
		l.add(b3);
		
		assertEquals(l.size(), u.myLoans(lsys).size());
		assertTrue(u.myLoans(lsys).containsAll(l));
    }

}