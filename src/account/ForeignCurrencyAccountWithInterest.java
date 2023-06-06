package account;

import interfaces.IWithInterest;

public class ForeignCurrencyAccountWithInterest extends AbstractForeignCurrencyAccount implements IWithInterest{
	
	public ForeignCurrencyAccountWithInterest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("Foreign Currency Account With Interest");
		
	}

}
