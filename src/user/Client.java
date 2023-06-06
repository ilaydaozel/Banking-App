package user;

import account.AbstractAccount;
import account.AccountGroup;

public class Client {
	private String username;
    private AccountGroup accountGroup;

    public Client(String username) {
    	this.username = username;
        this.accountGroup = new AccountGroup("Top Account Group");
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountGroup getAccountGroup() {
		return accountGroup;
	}

	public void setTopAccountGroup(AccountGroup topAccountGroup) {
		this.accountGroup = topAccountGroup;
	}
	
	public void addToAccounts(AbstractAccount account) {
		accountGroup.addAccount(account);
	}
	
	public void removeFromAccounts(AbstractAccount account) {
		accountGroup.removeAccount(account);
	}
	
	@Override
	public String toString() {
		return "Client username=" + username + ", accountGroup=" + accountGroup + " ";
	}
    
	

  
}