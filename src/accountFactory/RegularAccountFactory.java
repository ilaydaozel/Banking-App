package accountFactory;

import account.*;

public class RegularAccountFactory extends AccountFactory {
	public RegularAccountFactory(int accountId) {
		super(accountId);
		// TODO Auto-generated constructor stub
	}

    @Override
    public AbstractAccount createAccount(String accountType) {
        AbstractRegularAccount account;
        if (accountType.equals("withInterest")) {
            account = new RegularAccountWithInterest(super.getAccountIdCounter());
        } else if (accountType.equals("withoutInterest")) {
            account = new RegularAccountWithoutInterest(super.getAccountIdCounter());
        } else {
            // default option
        	System.out.println("Default option selected");
            account = new RegularAccountWithoutInterest(super.getAccountIdCounter());
        }
        return account;
    }
}
