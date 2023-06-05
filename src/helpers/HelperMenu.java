package helpers;

public class HelperMenu {
	
    public void printClientMenu() {
        System.out.println("--- Client Menu ---");
        System.out.println("1. Create Account");
        System.out.println("2. Create Account Group");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Check Account Group Balance");
        System.out.println("5. Check Expected Balance");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }
    
    
    public void printAccountTypeMenu() {
        System.out.println("---Main Account Types ---");
        System.out.println("1. Regular Account");
        System.out.println("2. Foreign Currency Account");
        System.out.println("3. Gold Account");
        System.out.println("4. Investment Account");
        System.out.print("Enter your choice: ");
    }
    
    public void printAccountMenu() {
        System.out.println("--- Account Types ---");
        System.out.println("1. Regular Account (TRY) without Interest");
        System.out.println("2. Regular Account (TRY) with Interest");
        System.out.println("3. Foreign Currency Account (EUR) without Interest");
        System.out.println("4. Foreign Currency Account (EUR) with Interest");
        System.out.println("5. Foreign Currency Account (USD) without Interest");
        System.out.println("6. Foreign Currency Account (USD) with Interest");
        System.out.println("7. Gold Account (XAU) without Interest");
        System.out.println("8. Gold Account (XAU) with Interest");
        System.out.println("9. Investment Account");
        System.out.print("Enter your choice: ");
    }
    
    public void printRegularAccountMenu() {
        System.out.println("--- Account Types ---");
        System.out.println("1. Regular Account (TRY) without Interest");
        System.out.println("2. Regular Account (TRY) with Interest");
        System.out.print("Enter your choice: ");
    }
    public void printForeignCurrencyAccountMenu() {
        System.out.println("--- Account Types ---");
        System.out.println("1. Foreign Currency Account (EUR) without Interest");
        System.out.println("2. Foreign Currency Account (EUR) with Interest");
        System.out.println("3. Foreign Currency Account (USD) without Interest");
        System.out.println("4. Foreign Currency Account (USD) with Interest");
        System.out.print("Enter your choice: ");
    }
    public void printGoldAccountMenu() {
        System.out.println("--- Account Types ---");
        System.out.println("1. Gold Account (XAU) without Interest");
        System.out.println("2. Gold Account (XAU) with Interest");
        System.out.print("Enter your choice: ");
    }

}
