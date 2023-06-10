package account;

import enums.CurrencyType;
import interfaces.IExchangable;

public abstract class AbstractGoldAccount extends AbstractAccount implements IExchangable {
	private int id;
	
	public AbstractGoldAccount(int id) {
		this.setId(id);
		super.setCurrencyType(CurrencyType.XAU);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
