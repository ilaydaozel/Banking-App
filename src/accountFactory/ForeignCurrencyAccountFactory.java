package accountFactory;

import account.*;

public class ForeignCurrencyAccountFactory extends AccountFactory {

	@Override
	public AbstractAccount createAccount(String accountType) {
		AbstractForeignCurrencyAccount account;
		if(accountType.equals("withInterest")) {
			account = new ForeignCurrencyAccountWithInterest("");
		}
		else if (accountType.equals("withoutInterest")) {
			account = new ForeignCurrencyAccountWithoutInterest("");
		}
		else {
			//default
			account = new ForeignCurrencyAccountWithoutInterest("");
		}
		return account;
	}

}
