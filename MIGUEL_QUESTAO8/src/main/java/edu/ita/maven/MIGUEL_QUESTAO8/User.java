package edu.ita.maven.MIGUEL_QUESTAO8;

import java.util.List;

import edu.ita.maven.Interfaces.Book;

public class User {
	public String checkBookOnSystem(Book b, LibrarySystem lsys)
	{
		return lsys.bookSituation(b);
	}
	
	public String checkMyself(LibrarySystem lsys)
	{
		return lsys.userStatus(this);
	}
	
	public List<Book> myLoans(LibrarySystem lsys)
	{
		return lsys.loansList(this);
	}
}
