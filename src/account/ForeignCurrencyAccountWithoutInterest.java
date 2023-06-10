package account;

import currency.Currency;
import enums.CurrencyType;
import interfaces.IWithoutInterest;
import user.Bank;

public class ForeignCurrencyAccountWithoutInterest extends AbstractForeignCurrencyAccount implements IWithoutInterest{



	public ForeignCurrencyAccountWithoutInterest(int id, CurrencyType curType) {
		super(id, curType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Foreign Currency Account Without Interest");
		
	}
	
	@Override
    public void exchange( AbstractAccount targetAccount, double amount) {
    	//calculate the amount
        double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
        //update balances
        setBalance(this.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
    }	
}
