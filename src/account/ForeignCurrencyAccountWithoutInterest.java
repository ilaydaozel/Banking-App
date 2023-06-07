package account;

import currency.Currency;
import enums.CurrencyType;
import interfaces.IWithoutInterest;

public class ForeignCurrencyAccountWithoutInterest extends AbstractForeignCurrencyAccount implements IWithoutInterest{



	public ForeignCurrencyAccountWithoutInterest(int id, CurrencyType curType) {
		super(id, curType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("-Foreign Currency Account Without Interest");
		
	}

}
