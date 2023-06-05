package accountFactory;

import account.*;

public abstract class AccountFactory {
	public abstract AbstractAccount createAccount(String accountType);
}
