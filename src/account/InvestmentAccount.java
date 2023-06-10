package account;

import java.util.List;

import investment.Commodity;
import investment.Stock;
import menu.InvestmentAccountMenu;

public class InvestmentAccount extends AbstractInvestmentAccount {
	
	
	public InvestmentAccount(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Investment");
		
	}
	
	@Override
	public void buyCommodity(Commodity commodity) {
	    if (commodity != null) {
	    	if(this.getBalance()- commodity.getValue() > 0) {
	    		this.setBalance(this.getBalance()- commodity.getValue());
	    		this.getCommodities().add(commodity);
                System.out.println("Successfully purchased " + commodity.getName() + " commodity.");
                System.out.println("New account balance: " + this.getBalance() + " "+ this.getCurrencyType()+ ".");
        	}
        	else {
        		System.out.println("Insufficent balance. Please try again.");
        	}
	       
	    } else {
	        System.out.println("Invalid commodity name. Please try again.");
	        
	    }
	}

}
