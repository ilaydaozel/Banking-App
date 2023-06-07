package account;

import user.Bank;

public abstract class AbstractAccount {
	private double balance;
	private Bank bank;
	
	public AbstractAccount() {
		this.balance = 0;
		this.bank = new Bank();
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public abstract void display();
	
}
