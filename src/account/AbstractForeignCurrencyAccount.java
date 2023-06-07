package account;

import currency.Currency;

public abstract class AbstractForeignCurrencyAccount extends AbstractAccount {
	Currency currencyType;
	public AbstractForeignCurrencyAccount(int id, Currency currencyType) {
		super(id);
		this.currencyType = currencyType;
		// TODO Auto-generated constructor stub
	}
	public Currency getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(Currency currencyType) {
		this.currencyType = currencyType;
	}
	
	

}
