package menu;

import java.util.Scanner;

public class RegularAccountTRYWithoutInterestMenu {
    public static void displayMenu() {
        System.out.println("------ Regular Account (TRY) without Interest Menu ------");
        System.out.println("1. Deposit Money");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }

    public static void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Logic to deposit money to a regular account (TRY) without interest
                System.out.println("Depositing money to a regular account (TRY) without interest...");
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}


    private static void displayMainMenu() {
        System.out.println("------ Main Menu ------");
        System.out.println("1. Regular Account (TRY) without Interest");
        System.out.println("2. Regular Account (TRY) with Interest");
        // Display other account types in the menu
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
