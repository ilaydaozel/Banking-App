package account;

import interfaces.IWithInterest;
import interfaces.IWithoutInterest;

public class RegularAccountWithoutInterest extends AbstractRegularAccount implements IWithoutInterest{

    public RegularAccountWithoutInterest(int id) {
        super(id);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        } else {
            System.out.println("Invalid amount. Amount must be a positive number.");
        }
    }

    @Override
    public void display() {
        System.out.println("- id:" + getId() + " Regular Account TRY Without Interest");
    }

    @Override
    public void exchange(AbstractAccount targetAccount, double amount) {
    	if (!targetAccount.equals(this)) {
            if (getBalance() >= amount) {
                if (isExchangeAllowed(targetAccount)) {
                    performExchange(targetAccount, amount);
                } else {
                    System.out.println("You can only exchange between accounts without interest, investment accounts, or regular accounts with interest!");
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
        return targetAccount instanceof RegularAccountWithInterest ||
                targetAccount instanceof IWithoutInterest ||
                targetAccount instanceof InvestmentAccount;
    }
    
    @Override
    public void performExchange(AbstractAccount targetAccount, double amount) {
        double convertedAmount = targetAccount.getBank().convert(getCurrencyType(), targetAccount.getCurrencyType(), amount);
        // Update balances
        setBalance(getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
        if (targetAccount instanceof IWithInterest) {
        	//set interest start day 
        	((IWithInterest) targetAccount).resetInterestDay();
        }
        System.out.println("Exchanged " + convertedAmount + " " + targetAccount.getCurrencyType().toString() + " to target account!");
    }
}

