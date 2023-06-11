package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.ForeignCurrencyAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import user.Client;
import interfaces.IMenu;

public class ForeignCurrencyAccountWithoutInterestMenu implements IMenu {

    private ForeignCurrencyAccountWithoutInterest foreignAccount;
    private Client client;
    private HelperIO helperIO = new HelperIO();

    public ForeignCurrencyAccountWithoutInterestMenu(ForeignCurrencyAccountWithoutInterest foreignAccount, Client client) {
        this.foreignAccount = foreignAccount;
        this.client = client;
    }

    @Override
    public void displayMenu() {
        System.out.println("------ Foreign Currency Account (USD) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void handleChoice() {
        HelperClient helperClient = new HelperClient(client);
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = helperIO.readIntegerInput();
            switch (choice) {
            case 1:
                System.out.println("Balance: " + foreignAccount.getBalance() + " " + foreignAccount.getCurrencyType());
                System.out.println();
                break;
            case 2:
                System.out.println("Select an account to make an exchange with:");
                AbstractAccount destAccount = helperClient.selectAnAccount();
                if(destAccount != null) {
                    System.out.println("Your current balance: " + foreignAccount.getBalance());
                    System.out.println("Enter exchange amount (" + foreignAccount.getCurrencyType() +") :");
                    double exchangeAmount = helperIO.readDoubleInput();
                    foreignAccount.exchange(destAccount, exchangeAmount);
                    System.out.println();
                }else {
                	System.out.println("There is no account with this id!");
                }

                break;
            case 0:
            	exit = true;
            	System.out.println();
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
      }       
    }

    @Override
    public void executeMenu() {
        handleChoice();
    }
}
