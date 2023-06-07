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
}
