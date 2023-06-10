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
		if (this.getBalance() >= amount) {
		    if (targetAccount instanceof RegularAccountWithoutInterest) {
		        double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
		        // Update balances
		        setBalance(this.getBalance() - amount);
		        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
		    } else if (targetAccount instanceof ForeignCurrencyAccountWithoutInterest) {
		        if (((ForeignCurrencyAccountWithoutInterest) targetAccount).getCurrencyType().equals(this.getCurrencyType())) {
		            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
		            // Update balances
		            setBalance(this.getBalance() - amount);
		            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
		        }
		    } else {
		        System.out.println("You can only exchange with a regular account (TRY) or a foreign currency account (" + this.getCurrencyType() + ")!");
		    }
		} else {
		    System.out.println("Your balance is not enough!");
		}
	}
}
