package menu;

import java.util.List;
import java.util.Scanner;

import account.InvestmentAccount;
import helpers.HelperIO;
import helpers.HelperMenu;
import investment.Fund;
import investment.Stock;

public class InvestmentAccountMenu  {
    private static Scanner scanner = new Scanner(System.in);

    HelperIO helperIO = new HelperIO();
    HelperMenu helperMenu = new HelperMenu();

    public void InvestmentAccountMenu (InvestmentAccount account) {
        boolean exit = false;
        while (!exit) {
            helperMenu.printInvestmentAccountMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
       		 System.out.println("=== Stocks ===");
 		    // Display the available stocks
       		 
 		    List<Stock> stocks = account.getBank().getStocks();
 		    for (Stock stock : stocks) {
 		        System.out.println(stock.getName() + " - Current Value: " + stock.getValue());
 		    }

 		    // Get user input
 		    System.out.print("Enter the name of the stock you want to buy: ");
 		    String stockName = scanner.next();

 		    // Perform the stock purchase
 		    Stock stock = account.getBank().getStock(stockName);
 		    
 		    if (stock != null) {
 		    	account.getCommodities().add(stock);
 		    	account.getBank().setStockValue(stockName, 0);
 		        System.out.println("Successfully purchased " + stockName + " stocks.");
 		    } else {
 		        System.out.println("Invalid stock name. Please try again.");
 		        
 		    }
                // Logic to buy stocks
                
                break;
            case 2:
                System.out.println("=== Funds ===");
                // Display the available funds

                List<Fund> funds = account.getBank().getFunds();
                for (Fund fund : funds) {
                    System.out.println(fund.getName() + " - Current Value: " + fund.getValue());
                }

                // Get user input
                System.out.print("Enter the name of the fund you want to buy: ");
                String fundName = scanner.next();

                // Perform the fund purchase
                Fund fund = account.getBank().getFund(fundName);

                if (fund != null) {
                    account.getCommodities().add(fund);
                    account.getBank().setFundValue(fundName, 0);
                    System.out.println("Successfully purchased " + fundName + " fund.");
                } else {
                    System.out.println("Invalid fund name. Please try again.");
                }
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        }
    }
}

// Similar classes for other account menus
