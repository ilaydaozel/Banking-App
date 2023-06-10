package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.RegularAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import user.Client;

public class RegularAccountTRYWithoutInterestMenu {

    public RegularAccountTRYWithoutInterestMenu(RegularAccountWithoutInterest account, Client client) {
    	HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();
        
        boolean exit = false;
        while (!exit) {
            printRegularAccountTRYWithoutInterestMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            	case 1:
                	System.out.println("Balance:" + account.getBalance());
                	
                    break;
                case 2:
                    // Logic to deposit money
                	System.out.println("Enter the amount to deposit:");
                	double amount = helperIO.readDoubleInput();
                    System.out.println("Depositing money...");
                    account.deposit(amount);
                    System.out.println("New balance:"+ account.getBalance());                   
                    break;
                case 3:
                	System.out.println("Select a regular account without interest to make exchange to:");
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
    private void printRegularAccountTRYWithoutInterestMenu() {
        System.out.println("------ Regular Account (TRY) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Exchange");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
    }
    
}

