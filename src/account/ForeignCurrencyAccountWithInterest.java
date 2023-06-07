package account;

import currency.Currency;
import interfaces.IWithInterest;

public class ForeignCurrencyAccountWithInterest extends AbstractForeignCurrencyAccount implements IWithInterest{
	
	public ForeignCurrencyAccountWithInterest(int id, Currency currencyType) {
		super(id, currencyType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("-Foreign Currency Account With Interest");
		
	}

}
