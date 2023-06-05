 package menu;

import java.util.Scanner;

import application.Account;
import application.AccountGroup;
import helpers.HelperIO;
import interfaces.IMenu;
import user.Bank;
import user.Client;

public class ClientMenu implements IMenu {
	private static Scanner scanner = new Scanner(System.in);  
	private Client client;
	private static HelperIO helperIO = new HelperIO();
	
	
	public ClientMenu(Client currentClient) {
		this.client = currentClient;
	}
	
    private void clientMenu() {
        HelperIO helperIO = new HelperIO();
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    createAccountGroup();
                    break;
                case 3:
                    checkAccountBalance();
                    break;
                case 4:
                    checkAccountGroupBalance();
                    break;
                case 5:
                    checkExpectedBalance();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void printMenu() {
        System.out.println("--- Client Menu ---");
        System.out.println("Client: " + client.getUsername());
        System.out.println("1. Create Account");
        System.out.println("2. Create Account Group");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Check Account Group Balance");
        System.out.println("5. Check Expected Balance");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }
    
    
    public void accountTypeMenu() {
        System.out.println("---Main Account Types ---");
        System.out.println("1. Regular Account");
        System.out.println("2. Foreign Currency Account");
        System.out.println("3. Gold Account");
        System.out.println("4. Investment Account");
        System.out.print("Enter your choice: ");
    }
    public void accountMenu() {
        System.out.println("--- Account Types ---");
        System.out.println("1. Regular Account (TRY) without Interest");
        System.out.println("2. Regular Account (TRY) with Interest");
        System.out.println("3. Foreign Currency Account (EUR) without Interest");
        System.out.println("4. Foreign Currency Account (EUR) with Interest");
        System.out.println("5. Foreign Currency Account (USD) without Interest");
        System.out.println("6. Foreign Currency Account (USD) with Interest");
        System.out.println("7. Gold Account (XAU) without Interest");
        System.out.println("8. Gold Account (XAU) with Interest");
        System.out.println("9. Investment Account");
        System.out.print("Enter your choice: ");
    }

    private void createAccount() {
        System.out.print("Enter the account type (1-9): ");
        accountTypeMenu();
        int type = helperIO.readIntegerInput();

        if (type >= 1 && type <= 9) {
            AbstractAccount account = bank.createAccount(type);
            currentClient.addAccount(account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Invalid account type. Please try again.");
        }
        System.out.println();
    }

    public void createAccountGroup() {
        System.out.print("Enter the name of the account group: ");
        String groupName = scanner.nextLine();
        AccountGroup accountGroup = new AccountGroup(groupName);
        currentClient.addAccountGroup(accountGroup);
        System.out.println("Account group created successfully.");
        System.out.println();
    }

    private static void checkAccountBalance() {
        System.out.print("Enter the account index: ");
        int accountIndex = readIntegerInput();

        if (accountIndex >= 0 && accountIndex < currentClient.getNumAccounts()) {
            Account account = currentClient.getAccount(accountIndex);
            double balance = account.getBalance();
            System.out.println("Account Balance: " + balance);
        } else {
            System.out.println("Invalid account index. Please try again.");
        }
        System.out.println();
    }

    private static void checkAccountGroupBalance() {
        System.out.print("Enter the account group name: ");
        String groupName = scanner.nextLine();
        AccountGroup accountGroup = currentClient.getAccountGroup(groupName);

        if (accountGroup != null) {
            double balance = accountGroup.getTotalBalance();
            System.out.println("Account Group Balance (TRY): " + balance);
        } else {
            System.out.println("Account group not found. Please try again.");
        }
        System.out.println();
    }

    private static void checkExpectedBalance() {
        System.out.print("Enter the account index: ");
        int accountIndex = readIntegerInput();

        if (accountIndex >= 0 && accountIndex < currentClient.getNumAccounts()) {
            Account account = currentClient.getAccount(accountIndex);
            System.out.print("Enter the number of days in the future: ");
            int days = readIntegerInput();
            double expectedBalance = account.calculateFutureBalance(days);
            System.out.println("Expected Balance (after " + days + " days): " + expectedBalance);
        } else {
            System.out.println("Invalid account index. Please try again.");
        }
        System.out.println();
    }
}
