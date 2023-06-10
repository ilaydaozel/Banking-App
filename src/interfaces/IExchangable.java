package interfaces;

import account.AbstractAccount;

public interface IExchangable {
	public void exchange( AbstractAccount targetAccount, double amount);
}
