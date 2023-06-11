package menu;


import account.AbstractAccount;
import account.GoldAccountWithoutInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import interfaces.IMenu;
import user.Client;

public class GoldAccountWithoutInterestMenu implements IMenu {

    private GoldAccountWithoutInterest goldAccount;
    private Client client;

    public GoldAccountWithoutInterestMenu(GoldAccountWithoutInterest goldAccount, Client client) {
        this.goldAccount = goldAccount;
        this.client = client;
    }

    @Override
    public void displayMenu() {
        System.out.println("------ Gold Account (XAU) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Exchange");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void handleChoice() {
        HelperIO helperIO = new HelperIO();
        HelperClient helperClient = new HelperClient(client);
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + goldAccount.getBalance() + " " + goldAccount.getCurrencyType());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Select an account to make an exchange with:");
                    AbstractAccount destAccount = helperClient.selectAnAccount();
                    if(destAccount != null) {
                        System.out.println("Your current balance: " + goldAccount.getBalance());
                        System.out.println("Enter exchange amount (XAU):");
                        double exchangeAmount = helperIO.readDoubleInput();
                        goldAccount.exchange(destAccount, exchangeAmount);
                        System.out.println();	
                    }else {
                    	System.out.println("There is no account with this id!");
                    }
                    break;
                case 0:
                    exit = true;
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
