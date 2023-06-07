package menu;

public class InvestmentAccountMenu {
    public static void displayMenu() {
        System.out.println("------ Investment Account Menu ------");
        System.out.println("1. Buy Stocks");
        System.out.println("2. Buy Funds");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

    public static void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Logic to buy stocks
                System.out.println("Buying stocks...");
                break;
            case 2:
                // Logic to buy funds
                System.out.println("Buying funds...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}