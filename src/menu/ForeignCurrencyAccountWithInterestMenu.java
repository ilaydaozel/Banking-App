package menu;

import account.AbstractAccount;
import account.ForeignCurrencyAccountWithInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import user.Client;

public class ForeignCurrencyAccountWithInterestMenu {

    public ForeignCurrencyAccountWithInterestMenu(ForeignCurrencyAccountWithInterest foreignAccount, Client client) {
        HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();

        boolean exit = false;
        while (!exit) {
            printForeignCurrencyAccountWithInterestMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + foreignAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Select an account to make an exchange with:");
                    AbstractAccount destAccount = helperClient.selectAnAccount();
                    System.out.println("Enter exchange amount (" + foreignAccount.getCurrencyType() +") :");
                    double exchangeAmount = helperIO.readDoubleInput();
                    foreignAccount.exchange(destAccount, exchangeAmount);
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
    
    private void printForeignCurrencyAccountWithInterestMenu() {
        System.out.println("------ Foreign Currency Account (USD) with Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

}
