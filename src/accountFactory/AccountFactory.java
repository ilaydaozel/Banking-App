package accountFactory;
import account.AbstractAccount;

public abstract class AccountFactory {
	public abstract AbstractAccount createAccount(String accounType);
}
