package account;

import interfaces.IWithInterest;

public class GoldAccountWithInterest extends AbstractGoldAccount implements IWithInterest {

	public GoldAccountWithInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void display() {
		System.out.println("Gold Account With Interest");
		
	}
}
