package account;

import enums.CurrencyType;
import interfaces.IWithInterest;

public class RegularAccountWithInterest extends AbstractRegularAccount implements IWithInterest{

	public RegularAccountWithInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Regular Account With Interest");
		
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
