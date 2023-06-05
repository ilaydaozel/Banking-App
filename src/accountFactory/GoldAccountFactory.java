package accountFactory;

import account.*;

public class GoldAccountFactory extends AccountFactory {

	@Override
	public AbstractAccount createAccount(String accountType) {
		AbstractGoldAccount account;
		if (accountType.equals("withInterest")) {
			account = new GoldAccountWithInterest();
		} else if (accountType.equals("withoutInterest")) {
			account = new GoldAccountWithoutInterest();
		} else {
			// default option
			account = new GoldAccountWithoutInterest();
		}
		return account;
	}
}
