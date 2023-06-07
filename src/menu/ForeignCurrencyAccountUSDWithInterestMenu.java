package menu;

import java.util.Scanner;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class ForeignCurrencyAccountUSDWithInterestMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void ForeignCurrencyAccountUSDWithInterestMenu () {
        boolean exit = false;
        while (!exit) {
            helperMenu.printForeignCurrencyAccountUSDWithInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                // Logic to exchange to another account (USD with interest)
                System.out.println("Exchanging to another account (USD with interest)...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        }
    }
}

// Similar classes for other account menus
