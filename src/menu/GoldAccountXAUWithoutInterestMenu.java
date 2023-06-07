package menu;

import java.util.Scanner;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class GoldAccountXAUWithoutInterestMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void GoldAccountXAUWithoutInterestMenu () {
        boolean exit = false;
        while (!exit) {
            helperMenu.printGoldAccountXAUWithoutInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                // Logic to exchange to a TRY account
                System.out.println("Exchanging to a TRY account...");
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
