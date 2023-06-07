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

}
