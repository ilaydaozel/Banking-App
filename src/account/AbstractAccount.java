package account;

public abstract class AbstractAccount {
	private double balance;
	private int id;
	public AbstractAccount(int id) {
		this.balance = 0;
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void display();
	
}
