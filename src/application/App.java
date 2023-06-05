package application;

import java.util.Scanner;

import menu.BankMenu;
import menu.MainMenu;
import user.Bank;
import user.Client;

public class App {
    private static Bank bank;
    private static Scanner scanner  = new Scanner(System.in);
    private static MainMenu mainMenu;
    private static BankMenu bankMenu;
    private static Client currentClient;
    
	public static void main(String[] args) {
		bank = new Bank();
        mainMenu = new MainMenu(bank);
        boolean exit = false;
        while (!exit) {
            mainMenu.printMenu();
            int choice = readIntegerInput();

            switch (choice) {
            case 1:
                mainMenu.createClient();
                break;
            case 2:
            	Client client = mainMenu.selectClient();
            	if( client != null) {
            		currentClient = client;
            		System.out.println("selected client: " + currentClient);
            		//openClientmenu
            	}
            	break;
            case 3:
            	//
            case 4:
            	exit =true;
            	System.out.println("You exit the app!");
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println();
                break;
	        }
	    }
	    scanner.close();
            	
        }


	
    public static int readIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    

}
