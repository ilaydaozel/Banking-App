package account;

import currency.Currency;
import interfaces.IWithoutInterest;

public class ForeignCurrencyAccountWithoutInterest extends AbstractForeignCurrencyAccount implements IWithoutInterest{


	public ForeignCurrencyAccountWithoutInterest(int id, Currency currencyType) {
		super(id, currencyType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("-Foreign Currency Account Without Interest");
		
	}

}
