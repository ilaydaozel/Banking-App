package menu;

import java.util.Scanner;
import helpers.HelperIO;
import helpers.HelperMenu;

public class InvestmentAccountMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void InvestmentAccountMenu () {
        boolean exit = false;
        while (!exit) {
            helperMenu.printInvestmentAccountMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                // Logic to buy stocks
                System.out.println("Buying stocks...");
                break;
            case 2:
                // Logic to buy funds
                System.out.println("Buying funds...");
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
