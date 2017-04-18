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
    	assertTrue(true);
    }

}
