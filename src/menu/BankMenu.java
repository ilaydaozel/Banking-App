package menu;

import java.util.Scanner;

import helpers.HelperIO;
import helpers.HelperMenu;
import user.Bank;
import user.Client;

public class BankMenu{
	private Bank bank;
	private static Scanner scanner = new Scanner(System.in);  
	HelperIO helperIO = new HelperIO();
	HelperMenu helperMenu = new HelperMenu();
	
	public BankMenu(Bank bank) {
		this.bank = bank;
	}
	
    public void bankMenu() {
        boolean exit = false;
        while (!exit) {
        	helperMenu.printBankMenu();
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


    private void createStock() {
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        bank.createStock(stockName);
        System.out.println("Stock created successfully.");
        System.out.println();
    }

    private void createFund() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        bank.createFund(fundName);
        System.out.println("Fund created successfully.");
        System.out.println();
    }

    private void setStockValue() {
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        System.out.print("Enter the stock value: ");
        double stockValue = helperIO.readDoubleInput();
        bank.setStockValue(stockName, stockValue);
        System.out.println("Stock value set successfully.");
        System.out.println();
    }

    private void setFundValue() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        System.out.print("Enter the fund value: ");
        double fundValue = helperIO.readDoubleInput();
        bank.setFundValue(fundName, fundValue);
        System.out.println("Fund value set successfully.");
        System.out.println();
    }

    private void setCurrencyRate() {
        System.out.print("Enter the currency code (TRY, EUR, USD): ");
        String currencyCode = scanner.nextLine();
        System.out.print("Enter the currency rate: ");
        double currencyRate = helperIO.readDoubleInput();
        bank.setCurrencyRate(currencyCode, currencyRate);
        System.out.println("Currency rate set successfully.");
        System.out.println();
    }

    private void setInterestRate() {
        System.out.print("Enter the account type (1-9): ");
        int accountType = readIntegerInput();
        System.out.print("Enter the interest rate: ");
        double interestRate = helperIO.readDoubleInput();
        bank.setInterestRate(accountType, interestRate);
        System.out.println("Interest rate set successfully.");
        System.out.println();
    }

    private void passTime() {
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


}
