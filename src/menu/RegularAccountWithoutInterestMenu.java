
package menu;

import account.AbstractAccount;
import account.RegularAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import interfaces.IMenu;
import user.Client;

public class RegularAccountWithoutInterestMenu implements IMenu {

    private RegularAccountWithoutInterest account;
    private Client client;

    public RegularAccountWithoutInterestMenu(RegularAccountWithoutInterest account, Client client) {
        this.account = account;
        this.client = client;
    }

    @Override
    public void displayMenu() {
        System.out.println("------ Regular Account (TRY) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Exchange");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void handleChoice() {
        HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();
        
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
                    System.out.println("Enter the amount to deposit:");
                    double amount = helperIO.readDoubleInput();
                    System.out.println("Depositing money...");
                    account.deposit(amount);
                    System.out.println("New balance: " + account.getBalance());
                    System.out.println();
                    break;
                case 3:
                	System.out.println();
                    System.out.println("You can exchange to...");
                    System.out.println("Regular Account With Interest");
                    System.out.println("All accounts without interest");
                    System.out.println("Investment Account");
                    System.out.println();
                    System.out.println("Select an account to make an exchange to:");
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
