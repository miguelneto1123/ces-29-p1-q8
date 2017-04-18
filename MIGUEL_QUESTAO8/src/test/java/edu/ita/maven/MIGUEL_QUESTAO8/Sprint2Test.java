package edu.ita.maven.MIGUEL_QUESTAO8;

import static org.mockito.Mockito.mock;

import edu.ita.maven.Interfaces.Book;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Sprint2Test extends TestCase {
    Librarian lib;
    LibrarySystem lsys;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Sprint2Test( String testName )
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
        return new TestSuite( Sprint2Test.class );
    }
    
    /**
     * From here on we'll have the tests. Please note that every
     * test must begin with test* so that maven-surefire-plugin
     * tests it
     */
	public void testAddLoan(){
		User u1 = new User();
		User u2 = new User();
		Book b1 = mock(Book.class);
		Book b2 = mock(Book.class);
		
		lsys.addBook(b1);
		lsys.addBook(b2);
		
		lib.addUser(u1);
		lib.addUser(u2);
		lib.blockUser(u2);
		
		assertTrue(lib.addLoan(b1,u1));
		assertFalse(lib.addLoan(b2, u2));
	}
	
	public void testRemoveLoan(){
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
		lib.addLoan(b1, u1);
		
		assertTrue(lib.removeLoan(b1,u1));
		assertFalse(lib.removeLoan(b2, u2));
		assertFalse(lib.removeLoan(b3,u3));
	}

}
