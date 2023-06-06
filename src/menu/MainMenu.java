package menu;
import java.util.List;
import java.util.Scanner;

import helpers.HelperIO;
import helpers.HelperMenu;
import interfaces.IMenu;
import user.*;

public class MainMenu{
	private static Scanner scanner = new Scanner(System.in);  
	private static Bank bank;
	HelperIO helperIO = new HelperIO();
	HelperMenu helperMenu = new HelperMenu();
	
	public MainMenu(Bank bank) {
		this.bank = bank;
	}
	
    public static void createClient() {
        System.out.print("Enter the client's name: ");
        String name = scanner.nextLine();
        Client client = new Client(name);
        bank.addNewClient(client);
        System.out.println("Client created successfully.");
        System.out.println(bank.getClients());
        System.out.println();
    }

    public Client selectClient() {
    	List<Client> clients = bank.getClients();
    	Client currentClient = null;
    	
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        }
        else {
        	System.out.println("Select a client:");

            for (int i = 0; i < clients.size(); i++) {
                System.out.println((i + 1) + ". " + clients.get(i).getUsername());
            }

            int choice = helperIO.readIntegerInput();
            if (choice >= 1 && choice <= clients.size()) {
                currentClient = clients.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return currentClient;
        
    }


    
}
