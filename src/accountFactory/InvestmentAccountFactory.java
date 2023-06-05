package accountFactory;

import account.*;

public class InvestmentAccountFactory extends AccountFactory {

    @Override
    public AbstractAccount createAccount(String accountType) {
        AbstractInvestmentAccount account = new InvestmentAccount();
        return account;
    }
}
