package edu.ita.maven.MIGUEL_QUESTAO8;

import java.util.ArrayList;
import java.util.List;

import edu.ita.maven.Interfaces.User;

public class Librarian 
{
	List<User> users;
	List<User> blockedUsers;
	
	public Librarian()
	{
		users = new ArrayList<User>();
		blockedUsers = new ArrayList<User>();
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
			users.remove(u);
			return blockedUsers.add(u);
		}
		return false;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
