package edu.ita.maven.MIGUEL_QUESTAO8;

import static org.mockito.Mockito.mock;

import edu.ita.maven.Interfaces.Book;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Sprint3Test extends TestCase {
    Librarian lib;
    LibrarySystem lsys;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Sprint3Test( String testName )
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
        return new TestSuite( Sprint3Test.class );
    }
    
    /**
     * From here on we'll have the tests. Please note that every
     * test must begin with test* so that maven-surefire-plugin
     * tests it
     */
	
    public void testCheckBook()
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
		lsys.loseBook(b3);
		
		assertEquals("Available", u1.checkBookOnSystem(b1, lsys));
		assertEquals("Loaned", u1.checkBookOnSystem(b2, lsys));
		assertEquals("Lost", u1.checkBookOnSystem(b3, lsys));
    }

}
