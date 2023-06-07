package accountFactory;

import account.*;

public abstract class AccountFactory {
	private int accountIdCounter;
	
	public AccountFactory(int accountIdCounter) {
		super();
		this.accountIdCounter = accountIdCounter;
	}

	public int getAccountIdCounter() {
		return accountIdCounter;
	}

	public void setAccountIdCounter(int accountIdCounter) {
		this.accountIdCounter = accountIdCounter;
	}

	public abstract AbstractAccount createAccount(String accountType);
}
