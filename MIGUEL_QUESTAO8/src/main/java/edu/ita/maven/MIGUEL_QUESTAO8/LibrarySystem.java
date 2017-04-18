package edu.ita.maven.MIGUEL_QUESTAO8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ita.maven.Interfaces.Book;

public class LibrarySystem {
	private List<Book> availableBooks;
	private List<Book> loanedBooks;
	private List<Book> lostBooks;
	private List<User> users;
	private List<User> blockedUsers;
	private Map<Book, User> loans; // A BOOK CAN ONLY BE LOANED TO ONE PERSON!
	
	public LibrarySystem()
	{
		availableBooks = new ArrayList<Book>();
		loanedBooks = new ArrayList<Book>();
		lostBooks = new ArrayList<Book>();
		users = new ArrayList<User>();
		blockedUsers = new ArrayList<User>();
		loans = new HashMap<Book, User>();
	}
	
	public boolean addUser(User u)
	{
		return users.add(u);
	}
	
	public boolean removeUser(User u)
	{
		return users.remove(u);
	}
	
	public boolean addBook(Book b)
	{
		return availableBooks.add(b);
	}
	
	//------ Only for the sake of testing!
	public boolean loseBook(Book b)
	{
		if (loanedBooks.contains(b))
		{
			loanedBooks.remove(b);
			return lostBooks.add(b);
		}
		return false;
	}
	
	public boolean blockUser(User u)
	{
		if (users.contains(u))
		{
			users.remove(u);
			return blockedUsers.add(u);
		}
		return false;
	}
	
	public boolean addLoan(Book b, User u)
	{
		if (users.contains(u) && !blockedUsers.contains(u) && availableBooks.contains(b)){
			loans.put(b, u);
			availableBooks.remove(b);
			loanedBooks.add(b);
			return true;
		}
		return false;
	}
	
	public boolean removeLoan(Book b, User u)
	{
		if (users.contains(u))
			if (loans.containsKey(b)){
				loans.remove(b);
				availableBooks.add(b);
				loanedBooks.remove(b);
				return true;
			}
		return false;
	}
	
	public String bookSituation(Book b)
	{
		if (availableBooks.contains(b))
			return "Available";
		else if (loanedBooks.contains(b))
			return "Loaned";
		else if (lostBooks.contains(b))
			return "Lost";
		else
			return "Inexistent";
	}

}
