package application;

import java.util.Scanner;

import menu.BankMenu;
import menu.MainMenu;
import user.Bank;

public class App {
    private static Bank bank;
    private static Scanner scanner  = new Scanner(System.in);
    private static MainMenu mainMenu;
    private static BankMenu bankMenu;
    
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
            	exit =true;
            	System.out.println("Exit the app");
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
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
