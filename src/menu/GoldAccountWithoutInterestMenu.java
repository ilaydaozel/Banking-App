package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.GoldAccountWithInterest;
import account.GoldAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class GoldAccountWithoutInterestMenu  {

    public GoldAccountWithoutInterestMenu(GoldAccountWithoutInterest goldAccount, Client client) {
        HelperIO helperIO = new HelperIO();
        HelperClient helperClient = new HelperClient(client);
        boolean exit = false;
        while (!exit) {
        	printGoldAccountWithoutInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
            	System.out.println("Balance: " + goldAccount.getBalance() + " " + goldAccount.getCurrencyType());
                System.out.println();
                break;
            case 2:
                System.out.println("Select an account to make an exchange with:");
                AbstractAccount destAccount = helperClient.selectAnAccount();
                System.out.println("Your current balance: " + goldAccount.getBalance());
                System.out.println("Enter exchange amount (XAU):");
                double exchangeAmount = helperIO.readDoubleInput();
                goldAccount.exchange(destAccount, exchangeAmount);
                System.out.println();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        }
    }
    private void printGoldAccountWithoutInterestMenu() {
        System.out.println("------ Gold Account (XAU) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }
}
