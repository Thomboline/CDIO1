package tui;

import dto.IUserDTO;
import dto.UserDTO;

import java.util.Scanner;

/**
 * Created by jonathanlarsen on 14/02/2017.
 */

public class TUI implements ITUI{


        IUserDTO TUI2Func = new UserDTO();


        int input;

        Scanner scan = new Scanner(System.in);

        public void startOperation() {

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

        public void createUser(){

            display: while(true) {

                System.out.println("Create User");
                System.out.println("Type userID: ");
                int ID = scan.nextInt();
                TUI2Func.setUserID(ID);

                System.out.println("Type user name: ");
                String name = scan.nextLine();
                TUI2Func.setUserName(name);

                System.out.println("Type initials: ");
                String ini = scan.nextLine();
                TUI2Func.setIni(ini);

                System.out.println("Type user CPR: ");
                String CPR = scan.nextLine();
                TUI2Func.setUserCpr(CPR);

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
                        TUI2Func.addRole(); //set Operator
                        break;
                    case 2:
                        TUI2Func.addRole(); //set Foreman
                        break;
                    case 3:
                        TUI2Func.addRole(); //set Pharmacist
                        break;
                    case 4:
                        System.out.println("Returning...");
                        break display;
                    default:
                        System.out.println("Invalid entry");
                        break;

                }
            }

        }
        public void updateUser(){

            display: while (true) {

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
                switch (chooseUpdate) {
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
