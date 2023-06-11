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
        helperMenu.printBankMenu();
    }

    @Override
    public void handleChoice() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = readIntegerInput();

            switch (choice) {
                case 1:
                	helperBank.displayCommodities();
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
        int currencyNumber = readIntegerInput();

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

