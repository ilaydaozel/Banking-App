package interfaces;

import account.AbstractAccount;

public interface IExchangable {
	public void exchange( AbstractAccount targetAccount, double amount);
	public boolean isExchangeAllowed(AbstractAccount targetAccount);
	public void performExchange(AbstractAccount targetAccount, double amount);
	
	
}
