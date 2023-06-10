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

	@Override
	public void exchange(AbstractAccount targetAccount, double amount) {
		if (this.getBalance() >= amount) {
			if (targetAccount instanceof ForeignCurrencyAccountWithoutInterest) {
		        if (((ForeignCurrencyAccountWithoutInterest) targetAccount).getCurrencyType().equals(this.getCurrencyType())) {
		            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
		            // Update balances
		            setBalance(this.getBalance() - amount);
		            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
		        }
		        else {
		        	System.out.println("Selected account's currency type is not " + this.getCurrencyType()+"!");
		        }
		    } else {
		        System.out.println("You can only with a foreign currency account without interest(" + this.getCurrencyType() + ")!");
		    }
		} else {
		    System.out.println("Your balance is not enough!");
		}
	}
}
