package account;

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
}
