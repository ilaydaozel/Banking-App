package menu;

import account.AbstractAccount;
import account.RegularAccountWithInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import interfaces.IMenu;
import user.Client;

public class RegularAccountWithInterestMenu implements IMenu {

    private RegularAccountWithInterest account;
    private Client client;
    private HelperIO helperIO = new HelperIO();

    public RegularAccountWithInterestMenu(RegularAccountWithInterest account, Client client) {
        this.account = account;
        this.client = client;
    }

    @Override
    public void displayMenu() {
        System.out.println("------ Regular Account (TRY) with Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("3. See expected balance");
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
                System.out.println("Balance: " + account.getBalance() + " " + account.getCurrencyType());
                System.out.println();
                break;
            case 2:
                System.out.println("Select an account without interest to make an exchange to:");
                AbstractAccount destAccount = helperClient.selectAnAccount();
                if(destAccount != null) {
                    System.out.println("Your current balance: " + account.getBalance());
                    System.out.println("Enter exchange amount (TRY):");
                    double exchangeAmount = helperIO.readDoubleInput();
                    account.exchange(destAccount, exchangeAmount);
                    System.out.println();	
                }else {
                	System.out.println("There is no account with this id!");
                }

                break;
            case 3:
                System.out.println("Enter a day amount to calculate the expected balance:");
                int dayAmount = helperIO.readIntegerInput();
                double expectedAmount = account.checkExpectedBalance(dayAmount);
                System.out.println("The balance is expected to be " + expectedAmount + " " + account.getCurrencyType() + " after " + dayAmount + " days.");
                System.out.println();
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


