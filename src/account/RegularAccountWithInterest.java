package account;

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

}
