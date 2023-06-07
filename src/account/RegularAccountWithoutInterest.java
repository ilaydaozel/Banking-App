package account;

import interfaces.IWithoutInterest;

public class RegularAccountWithoutInterest extends AbstractRegularAccount implements IWithoutInterest{

	public RegularAccountWithoutInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void deposit(double amount) {
		super.setBalance(getBalance() + amount);
	}
	@Override
	public void display() {
		System.out.println("-Regular Account Without Interest");
		
	}
}
