package accountFactory;

import account.*;

public class InvestmentAccountFactory extends AccountFactory {
	public InvestmentAccountFactory(int accountId) {
		super(accountId);
		// TODO Auto-generated constructor stub
	}

    @Override
    public AbstractAccount createAccount(String accountType) {
        AbstractInvestmentAccount account = new InvestmentAccount(super.getAccountIdCounter());
        return account;
    }
}
