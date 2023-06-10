package menu;

import account.AbstractAccount;
import account.GoldAccountWithInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import user.Client;

public class GoldAccountWithInterestMenu  {
	
    public void GoldAccountWithInterestMenu (GoldAccountWithInterest goldAccount, Client client) {
        HelperIO helperIO = new HelperIO();
        HelperClient helperClient = new HelperClient(client);
        boolean exit = false;
        while (!exit) {
        	printGoldAccountWithInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
                System.out.println("Balance: " + goldAccount.getBalance());
                break;
            case 2:
                System.out.println("Select an account to make an exchange with:");
                AbstractAccount destAccount = helperClient.selectAnAccount();
                System.out.println("Enter exchange amount (XAU):");
                double exchangeAmount = helperIO.readDoubleInput();
                goldAccount.exchange(destAccount, exchangeAmount);
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        }
    }

    private void printGoldAccountWithInterestMenu() {
        System.out.println("------ Gold Account (XAU) with Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange to another account (XAU with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
        }
    
}

