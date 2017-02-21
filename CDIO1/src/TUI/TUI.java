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

         } while (input != 5);
     }
	
	 public void createUser() {
         try {


             display:
             while (true) {
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
                 switch (chooseRole) {
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
         } catch (DALException e)
         {
             e.printStackTrace();
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
                         userDAO.getUser(ID).setUserID(newID);
                         
                         userDAO.updateUser(userDAO.getUser(ID));
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
                         System.out.println("Bruger " +this.TempUser.getUserName());
                         this.TempUser.setUserName(newName);
                         System.out.println("Bruger " +this.TempUser.getUserName());
                         userDAO.updateUser(this.TempUser);
                         break;
                     case 3:
                         System.out.println("============================");
                         System.out.println("|   UPDATE USER INITIALS   |");
                         System.out.println("============================");
                         System.out.println("Enter user ID: ");
                         ID = scan.nextInt();
                         System.out.println("Enter new user initials: ");
                         String newIni = scan.next();
                         userDAO.getUser(ID).setIni(newIni);
                         break;
                     case 4:
                         System.out.println("============================");
                         System.out.println("|      UPDATE USER CPR     |");
                         System.out.println("============================");
                         System.out.println("Enter User ID: ");
                         ID = scan.nextInt();
                         System.out.println("Enter new user CPR: ");
                         String newCPR = scan.next();
                         userDAO.getUser(ID).setUserCpr(newCPR);
                         break;
                     case 5:
                         System.out.println("Update user password (coming soon)");
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

     
     public void listUsers(){
	    try {
            System.out.println("============================");
            System.out.println("|       LIST USERS         |");
            System.out.println("============================");

            userDAO.getUserList();
            System.out.println("Bruger 1 " + userDAO.getUserList().get(1).getUserName());
            for (int i = 0; i < userDAO.getUserList().size(); i++)
                System.out.println("User ID: " + userDAO.getUserList().get(i).getUserId() +  "\t User name: " + userDAO.getUserList().get(i).getUserName());

        } catch (Exception e)
        {
            e.printStackTrace();
        }
     }

     public void deleteUser(){
         try {

             System.out.println("============================");
             System.out.println("|       DELETE USER        |");
             System.out.println("============================");
             System.out.println("Enter user ID: ");
             int ID = scan.nextInt();
             userDAO.deleteUser(ID);
             System.out.println("User has been deleted");

         } catch (Exception e)
         {
             e.printStackTrace();
         }
     }

     public void quitProgram(){}
 
}


