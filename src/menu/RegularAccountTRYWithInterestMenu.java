package menu;

import java.util.Scanner;

import account.RegularAccountWithInterest;
import helpers.HelperIO;
import helpers.HelperMenu;

public class RegularAccountTRYWithInterestMenu  {
    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void RegularAccountTRYWithInterestMenu(RegularAccountWithInterest account) {
        boolean exit = false;
        while (!exit) {
            helperMenu.printRegularAccountTRYWithInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                	System.out.print("Balance:");
                	account.getBalance();
                    break;
                case 2:
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
