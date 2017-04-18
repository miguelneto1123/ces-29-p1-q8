package edu.ita.maven.MIGUEL_QUESTAO8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ita.maven.Interfaces.Book;
import edu.ita.maven.Interfaces.User;

public class Librarian 
{
	private List<User> users;
	private List<User> blockedUsers;
	private Map<Book, User> loans; // A BOOK CAN ONLY BE LOANED TO ONE PERSON!
	
	public Librarian()
	{
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
	
	public boolean blockUser(User u)
	{
		if (users.contains(u))
		{
			return blockedUsers.add(u);
		}
		return false;
	}
	
	public boolean addLoan(Book b, User u)
	{
		if (users.contains(u) && !blockedUsers.contains(u)){
			loans.put(b, u);
			return true;
		}
		return false;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public boolean removeLoan(Book b, User u)
	{
		if (users.contains(u))
			if (loans.containsKey(b)){
				loans.remove(b);
				return true;
			}
		return false;
	}
}
