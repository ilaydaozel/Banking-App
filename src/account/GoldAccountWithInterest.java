package account;

import interfaces.IWithInterest;

public class GoldAccountWithInterest extends AbstractGoldAccount implements IWithInterest {

	public GoldAccountWithInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Gold Account With Interest");
		
	}
	
	@Override
	public void exchange(AbstractAccount targetAccount, double amount) {
		if (this.getBalance() >= amount) {
			if (targetAccount instanceof GoldAccountWithoutInterest) {
	            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
	            // Update balances
	            setBalance(this.getBalance() - amount);
	            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	        
		    } else {
		        System.out.println("You can only with a gold account without interest (XAU)!");
		    }
		} else {
		    System.out.println("Your balance is not enough!");
		}
	}

}
