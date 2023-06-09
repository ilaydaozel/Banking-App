package account;

import enums.CurrencyType;

public abstract class AbstractForeignCurrencyAccount extends AbstractAccount {
	private CurrencyType currencyType;
	private int id;
	
	public AbstractForeignCurrencyAccount(int id, CurrencyType curType) {
		this.id = id;
		this.currencyType = curType;
		// TODO Auto-generated constructor stub
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract void exchangeToThis(AbstractAccount exchangeAccount, double amount);
	
	public abstract void exchangeFromThis(AbstractAccount exchangeAccount, double amount);

}
