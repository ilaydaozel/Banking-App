package accountFactory;

import account.*;

public class InvestmentAccountFactory extends AccountFactory {

    @Override
    public AbstractAccount createAccount(String accountType) {
        AbstractInvestmentAccount account;
        if (accountType.equals("investment")) {
            account = new InvestmentAccount();
        } else {
            // default option
            account = new InvestmentAccount();
        }
        return account;
    }
}
