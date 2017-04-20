package edu.ita.maven.MIGUEL_QUESTAO8;

import edu.ita.maven.Interfaces.Book;

public class Librarian 
{
	private LibrarySystem lsys;
	
	public Librarian(LibrarySystem lsys)
	{
		this.lsys = lsys;
	}
	
	public boolean addUser(User u)
	{
		return lsys.addUser(u);
	}
	
	public boolean removeUser(User u)
	{
		return lsys.removeUser(u);
	}
	
	public boolean blockUser(User u)
	{
		return lsys.removeUser(u);
	}
	
	public boolean blockUserByLateness(User u, Book b)
	{
		return lsys.blockUserByLateness(u, b);
	}
	
	public boolean blockUserByDebit(User u)
	{
		return lsys.blockUserByDebit(u);
	}
	
	public String checkBook(Book b)
	{
		return lsys.bookSituation(b);
	}
	
	public boolean addLoan(Book b, User u)
	{
		return lsys.addLoan(b, u);
	}
	
	public boolean removeLoan(Book b, User u)
	{
		return lsys.removeLoan(b, u);
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

}
