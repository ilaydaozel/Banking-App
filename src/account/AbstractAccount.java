package account;

import enums.CurrencyType;
import user.Bank;

public abstract class AbstractAccount {
	private double balance;
	private Bank bank = Bank.getInstance();
	private CurrencyType currencyType;
	
	public AbstractAccount() {
		this.balance = 0;
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

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public abstract void display();
	
}
