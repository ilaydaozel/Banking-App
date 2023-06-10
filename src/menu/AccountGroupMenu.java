package menu;
import account.AccountGroup;
import helpers.HelperIO;
import helpers.HelperMenu;

public class AccountGroupMenu {
    public AccountGroupMenu(AccountGroup account) {
    	HelperIO helperIO = new HelperIO();
    	
        boolean exit = false;
        while (!exit) {
            printAccountGroupMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                	System.out.println("Balance:" + account.getTotalAccountGroupBalance());
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

	private void printAccountGroupMenu() {
	    System.out.println("------ Account Group Menu ------");
	    System.out.println("1. Check Balance");
	    System.out.println("0. Go back to main menu");
	    System.out.print("Enter your choice: ");
	    }
        
}
