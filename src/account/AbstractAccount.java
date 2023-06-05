package account;

public abstract class AbstractAccount {
	private String name;
	private double balance;
	public AbstractAccount(String name) {
		this.name = name;
		this.balance = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
