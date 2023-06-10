package account;

import interfaces.IWithoutInterest;

public class GoldAccountWithoutInterest extends AbstractGoldAccount implements IWithoutInterest{

	public GoldAccountWithoutInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Gold Account Without Interest");
		
	}
	@Override
	public void exchange(AbstractAccount targetAccount, double amount) {
	    if (this.getBalance() >= amount) {
	        if (targetAccount instanceof GoldAccountWithInterest) {
	            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
	            // Update balances
	            setBalance(this.getBalance() - amount);
	            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	            System.out.println("Exchanged " + convertedAmount + " "+ targetAccount.getCurrencyType().toString() + " to target account!");
	        } else if (targetAccount instanceof RegularAccountWithoutInterest) {
	            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
	            // Update balances
	            setBalance(this.getBalance() - amount);
	            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	            System.out.println("Exchanged " + convertedAmount + " "+ targetAccount.getCurrencyType().toString() + " to target account!");
	        } else {
	            System.out.println("You can only exchange between a gold account with interest (XAU) or a regular account without interest (TRY)!");
	        }
	    } else {
	        System.out.println("Your balance is not enough!");
	    }
	}


}
