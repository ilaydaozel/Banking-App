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
		// TODO Auto-generated method stub
    	//calculate the amount
        double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
        //update balances
        setBalance(this.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
	}

}
