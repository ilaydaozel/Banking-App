package menu;

import account.AccountGroup;
import helpers.HelperIO;
import helpers.HelperMenu;
import interfaces.IMenu;

public class AccountGroupMenu implements IMenu {

    private AccountGroup account;
    private HelperIO helperIO = new HelperIO();

    public AccountGroupMenu(AccountGroup account) {
        this.account = account;
    }

    @Override
    public void displayMenu() {
        printAccountGroupMenu();
    }

    @Override
    public void handleChoice() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + account.getTotalAccountGroupBalance());
                    System.out.println();
                    break;
                case 0:
                    exit = true;
                    System.out.println();
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

    private void printAccountGroupMenu() {
        System.out.println("------ Account Group Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
    }
}

