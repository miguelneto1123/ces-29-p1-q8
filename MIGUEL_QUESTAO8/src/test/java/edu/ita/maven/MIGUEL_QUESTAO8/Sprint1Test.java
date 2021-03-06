package edu.ita.maven.MIGUEL_QUESTAO8;

import static org.mockito.Mockito.mock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Sprint1Test extends TestCase {
    Librarian lib;
    LibrarySystem lsys;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Sprint1Test( String testName )
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
        return new TestSuite( Sprint1Test.class );
    }
    
    /**
     * From here on we'll have the tests. Please note that every
     * test must begin with test* so that maven-surefire-plugin
     * tests it
     */
	public void testAddUser(){
		User u = mock(User.class);
		assertTrue(lib.addUser(u));
	}
	
	public void testRemoveUser(){
		User u1 = new User();
		User u2 = new User();
		lib.addUser(u1);
		assertTrue(lib.removeUser(u1));
		assertFalse(lib.removeUser(u2));
	}
	
	public void testBlockUser()
	{
		User u1 = new User();
		User u2 = new User();
		lib.addUser(u1);
		assertTrue(lib.blockUser(u1));
		assertFalse(lib.blockUser(u2));
	}

}
