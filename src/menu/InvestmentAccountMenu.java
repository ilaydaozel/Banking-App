package menu;

import java.util.List;
import java.util.Scanner;

import account.InvestmentAccount;
import helpers.HelperIO;
import helpers.HelperMenu;
import investment.Fund;
import investment.Stock;

public class InvestmentAccountMenu  {

    public InvestmentAccountMenu (InvestmentAccount investmentAccount) {
        Scanner scanner = new Scanner(System.in);
        HelperIO helperIO = new HelperIO();
        HelperMenu helperMenu = new HelperMenu();
        boolean exit = false;
        while (!exit) {
            helperMenu.printInvestmentAccountMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            case 1:
            	System.out.println("Balance:" + investmentAccount.getBalance());
            	break;
            case 2:
       		 System.out.println("=== Stocks ===");
 		    // Display the available stocks
       		 
 		    List<Stock> stocks = investmentAccount.getBank().getStocks();
 		    for (Stock stock : stocks) {
 		        System.out.println(stock.getName() + " - Current Value: " + stock.getValue());
 		    }

 		    // Get user input
 		    System.out.print("Enter the name of the stock you want to buy: ");
 		    String stockName = scanner.next();

 		    // Perform the stock purchase
 		    Stock stock = investmentAccount.getBank().getStock(stockName);
 		    
 		    if (stock != null) {
 		    	if(investmentAccount.getBalance()- stock.getValue() > 0) {
 		    		investmentAccount.setBalance(investmentAccount.getBalance()- stock.getValue());
 		    		investmentAccount.getCommodities().add(stock);
                    System.out.println("Successfully purchased " + stockName + " stock.");
                    System.out.println("new account balance: " + investmentAccount.getBalance() + " "+ investmentAccount.getCurrencyType());
            	}
            	else {
            		System.out.println("Insufficent balance. Please try again.");
            	}
 		    	
 		       
 		    } else {
 		        System.out.println("Invalid stock name. Please try again.");
 		        
 		    }
                // Logic to buy stocks
                
                break;
            case 3:
                System.out.println("=== Funds ===");
                // Display the available funds

                List<Fund> funds = investmentAccount.getBank().getFunds();
                for (Fund fund : funds) {
                    System.out.println(fund.getName() + " - Current Value: " + fund.getValue());
                }

                // Get user input
                System.out.print("Enter the name of the fund you want to buy: ");
                String fundName = scanner.next();

                // Perform the fund purchase
                Fund fund = investmentAccount.getBank().getFund(fundName);
                
                if (fund != null) {
                	if(investmentAccount.getBalance()- fund.getValue() > 0) {
                		investmentAccount.setBalance(investmentAccount.getBalance()- fund.getValue());
                		investmentAccount.getCommodities().add(fund);
                        System.out.println("Successfully purchased " + fundName + " fund.");
                        System.out.println("new account balance: " + investmentAccount.getBalance() + " "+ investmentAccount.getCurrencyType());
                	}
                	else {
                		System.out.println("Insufficent balance. Please try again.");
                	}
                	break;
                    
                } else {
                    System.out.println("Invalid fund name. Please try again.");
                }
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
}

// Similar classes for other account menus
