package account;

import enums.CurrencyType;
import interfaces.IWithInterest;

public class ForeignCurrencyAccountWithInterest extends AbstractForeignCurrencyAccount implements IWithInterest{
	

	public ForeignCurrencyAccountWithInterest(int id, CurrencyType curType) {
		super(id, curType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("- id:" + super.getId() + " Foreign Currency Account With Interest ");
		
	}

}
