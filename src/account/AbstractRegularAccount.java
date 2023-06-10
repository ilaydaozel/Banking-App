package account;

import enums.CurrencyType;
import interfaces.IExchangable;

public abstract class AbstractRegularAccount extends AbstractAccount implements IExchangable{
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

}
