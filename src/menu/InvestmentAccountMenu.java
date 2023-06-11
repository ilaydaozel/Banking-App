package menu;

import java.util.Scanner;

import account.InvestmentAccount;
import helpers.HelperBank;
import helpers.HelperIO;
import interfaces.IMenu;
import investment.Fund;
import investment.Stock;

public class InvestmentAccountMenu implements IMenu {

    private InvestmentAccount investmentAccount;

    public InvestmentAccountMenu(InvestmentAccount investmentAccount) {
        this.investmentAccount = investmentAccount;
    }

    @Override
    public void displayMenu() {
        System.out.println("------ Investment Account Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Buy Stocks");
        System.out.println("3. Buy Funds");
        System.out.println("4. Display Stocks and Funds");
        System.out.println("0. Go back to main menu");
    }

    @Override
    public void handleChoice() {
        Scanner scanner = new Scanner(System.in);
        HelperIO helperIO = new HelperIO();
        HelperBank helperBank = new HelperBank(investmentAccount.getBank());
        
        boolean exit = false;
        while (!exit) {
        	displayMenu();
        	int choice = helperIO.readIntegerInput();
            switch (choice) {
            case 1:
                System.out.println("Balance: " + investmentAccount.getBalance());
                System.out.println();
                break;
            case 2:
                helperBank.displayStocks();
                // Get user input
                System.out.print("Enter the name of the stock you want to buy: ");
                String stockName = scanner.next();
                Stock stock = investmentAccount.getBank().getStock(stockName);
                investmentAccount.buyCommodity(stock);
                System.out.println();
                break;
            case 3:
                helperBank.displayFunds();
                // Get user input
                System.out.print("Enter the name of the fund you want to buy: ");
                String fundName = scanner.next();

                // Perform the fund purchase
                Fund fund = investmentAccount.getBank().getFund(fundName);
                investmentAccount.buyCommodity(fund);
                System.out.println();
                break;
            case 4:
                investmentAccount.displayCommodities();
                System.out.println();
                break;
            case 0:
            	exit = true;
            	System.out.println();
                // Go back to the main menu
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
}


