package menu;

public class RegularAccountTRYWithInterestMenu {
    public static void displayMenu() {
        System.out.println("------ Regular Account (TRY) with Interest Menu ------");
        System.out.println("1. Deposit Money");
        System.out.println("2. Exchange to another account (TRY with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

    public static void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Logic to deposit money to a regular account (TRY) with interest
                System.out.println("Depositing money to a regular account (TRY) with interest...");
                break;
            case 2:
                // Logic to exchange to another account (TRY with interest)
                System.out.println("Exchanging to another account (TRY with interest)...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
