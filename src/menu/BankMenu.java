package menu;

import java.util.Scanner;

import currency.Currency;
import enums.CurrencyType;
import helpers.HelperBank;
import helpers.HelperIO;
import helpers.HelperMenu;
import user.Bank;
import user.Client;

public class BankMenu{
	private Bank bank;
	private static Scanner scanner = new Scanner(System.in);  
	HelperIO helperIO = new HelperIO();
	HelperMenu helperMenu = new HelperMenu();
	HelperBank helperBank;
	
	public BankMenu(Bank bank) {
		this.bank = bank;
		this.helperBank = new HelperBank(this.bank);
	}
	
    public void bankMenu() {
        boolean exit = false;
        while (!exit) {
        	helperMenu.printBankMenu();
            int choice = readIntegerInput();

            switch (choice) {
            	case 1:
            		System.out.println("---Commodities---");
	            	helperBank.displayFunds();
	            	helperBank.displayStocks();
	            	System.out.println();
	            	break;
                case 2:
                    createStock();
                    System.out.println();
                    break;
                case 3:
                    createFund();
                    System.out.println();
                    break;
                case 4:
                	helperBank.displayStocks();
                    setStockValue();
                    System.out.println();
                    break;
                case 5:
                	helperBank.displayFunds();
                    setFundValue();
                    System.out.println();
                    break;
                case 6:
                    setCurrencyRate();
                    System.out.println();
                    break;
                case 7:
                    setInterestRate();
                    System.out.println();
                    break;
                case 8:
                    passTime();
                    System.out.println();
                    break;
                case 0:
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
        System.out.print("Enter the stock value: ");
        double stockValue = helperIO.readDoubleInput();
        bank.createStock(stockName,stockValue);
        System.out.println("Stock created successfully.");
        System.out.println();
    }

    private void createFund() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        System.out.print("Enter the fund value: ");
        double fundValue = helperIO.readDoubleInput();
        bank.createFund(fundName,fundValue);
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
        System.out.println("1. EUR");
        System.out.println("2. USD");
        System.out.println("3. AUX");
        System.out.println("4. TRY");
        System.out.print("Enter the currency: ");
        int currencyCode = helperIO.readIntegerInput();

        if (currencyCode < 1 || currencyCode > 4) {
            System.out.println("Please enter a valid choice!");
        } else {
            System.out.print("Enter the currency rate: ");
            double currencyRate = helperIO.readDoubleInput();
            
            switch (currencyCode) {
                case 1:
                    bank.getEurCur().setRate(currencyRate);
                    break;
                case 2:
                    bank.getUsdCur().setRate(currencyRate);
                    break;
                case 3:
                    bank.getXauCur().setRate(currencyRate);
                    break;
                case 4:
                    bank.getTryCur().setRate(currencyRate);
                    break;
            }

            System.out.println("Currency rate set successfully.");
            System.out.println();
        }
    }


    private void setInterestRate() {
        System.out.println("Select the currency type:");
        System.out.println("1. EUR");
        System.out.println("2. USD");
        System.out.println("3. TRY");
        System.out.println("4. XAU");

        System.out.print("Enter the currency number (1-4): ");
        int currencyNumber = readIntegerInput();

        CurrencyType currencyType = null;

        switch (currencyNumber) {
            case 1:
                currencyType = currencyType.EUR;
                break;
            case 2:
                currencyType = currencyType.USD;
                break;
            case 3:
                currencyType = currencyType.TRY;
                break;
            case 4:
                currencyType = currencyType.XAU;
                break;
            default:
                System.out.println("Invalid currency number.");
                return;
        }

        System.out.print("Enter the interest rate: ");
        double interestRate = helperIO.readDoubleInput();
        bank.setInterestRate(currencyType.toString(), interestRate);

        System.out.println("Interest rate for " + currencyType + " set to: " + interestRate);
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
