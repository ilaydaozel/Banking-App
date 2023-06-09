package menu;

import java.util.Scanner;

import account.RegularAccountWithInterest;
import account.RegularAccountWithoutInterest;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class RegularAccountTRYWithoutInterestMenu {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void displayRegularAccountTRYWithoutInterestMenu(RegularAccountWithoutInterest account) {
        boolean exit = false;
        while (!exit) {
            helperMenu.printRegularAccountTRYWithoutInterestMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            	case 1:
                	System.out.println("Balance:" + account.getBalance());
                	
                    break;
                case 2:
                    // Logic to deposit money
                	System.out.println("Enter the amount to deposit:");
                	double amount = helperIO.readDoubleInput();
                    System.out.println("Depositing money...");
                    account.deposit(amount);
                    System.out.println("New balance:"+ account.getBalance());                   
                    break;
                case 3:
                    // Go back to the main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Similar classes for other account menus
