package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.ForeignCurrencyAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import user.Client;

public class ForeignCurrencyAccountWithoutInterestMenu  {

    public ForeignCurrencyAccountWithoutInterestMenu(ForeignCurrencyAccountWithoutInterest foreignAccount, Client client) {
        Scanner scanner = new Scanner(System.in);
        HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();

        boolean exit = false;
        while (!exit) {
        	printForeignCurrencyAccounWithoutInterestMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                System.out.println("Balance: " + foreignAccount.getBalance() + " " + foreignAccount.getCurrencyType());
                break;
            case 2:
                System.out.println("Select an account to make an exchange with:");
                AbstractAccount destAccount = helperClient.selectAnAccount();
                System.out.println("Your current balance: " + foreignAccount.getBalance());
                System.out.println("Enter exchange amount (" + foreignAccount.getCurrencyType() +") :");
                double exchangeAmount = helperIO.readDoubleInput();
                foreignAccount.exchange(destAccount, exchangeAmount);
                System.out.println();
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
    
    private void printForeignCurrencyAccounWithoutInterestMenu() {
        System.out.println("------ Foreign Currency Account (USD) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

}
