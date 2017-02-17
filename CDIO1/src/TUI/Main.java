package TUI;

import dal.IUserDAO;
import dal.UserDAO;

public class Main 
{
	public static void main(String[] args) 
	{
		ITUI userInterface = new TUI();
		userInterface.startOperation(new UserDAO());
		
		
		
	}

}
