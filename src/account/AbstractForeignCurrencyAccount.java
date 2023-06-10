package account;

import enums.CurrencyType;

public abstract class AbstractForeignCurrencyAccount extends AbstractAccount {
	private int id;
	
	public AbstractForeignCurrencyAccount(int id, CurrencyType curType) {
		this.id = id;
		super.setCurrencyType(curType);
		// TODO Auto-generated constructor stub
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
