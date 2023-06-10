package account;

import java.util.List;

import investment.Stock;
import menu.InvestmentAccountMenu;

public class InvestmentAccount extends AbstractInvestmentAccount {
	
	
	public InvestmentAccount(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Investment");
		
	}
	@Override
	public void buyCommodities() {
		// TODO Auto-generated method stub
		InvestmentAccountMenu menu = new InvestmentAccountMenu();
		menu.InvestmentAccountMenu(this);

	}
	
}
