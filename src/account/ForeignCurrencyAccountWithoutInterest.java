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
    public void exchange(AbstractAccount targetAccount, double amount) {
    	if (!targetAccount.equals(this)) {
            if (getBalance() >= amount) {
                if (isExchangeAllowed(targetAccount)) {
                    performExchange(targetAccount, amount);
                } else {
                    System.out.println("You can only exchange with a regular account without interest (TRY) or with a foreign currency account with " + this.getCurrencyType() + " currency!");
                }
            } else {
                System.out.println("Your balance is not enough!");
            }
    	}else {
    		System.out.println("You can't exchange to the account itself, please choose another account!");
    	}
    }
	
    
	@Override
	public boolean isExchangeAllowed(AbstractAccount targetAccount) {
		return ((targetAccount instanceof RegularAccountWithoutInterest) || ((targetAccount instanceof AbstractForeignCurrencyAccount) && (((AbstractForeignCurrencyAccount) targetAccount).getCurrencyType().equals(this.getCurrencyType()))));
	}

	@Override
	public void performExchange(AbstractAccount targetAccount, double amount) {
		// TODO Auto-generated method stub
		
	}
}
