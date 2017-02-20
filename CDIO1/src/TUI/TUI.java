package TUI;

import java.util.Scanner;

import dal.IUserDAO;
import dal.IUserDAO.DALException;
import dal.UserDAO;
import dto.IUserDTO;
import dto.UserDTO;

public class TUI implements ITUI 
{
	private IUserDAO userDAO;
	IUserDTO TempUser = new UserDTO();

    int input;

    Scanner scan = new Scanner(System.in);
	
	
	public void startOperation(IUserDAO userDAO) 
	{
		this.userDAO = userDAO;
		 do {
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
				try 
				{
					createUser();
				} catch (DALException e) 
				{
					e.printStackTrace();
				}
                     break;
                 case 2:
                     System.out.println("Update User");
                     updateUser();
                     break;
                 case 3:
                     System.out.println("Delete User");
                     deleteUser();
                     break;
                 case 4:
                     System.out.println("List Users");
                     listUsers();
                     break;
                 case 5:
                     System.out.println("System closed");
                     quitProgram();
                     break;
                 default:
                     System.out.println("Invalid entry");
                     break;
             }

         } while (input != 5);
     }
	
	 public void createUser() throws DALException
	 {
		 

         display: while(true) 
         {
             System.out.println("Create User");
             System.out.println("Type userID: ");
             int ID = scan.nextInt();
             TempUser.setUserID(ID);

             System.out.println("Type user name: ");
             String name = scan.next();
             TempUser.setUserName(name);

             System.out.println("Type initials: ");
             String ini = scan.next();
             TempUser.setIni(ini);

             System.out.println("Type user CPR: ");
             String CPR = scan.next();
             TempUser.setUserCpr(CPR);

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
             switch (chooseRole) 
             {
                 case 1:
                	 TempUser.addRole("Operator"); //set Operator
                     break;
                 case 2:
                	 TempUser.addRole("Foreman"); //set Foreman
                     break;
                 case 3:
                	 TempUser.addRole("Pharmacist"); //set Pharmacist
                     break;
                 case 4:
                     System.out.println("Returning...");
                     break display;
                 default:
                     System.out.println("Invalid entry");
                     break;
             }
            break;
         }
	 	userDAO.createUser(TempUser);
	 	userDAO.getUserList().get(0).
     }
	 
     public void updateUser()
     {
         display: while (true) 
         {

             System.out.println("============================");
             System.out.println("|     UPDATE SELECTION     |");
             System.out.println("============================");
             System.out.println("| Updates:                 |");
             System.out.println("|      1. User ID          |");
             System.out.println("|      2. User name        |");
             System.out.println("|      3. User initials    |");
             System.out.println("|      4. User CPR         |");
             System.out.println("|      5. Return           |");
             System.out.println("============================");

             int chooseUpdate = scan.nextInt();
             switch (chooseUpdate) 
             {
                 case 1:
                     System.out.println("Update user ID (coming soon)");
                     break;
                 case 2:
                     System.out.println("Update user name (coming soon)");
                     break;
                 case 3:
                     System.out.println("Update user initials (coming soon)");
                     break;
                 case 4:
                     System.out.println("Update user CPR (coming soon)");
                     break;
                 case 5:
                     System.out.println("Returning...");
                     break display;
             }

         }
     }

     
     public void listUsers(){}

     public void deleteUser(){}

     public void quitProgram(){}
 
}


