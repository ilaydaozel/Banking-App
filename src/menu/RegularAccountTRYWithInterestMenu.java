package menu;

import java.util.Scanner;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class RegularAccountTRYWithInterestMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void RegularAccountTRYWithInterestMenu () {
        boolean exit = false;
        while (!exit) {
            helperMenu.printRegularAccountTRYWithInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    // Logic to deposit money
                    System.out.println("Depositing money...");
                    break;
                case 0:
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
