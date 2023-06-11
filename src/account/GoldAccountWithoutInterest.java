package account;

import interfaces.IWithInterest;
import interfaces.IWithoutInterest;

public class GoldAccountWithoutInterest extends AbstractGoldAccount implements IWithoutInterest{

	public GoldAccountWithoutInterest(int id) {
		super(id);
	}
	
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Gold Account XAU Without Interest");
		
	}
	
    @Override
    public void exchange(AbstractAccount targetAccount, double amount) {
    	if (!targetAccount.equals(this)) {
            if (getBalance() >= amount) {
                if (isExchangeAllowed(targetAccount)) {
                    performExchange(targetAccount, amount);
                } else {
                    System.out.println("You can only exchange between a gold account (XAU) or a regular account without interest (TRY)!");
                }
            } else {
                System.out.println("Your balance is not enough!");
            }
    	}else {
    		System.out.println("You can't exchange to the account itself, please choose another account!");
    	}
    }
	
    @Override
    public void performExchange(AbstractAccount targetAccount, double amount) {
        double convertedAmount = getBank().convert(getCurrencyType(), targetAccount.getCurrencyType(), amount);
        // Update balances
        setBalance(getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
        if (targetAccount instanceof IWithInterest) {
        	//set interest start day 
        	((IWithInterest) targetAccount).resetInterestDay();
        }
        System.out.println("Exchanged " + convertedAmount + " " + targetAccount.getCurrencyType().toString() + " to target account!");
    }

	@Override
	public boolean isExchangeAllowed(AbstractAccount targetAccount) {
		return ( (targetAccount instanceof AbstractGoldAccount) || (targetAccount instanceof RegularAccountWithoutInterest)) ;
	}

}
