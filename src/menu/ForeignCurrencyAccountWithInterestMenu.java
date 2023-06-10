import java.util.Scanner;

import account.AbstractAccount;
import account.ForeignCurrencyAccountWithInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class ForeignCurrencyAccountWithInterestMenu {

    public ForeignCurrencyAccountWithInterestMenu(ForeignCurrencyAccountWithInterest account, Client client) {
        HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();
        HelperMenu helperMenu = new HelperMenu();

        boolean exit = false;
        while (!exit) {
            helperMenu.printForeignCurrencyAccountWithInterestMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Select an account to make an exchange with:");
                    AbstractAccount destAccount = helperClient.selectAnAccount();
                    System.out.println("Enter exchange amount (TRY):");
                    double exchangeAmount = helperIO.readDoubleInput();
                    account.exchange(destAccount, exchangeAmount);
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
