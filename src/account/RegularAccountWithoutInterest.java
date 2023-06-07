package account;

import interfaces.IWithoutInterest;

public class RegularAccountWithoutInterest extends AbstractRegularAccount implements IWithoutInterest{

	public RegularAccountWithoutInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public void deposit(double amount) {
		super.setBalance(getBalance() + amount);
	}
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Regular Account Without Interest");
		
	}
}
