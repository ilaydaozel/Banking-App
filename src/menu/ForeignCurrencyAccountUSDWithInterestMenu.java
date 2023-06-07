package menu;

public class ForeignCurrencyAccountUSDWithInterestMenu {
    public static void displayMenu() {
        System.out.println("------ Foreign Currency Account (USD) with Interest Menu ------");
        System.out.println("1. Exchange to another account (USD with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

    public static void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Logic to exchange to another account (USD with interest)
                System.out.println("Exchanging to another account (USD with interest)...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}