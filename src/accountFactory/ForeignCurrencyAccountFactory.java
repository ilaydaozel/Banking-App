package accountFactory;

import account.*;
import enums.CurrencyType;
public class ForeignCurrencyAccountFactory extends AccountFactory {
	public ForeignCurrencyAccountFactory(int accountId) {
		super(accountId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractAccount createAccount(String accountType) {
		AbstractForeignCurrencyAccount account;
		if(accountType.equals("Foreign Currency Account (EUR) with Interest")) {
			account = new ForeignCurrencyAccountWithInterest(super.getAccountIdCounter(), CurrencyType.EUR);
		}
		else if (accountType.equals("Foreign Currency Account (EUR) without Interest")) {
			account = new ForeignCurrencyAccountWithoutInterest(super.getAccountIdCounter(), CurrencyType.EUR);
		}
		else if (accountType.equals("Foreign Currency Account (USD) with Interest")) {
			account = new ForeignCurrencyAccountWithInterest(super.getAccountIdCounter(), CurrencyType.USD);
		}
		else if (accountType.equals("Foreign Currency Account (USD) without Interest")) {
			account = new ForeignCurrencyAccountWithoutInterest(super.getAccountIdCounter(), CurrencyType.USD);
		}
		else {
			//default option
			System.out.println("Default option selected");
			account = new ForeignCurrencyAccountWithoutInterest(super.getAccountIdCounter(), CurrencyType.EUR);
		}
		return account;
	}

}
