package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.ForeignCurrencyAccountWithInterest;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class ForeignCurrencyAccountWithoutInterestMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void ForeignCurrencyAccountEURWithoutInterestMenu (ForeignCurrencyAccountWithInterest foreignAccount) {
        boolean exit = false;
        while (!exit) {
            helperMenu.printForeignCurrencyAccountEURWithoutInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                // Logic to exchange to a TRY account
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
