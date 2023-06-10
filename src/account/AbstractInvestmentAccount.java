package account;

import java.util.List;

import enums.CurrencyType;
import investment.Commodity;

public abstract class AbstractInvestmentAccount extends AbstractAccount {
	private int id;
	private List <Commodity> commodities;
	
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
	public abstract void buyCommodities();
		
	
	
}
