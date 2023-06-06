package account;

import interfaces.IWithInterest;

public class RegularAccountWithInterest extends AbstractRegularAccount implements IWithInterest{

	public RegularAccountWithInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display() {
		System.out.println("Regular Account With Interest");
		
	}

}
