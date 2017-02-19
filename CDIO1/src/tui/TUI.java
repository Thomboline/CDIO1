package tui;

import java.util.Scanner;

/**
 * Created by jonathanlarsen on 14/02/2017.
 */
public class TUI {

        int input;

        Scanner scan = new Scanner(System.in);

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
                    System.out.println("Create User");
                    break;
                case 2:
                    System.out.println("Update User");
                    break;
                case 3:
                    System.out.println("Delete User");
                    break;
                case 4:
                    System.out.println("List Users");
                    break;
                case 5:
                    System.out.println("System closed");
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }

        } while (input != 5);
    }
