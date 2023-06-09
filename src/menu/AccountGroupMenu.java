package menu;
import account.AccountGroup;
import helpers.HelperIO;
import helpers.HelperMenu;

public class AccountGroupMenu {
	HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void AccountGroupMenu(AccountGroup account) {
        boolean exit = false;
        while (!exit) {
            helperMenu.printAccountGroupMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                	System.out.println("Balance:" + account.getTotalAccountGroupBalance());
                    break;
                case 2:
                    // Go back to the main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
