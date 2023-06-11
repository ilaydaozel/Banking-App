package accountFactory;

import account.*;

public class GoldAccountFactory extends AccountFactory {
	public GoldAccountFactory(int accountId) {
		super(accountId);
		// TODO Auto-generated constructor stub
	}
	@Override
	public AbstractAccount createAccount(String accountType) {
		AbstractGoldAccount account;
		if (accountType.equals("withInterest")) {
			account = new GoldAccountWithInterest(super.getAccountIdCounter());
		} else if (accountType.equals("withoutInterest")) {
			account = new GoldAccountWithoutInterest(super.getAccountIdCounter());
		} else {
			// default option
			System.out.println("Default option selected");
			account = new GoldAccountWithoutInterest(super.getAccountIdCounter());
		}
		return account;
	}
}
