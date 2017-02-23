package TUI;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import dal.IUserDAO;
import dal.IUserDAO.DALException;
import dto.IUserDTO;
import dto.UserDTO;

public class TUI implements ITUI 
{
	private IUserDAO userDAO;
	IUserDTO TempUser = new UserDTO();

    int input;

    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
	
	public void startOperation (IUserDAO userDAO)
	{	
		
		do {
			try {
			this.userDAO = userDAO;
		
             System.out.println("============================");
             System.out.println("|       MENU SELECTION     |");
             System.out.println("============================");
             System.out.println("| Options:                 |");
             System.out.println("|        1. Create User    |");
             System.out.println("|        2. Update User    |");
             System.out.println("|        3. Delete User    |");
             System.out.println("|        4. List Users     |");
             System.out.println("|        5. Exit           |");
             System.out.println("============================");
             
             input = scan.nextInt();
             	 
             switch (input) {
                 case 1:
					 createUser();
                     break;
                 case 2:
                     updateUser();
                     break;
                 case 3:
                     deleteUser();
                     break;
                 case 4:
                     listUsers();
                     break;
                 case 5:
                     quitProgram();
                     break;
                 default:
                     System.out.println("Invalid entry");
                     break;
             }
        
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch. Please try again.");
	   		} 
			
			scan.nextLine();
			
		} while (input != 5);			
	}
		
	
	//Create user metode. Benytter sig af createUserIteration() til de forskellige trin.
	public void createUser() {

		int step = 1;
		boolean cont = true;

		System.out.println("============================");
		System.out.println("|        CREATE USER       |");
		System.out.println("============================\n");
		
		while (cont) {

			try {
				cont = createUserIteration(step);
				step++;
			} catch (TUIException e) {
				step = e.getType();
				System.out.println(e.getMessage());
			}
		}

		try {
			userDAO.createUser(TempUser);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	
     public void updateUser()
     {
         try {

             display:
             while (true) {

                 System.out.println("============================");
                 System.out.println("|     UPDATE SELECTION     |");
                 System.out.println("============================");
                 System.out.println("| Updates:                 |");
                 System.out.println("|      1. User ID          |");
                 System.out.println("|      2. User name        |");
                 System.out.println("|      3. User initials    |");
                 System.out.println("|      4. User CPR         |");
                 System.out.println("|      5. User Password    |");
                 System.out.println("|      6. Return           |");
                 System.out.println("============================");

                 int chooseUpdate = scan.nextInt();
                 int ID;

                 switch (chooseUpdate) {
                     case 1:
                         System.out.println("============================");
                         System.out.println("|      UPDATE USER ID      |");
                         System.out.println("============================");
                         
                         System.out.println("Enter user ID: ");
                         ID = scan.nextInt();
                         
                         System.out.println("Enter new user ID: ");
                         int newID = scan.nextInt();
                         
                         this.TempUser = userDAO.getUser(ID);
                         this.TempUser.setUserID(newID);
                         
                         userDAO.updateUser(this.TempUser, 2);
                         
                         break;
                     case 2:
                         System.out.println("============================");
                         System.out.println("|     UPDATE USER NAME     |");
                         System.out.println("============================");
                         
                         System.out.println("Enter user ID: ");
                         ID = scan.nextInt();
                         
                         System.out.println("Enter new user name: ");
                         String newName = scan.next();
                         
                         this.TempUser = userDAO.getUser(ID);
                         this.TempUser.setUserName(newName);
                         userDAO.updateUser(this.TempUser, 1);
                         
                         break;
                     case 3:
                         System.out.println("============================");
                         System.out.println("|   UPDATE USER INITIALS   |");
                         System.out.println("============================");
                         
                         System.out.println("Enter user ID: ");
                         ID = scan.nextInt();
                         
                         System.out.println("Enter new user initials: ");
                         String newIni = scan.next();
                         
                         this.TempUser = userDAO.getUser(ID);
                         this.TempUser.setIni(newIni);
                         userDAO.updateUser(this.TempUser, 1);
                         
                         break;
                     case 4:
                         System.out.println("============================");
                         System.out.println("|      UPDATE USER CPR     |");
                         System.out.println("============================");
                         
                         System.out.println("Enter User ID: ");
                         ID = scan.nextInt();
                         
                         System.out.println("Enter new user CPR: ");
                         String newCPR = scan.next();
                         
                         this.TempUser = userDAO.getUser(ID);
                         this.TempUser.setUserCpr(newCPR);
                         userDAO.updateUser(this.TempUser, 1);
                         
                         break;
                     case 5:
                    	 System.out.println("============================");
                         System.out.println("|    UPDATE USER PASSWORD   |");
                         System.out.println("============================");
                         
                         System.out.println("Enter User ID: ");
                         ID = scan.nextInt();
                         
                         this.TempUser = userDAO.getUser(ID);
                         userDAO.updateUser(this.TempUser, 3);
                         
                         break;
                     case 6:
                         System.out.println("Returning...");
                         break display;
                 }

             }
         } catch (Exception e)
         {
             e.printStackTrace();
         }
     }

     
	public void listUsers() {
		try {
			System.out.println("============================");
			System.out.println("|       LIST USERS         |");
			System.out.println("============================");

			for (int i = 0; i < userDAO.getUserList().size(); i++)
				System.out.println("User ID: " + userDAO.getUserList().get(i).getUserId() + "\t User name: "
						+ userDAO.getUserList().get(i).getUserName());

		} catch (DALException e) {
			e.printStackTrace();
		}
	}
     
	public void listID() {
		try {
			System.out.print("Unavailable user IDs: {");
			for (int i = 0; i < userDAO.getUserList().size(); i++) {
				System.out.print(userDAO.getUserList().get(i).getUserId() + ", ");
			}
			System.out.print("...}");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser() {
		try {

			System.out.println("============================");
			System.out.println("|       DELETE USER        |");
			System.out.println("============================");
			System.out.println("Enter user ID: ");
			int ID = scan.nextInt();
			userDAO.deleteUser(ID);
			System.out.println("User has been deleted");

		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
     
	public boolean createUserIteration(int step) throws TUIException {

		boolean cont = true;
		String errorMessage = null;
		display:

		try {
			switch (step) {

			case 1:
				errorMessage = "Input mismatch. Please try again.\n";
				listID();
				System.out.println("Type userID: ");
				int ID = scan.nextInt();
				TempUser.setUserID(ID);
				break;

			case 2:
				System.out.println("Type user name: ");
				String name = scan2.nextLine();
				TempUser.setUserName(name);
				break;

			case 3:
				System.out.println("Type initials: ");
				String ini = scan.next();
				TempUser.setIni(ini);
				break;

			case 4:
				System.out.println("Type user CPR: ");
				String CPR = scan.next();
				TempUser.setUserCpr(CPR);
				break;

			case 5:
				System.out.println("============================");
				System.out.println("|       ROLE SELECTION     |");
				System.out.println("============================");
				System.out.println("| Roles:                   |");
				System.out.println("|      1. Operator         |");
				System.out.println("|      2. Foreman          |");
				System.out.println("|      3. Pharmacist       |");
				System.out.println("|      4. Return           |");
				System.out.println("============================");

				int chooseRole = scan.nextInt();
				switch (chooseRole) {
				case 1:
					TempUser.addRole("Operator"); // set Operator
					break;
				case 2:
					TempUser.addRole("Foreman"); // set Foreman
					break;
				case 3:
					TempUser.addRole("Pharmacist"); // set Pharmacist
					break;
				case 4:

					System.out.println("Returning...");
					break display;
				default:
					System.out.println("Invalid entry");
					break;
				}
				break;

			case 6:
				cont = false;
				break;

			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			throw new TUIException(errorMessage, step);
		} 
		return cont;
	}


     public void quitProgram(){}
 
}


