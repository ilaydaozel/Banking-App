package helpers;

import java.util.Scanner;

public class HelperIO {
    private static Scanner scanner  = new Scanner(System.in);
    
    public static int readIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    public static double readDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    
}
