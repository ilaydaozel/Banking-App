package menu;

public class BankMenu{
	
    private static void bankMenu() {
        boolean exit = false;
        while (!exit) {
            printBankMenu();
            int choice = readIntegerInput();

            switch (choice) {
                case 1:
                    createStock();
                    break;
                case 2:
                    createFund();
                    break;
                case 3:
                    setStockValue();
                    break;
                case 4:
                    setFundValue();
                    break;
                case 5:
                    setCurrencyRate();
                    break;
                case 6:
                    setInterestRate();
                    break;
                case 7:
                    passTime();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
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

    private static void createStock() {
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        bank.createStock(stockName);
        System.out.println("Stock created successfully.");
        System.out.println();
    }

    private static void createFund() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        bank.createFund(fundName);
        System.out.println("Fund created successfully.");
        System.out.println();
    }

    private static void setStockValue() {
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        System.out.print("Enter the stock value: ");
        double stockValue = readDoubleInput();
        bank.setStockValue(stockName, stockValue);
        System.out.println("Stock value set successfully.");
        System.out.println();
    }

    private static void setFundValue() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        System.out.print("Enter the fund value: ");
        double fundValue = readDoubleInput();
        bank.setFundValue(fundName, fundValue);
        System.out.println("Fund value set successfully.");
        System.out.println();
    }

    private static void setCurrencyRate() {
        System.out.print("Enter the currency code (TRY, EUR, USD): ");
        String currencyCode = scanner.nextLine();
        System.out.print("Enter the currency rate: ");
        double currencyRate = readDoubleInput();
        bank.setCurrencyRate(currencyCode, currencyRate);
        System.out.println("Currency rate set successfully.");
        System.out.println();
    }

    private static void setInterestRate() {
        System.out.print("Enter the account type (1-9): ");
        int accountType = readIntegerInput();
        System.out.print("Enter the interest rate: ");
        double interestRate = readDoubleInput();
        bank.setInterestRate(accountType, interestRate);
        System.out.println("Interest rate set successfully.");
        System.out.println();
    }

    private static void passTime() {
        System.out.print("Enter the number of days to pass: ");
        int days = readIntegerInput();
        bank.passTime(days);
        System.out.println("Time passed successfully.");
        System.out.println();
    }

    private static int readIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
	}

}
