package account;

import enums.CurrencyType;

public abstract class AbstractRegularAccount extends AbstractAccount{
	private int id;
	public AbstractRegularAccount(int id) {
		this.setId(id);
		super.setCurrencyType(CurrencyType.TRY);
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public abstract void exchangeToThis(AbstractAccount exchangeAccount, CurrencyType exchangeAccountType,  double amount);
	
	public abstract void exchangeFromThis(AbstractAccount exchangeAccount, CurrencyType exchangeAccountType, double amount);

}
