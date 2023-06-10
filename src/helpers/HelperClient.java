package helpers;

import account.AbstractAccount;
import user.Client;

public class HelperClient {
	private Client client;

	public HelperClient(Client client) {
		this.client = client;
	}
	
    public void displayAccounts() {
		client.getAccountGroup().display();
		
	}
    
    public AbstractAccount selectAnAccount() {
    	client.getAccountGroup().display();
        System.out.print("Enter the id of the account: ");
        int selectedAccountId = HelperIO.readIntegerInput();
        AbstractAccount selectedAccount = client.getAccountGroup().getSelectedAccountByIdAllGroups(selectedAccountId);
        return selectedAccount;
    }

    
	
}
