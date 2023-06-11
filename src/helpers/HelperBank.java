package helpers;

import java.util.List;

import investment.Fund;
import investment.Stock;
import user.Bank;

public class HelperBank {
	private Bank bank;
	
	public HelperBank(Bank bank) {
		this.bank = bank;
	}
    public void displayStocks() {
    	System.out.println("=== Stocks ===");
		    // Display the available stocks
   		 
		    List<Stock> stocks = bank.getStocks();
		    if(stocks.size()> 0) {
			    for (Stock stock : stocks) {
			        System.out.println(stock.getName() + " - Current Value: " + stock.getValue());
			    }
		    }
		    else {
		    	System.out.println("There is no stock yet.");
		    }

    }
    public void displayFunds() {
        System.out.println("=== Funds ===");
        // Display the available funds
        List<Fund> funds = bank.getFunds();
        if(funds.size()> 0) {
	        for (Fund fund : funds) {
	            System.out.println(fund.getName() + " - Current Value: " + fund.getValue());
	        }
        }
        else {
        	System.out.println("There is no fund yet.");
        }

    }
    
    public void displayCommodities() {
    	System.out.println("=== Commodities ===");
    	displayStocks();
    	displayFunds();
    }
}
