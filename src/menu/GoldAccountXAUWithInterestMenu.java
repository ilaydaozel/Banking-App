package menu;

public class GoldAccountXAUWithInterestMenu {
    public static void displayMenu() {
        System.out.println("------ Gold Account (XAU) with Interest Menu ------");
        System.out.println("1. Exchange to another account (XAU with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

    public static void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Logic to exchange to another account (XAU with interest)
                System.out.println("Exchanging to another account (XAU with interest)...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
