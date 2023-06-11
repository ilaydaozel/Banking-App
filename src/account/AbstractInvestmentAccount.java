package account;

import java.util.ArrayList;
import java.util.List;

import enums.CurrencyType;
import investment.Commodity;

public abstract class AbstractInvestmentAccount extends AbstractAccount {
	private int id;
	private List<Commodity> commodities = new ArrayList<>();
	
	public AbstractInvestmentAccount(int id) {
		super.setCurrencyType(CurrencyType.TRY);
		this.setId(id);
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List <Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List <Commodity> assets) {
		this.commodities = assets;
	}
	
	public abstract void buyCommodity(Commodity commodity);
	
	public double getTotalCommodityValue() {
	    double totalValue = 0.0;
	    for (Commodity commodity : commodities) {
	        totalValue += commodity.getValue();
	    }
	    return totalValue;
	}
	
	public void displayCommodities() {
	    System.out.println("=== Your Commodities ===");
	    if(commodities.size()>0) {
	    	 for (Commodity commodity : commodities) {
	 	        System.out.println(commodity.toString());
	 	    }
	    }
	   
	}

	
	
	
}
