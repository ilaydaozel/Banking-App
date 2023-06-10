package menu;

import java.util.Scanner;

import account.AbstractAccount;
import account.RegularAccountWithInterest;
import helpers.HelperClient;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Client;

public class RegularAccountTRYWithInterestMenu  {

    public RegularAccountTRYWithInterestMenu(RegularAccountWithInterest account, Client client) {
    	HelperClient helperClient = new HelperClient(client);
        HelperIO helperIO = new HelperIO();
        HelperMenu helperMenu = new HelperMenu();
        
        boolean exit = false;
        while (!exit) {
            helperMenu.printRegularAccountTRYWithInterestMenu ();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                	System.out.println("Balance:" + account.getBalance());
                    break;
                case 2:
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
}

