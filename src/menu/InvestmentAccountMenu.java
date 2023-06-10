package menu;

import java.util.List;
import java.util.Scanner;

import account.InvestmentAccount;
import helpers.*;
import investment.Fund;
import investment.Stock;

public class InvestmentAccountMenu  {

    public InvestmentAccountMenu (InvestmentAccount investmentAccount) {
        Scanner scanner = new Scanner(System.in);
        HelperIO helperIO = new HelperIO();
        HelperBank helperBank = new HelperBank(investmentAccount.getBank());

        boolean exit = false;
        while (!exit) {
            printInvestmentAccountMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
            	System.out.println("Balance:" + investmentAccount.getBalance());
            	break;
            case 2:
	       		helperBank.displayStocks();
	 		    // Get user input
	 		    System.out.print("Enter the name of the stock you want to buy: ");
	 		    String stockName = scanner.next();
	 		    Stock stock = investmentAccount.getBank().getStock(stockName);
	 		    investmentAccount.buyCommodity(stock);
	                
	            break;
            case 3:
            	helperBank.displayFunds();
                // Get user input
                System.out.print("Enter the name of the fund you want to buy: ");
                String fundName = scanner.next();

                // Perform the fund purchase
                Fund fund = investmentAccount.getBank().getFund(fundName);
                investmentAccount.buyCommodity(fund);

                break;
            case 4:
            	investmentAccount.displayCommodities();
                // Go back to the main menu
                break;
            case 0:
            	exit = true;
            	
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        }
    }
    

    
    private void printInvestmentAccountMenu() {
        System.out.println("------ Investment Account Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Buy Stocks");
        System.out.println("3. Buy Funds");
        System.out.println("4. Display Stocks and Funds");
        System.out.println("0. Go back to main menu");

        System.out.print("Enter your choice: ");
    }
    
}

