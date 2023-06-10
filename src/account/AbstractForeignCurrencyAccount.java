package account;

import enums.CurrencyType;
import interfaces.IExchangable;

public abstract class AbstractForeignCurrencyAccount extends AbstractAccount implements IExchangable{
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

}
