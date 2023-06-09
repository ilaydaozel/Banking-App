package helpers;

public class HelperMenu {
	//main menu
    public void printMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Create Client");
        System.out.println("2. Select Client");
        System.out.println("3. Bank Menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
	//client menu
    public void printClientMenu() {
        System.out.println("--- Client Menu ---");
        System.out.println("1. Display Accounts");
        System.out.println("2. Create Account");
        System.out.println("3. Create Account Group");
        System.out.println("4. Select An Account For Operation");
        System.out.println("5. Select An Account Group For Operation");
        System.out.println("6. Check Expected Balance");
        System.out.println("7. Back to Main Menu");
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
    //bank menu
    public void printBankMenu() {
        System.out.println("--- Bank Menu ---");
        System.out.println("1. Create Stock");
        System.out.println("2. Create Fund");
        System.out.println("3. Set Stock Value");
        System.out.println("4. Set Fund Value");
        System.out.println("5. Set Currency Rate");
        System.out.println("6. Set Interest Rate");
        System.out.println("7. Pass Time");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }
    

    public  void printRegularAccountTRYWithoutInterestMenu() {
        System.out.println("------ Regular Account (TRY) without Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Go back to main menu");
        System.out.print("Enter your choice: ");
    }



    public void printRegularAccountTRYWithInterestMenu() {
        System.out.println("------ Regular Account (TRY) with Interest Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Go back to main menu");
        System.out.print("Enter your choice: ");
        }
    

  
        public void printForeignCurrencyAccountEURWithoutInterestMenu() {
        System.out.println("------ Foreign Currency Account without Interest Menu ------");
        System.out.println("1. Exchange to TRY Account");
        System.out.println("2. Exchange From TRY Account");
        System.out.println("3. Go back to main menu");

        System.out.print("Enter your choice: ");
        }
    

  
        public void printForeignCurrencyAccountEURWithInterestMenu() {
        System.out.println("------ Foreign Currency Account (EUR) with Interest Menu ------");
        System.out.println("1. Exchange to another account (EUR with Interest)");
        System.out.println("2. Go back to main menu");

        System.out.print("Enter your choice: ");
        }
    

  
        public void printForeignCurrencyAccountUSDWithoutInterestMenu() {
        System.out.println("------ Foreign Currency Account (USD) without Interest Menu ------");
        System.out.println("1. Exchange to TRY Account");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }



    public void printForeignCurrencyAccountUSDWithInterestMenu() {
        System.out.println("------ Foreign Currency Account (USD) with Interest Menu ------");
        System.out.println("1. Exchange to another account (USD with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }



    public void printGoldAccountXAUWithoutInterestMenu() {
        System.out.println("------ Gold Account (XAU) without Interest Menu ------");
        System.out.println("1. Exchange to TRY Account");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }



    public void printGoldAccountXAUWithInterestMenu() {
        System.out.println("------ Gold Account (XAU) with Interest Menu ------");
        System.out.println("1. Exchange to another account (XAU with Interest)");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
        }
    

  
    public void printInvestmentAccountMenu() {
        System.out.println("------ Investment Account Menu ------");
        System.out.println("1. Buy Stocks");
        System.out.println("2. Buy Funds");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }
    
	public void printAccountGroupMenu() {
	    System.out.println("------ Account Group Menu ------");
	    System.out.println("1. Check Balance");
	    System.out.println("2. Go back to main menu");
	    System.out.print("Enter your choice: ");
	    }
        

}
