package user;

import account.AbstractAccount;
import account.AccountGroup;

public class Client {
	private String username;
    private AccountGroup topAccountGroup;

    public Client(String username) {
    	this.username = username;
        this.topAccountGroup = new AccountGroup("Top Account Group");
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountGroup getAccountGroup() {
		return topAccountGroup;
	}

	public void setTopAccountGroup(AccountGroup topAccountGroup) {
		this.topAccountGroup = topAccountGroup;
	}
	
	public void addToTopAccountGroup(AbstractAccount account) {
		topAccountGroup.addAccount(account);
	}
	
	public void removeFromTopAccountGroup(AbstractAccount account) {
		topAccountGroup.removeAccount(account);
	}
	
	public void addToGivenAccountGroup(AbstractAccount newAccount, AccountGroup accountGroup) {
		for(AbstractAccount element: topAccountGroup.getAccounts()) {
			if(element.equals(accountGroup)) {
				//add an account to the given account group
				((AccountGroup)element).addAccount(newAccount);
			}
		}
	}
	
	public void removeFromGivenAccountGroup(AbstractAccount newAccount, AccountGroup accountGroup) {
		for(AbstractAccount element: topAccountGroup.getAccounts()) {
			if(element.equals(accountGroup)) {
				//remove an account from the given account group
				((AccountGroup)element).removeAccount(newAccount);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Client username=" + username + ", accountGroup=" + topAccountGroup + " ";
	}
    
	

  
}