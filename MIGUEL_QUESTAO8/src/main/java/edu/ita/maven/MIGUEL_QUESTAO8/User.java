package edu.ita.maven.MIGUEL_QUESTAO8;

import edu.ita.maven.Interfaces.Book;

public class User {
	public String checkBookOnSystem(Book b, LibrarySystem lsys)
	{
		return lsys.bookSituation(b);
	}
}
