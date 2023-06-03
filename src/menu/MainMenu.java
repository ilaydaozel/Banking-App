package menu;

public class MainMenu {

    private static void printMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Create Client");
        System.out.println("2. Select Client");
        System.out.println("3. Bank Menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createClient() {
        System.out.print("Enter the client's name: ");
        String name = scanner.nextLine();
        //Client client = new Client(name);
       // clients.add(client);
        System.out.println("Client created successfully.");
        System.out.println();
    }

    private static void selectClient() {
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
            return;
        }

        System.out.println("Select a client:");

        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        int choice = readIntegerInput();
        if (choice >= 1 && choice <= clients.size()) {
            currentClient = clients.get(choice - 1);
            clientMenu();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

}
