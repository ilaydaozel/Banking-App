package account;

import user.Bank;

public abstract class AbstractAccount {
	private double balance;
	private int id;
	private Bank bank;
	
	public AbstractAccount(int id) {
		this.balance = 0;
		this.id = id;
		this.bank = new Bank();
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public abstract void display();
	
}
