package account;

import interfaces.IWithoutInterest;

public class ForeignCurrencyAccountWithoutInterest extends AbstractForeignCurrencyAccount implements IWithoutInterest{

	public ForeignCurrencyAccountWithoutInterest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("Foreign Currency Account Without Interest");
		
	}

}
