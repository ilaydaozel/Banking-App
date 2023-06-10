package account;

import enums.CurrencyType;
import interfaces.IWithoutInterest;

public class RegularAccountWithoutInterest extends AbstractRegularAccount implements IWithoutInterest{

	public RegularAccountWithoutInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			super.setBalance(getBalance() + amount);
		}
		else {
			System.out.println("Invalid amount. Amount must be a positive number.");
		}
	}
	
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Regular Account Without Interest");
		
	}
	
	@Override
	public void exchange(AbstractAccount targetAccount, double amount) {
	    if (this.getBalance() >= amount) {
	        if (targetAccount instanceof RegularAccountWithInterest) {
	            double convertedAmount = targetAccount.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
	            // Update balances
	            setBalance(this.getBalance() - amount);
	            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	            System.out.println("Exchanged " + convertedAmount + " "+ targetAccount.getCurrencyType().toString() + " to target account!");
	        } else if (targetAccount instanceof IWithoutInterest) {
	            double convertedAmount = targetAccount.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
	            // Update balances
	            setBalance(this.getBalance() - amount);
	            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	            System.out.println("Exchanged " + convertedAmount + " "+ targetAccount.getCurrencyType().toString() + " to target account!");
	        } else {
	            System.out.println("You can only exchange between accounts without interest or a regular account with interest (TRY)!");
	        }
	    } else {
	        System.out.println("Your balance is not enough!");
	    }
	}

}
