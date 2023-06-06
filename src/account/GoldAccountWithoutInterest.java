package account;

import interfaces.IWithoutInterest;

public class GoldAccountWithoutInterest extends AbstractGoldAccount implements IWithoutInterest{

	public GoldAccountWithoutInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void display() {
		System.out.println("Gold Account Without Interest");
		
	}

}
