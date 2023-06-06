package account;

public abstract class AbstractAccount {
	private double balance;
	
	public AbstractAccount() {
		this.balance = 0;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public abstract void display();
	
}
