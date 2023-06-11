package menu;

import java.util.Scanner;

import enums.CurrencyType;
import helpers.HelperBank;
import helpers.HelperIO;
import helpers.HelperMenu;
import interfaces.IMenu;
import user.Bank;

public class BankMenu implements IMenu {

    private Bank bank;
    private static Scanner scanner = new Scanner(System.in);
    private HelperIO helperIO = new HelperIO();
    private HelperMenu helperMenu = new HelperMenu();
    private HelperBank helperBank;

    public BankMenu(Bank bank) {
        this.bank = bank;
        this.helperBank = new HelperBank(this.bank);
    }

    @Override
    public void displayMenu() {
        System.out.println("--- Bank Menu ---");
        System.out.println("1. Display Commodities");
        System.out.println("2. Create Stock");
        System.out.println("3. Create Fund");
        System.out.println("4. Set Stock Value");
        System.out.println("5. Set Fund Value");
        System.out.println("6. Set Currency Rate");
        System.out.println("7. Set Interest Rate");
        System.out.println("8. Pass Time");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void handleChoice() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
                case 1:
                	System.out.println();
                	helperBank.displayCommodities();
                    System.out.println();
                    break;
                case 2:
                	System.out.println();
                    createStock();
                    System.out.println();
                    break;
                case 3:
                	System.out.println();
                    createFund();
                    System.out.println();
                    break;
                case 4:
                	System.out.println();
                    helperBank.displayStocks();
                    setStockValue();
                    System.out.println();
                    break;
                case 5:
                	System.out.println();
                    helperBank.displayFunds();
                    setFundValue();
                    System.out.println();
                    break;
                case 6:
                	System.out.println();
                    setCurrencyRate();
                    System.out.println();
                    break;
                case 7:
                	System.out.println();
                    setInterestRate();
                    System.out.println();
                    break;
                case 8:
                	System.out.println();
                    passTime();
                    System.out.println();
                    break;
                case 0:
                    exit = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void executeMenu() {
        handleChoice();
    }

    private void createStock() {
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        System.out.print("Enter the stock value: ");
        double stockValue = helperIO.readDoubleInput();
        bank.createStock(stockName, stockValue);
        System.out.println("Stock created successfully.");
        System.out.println();
    }

    private void createFund() {
        System.out.print("Enter the fund name: ");
        String fundName = scanner.nextLine();
        System.out.print("Enter the fund value: ");
        double fundValue = helperIO.readDoubleInput();
        bank.createFund(fundName, fundValue);
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

            CurrencyType currencyType;

            switch (currencyCode) {
                case 1:
                    currencyType = CurrencyType.EUR;
                    bank.getEurCur().setRate(currencyRate);
                    break;
                case 2:
                    currencyType = CurrencyType.USD;
                    bank.getUsdCur().setRate(currencyRate);
                    break;
                case 3:
                    currencyType = CurrencyType.XAU;
                    bank.getXauCur().setRate(currencyRate);
                    break;
                case 4:
                    currencyType = CurrencyType.TRY;
                    bank.getTryCur().setRate(currencyRate);
                    break;
                default:
                    System.out.println("Invalid currency code.");
                    return;
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
        int currencyNumber = helperIO.readIntegerInput();

        CurrencyType currencyType;

        switch (currencyNumber) {
            case 1:
                currencyType = CurrencyType.EUR;
                break;
            case 2:
                currencyType = CurrencyType.USD;
                break;
            case 3:
                currencyType = CurrencyType.TRY;
                break;
            case 4:
                currencyType = CurrencyType.XAU;
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
        int days = helperIO.readIntegerInput();
        bank.passTime(days);
        System.out.println("Time passed successfully.");
        System.out.println();
    }

}

