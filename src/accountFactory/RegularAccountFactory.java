package accountFactory;

import account.*;

public class RegularAccountFactory extends AccountFactory {

    @Override
    public AbstractAccount createAccount(String accountType) {
        AbstractRegularAccount account;
        if (accountType.equals("withInterest")) {
            account = new RegularAccountWithInterest();
        } else if (accountType.equals("withoutInterest")) {
            account = new RegularAccountWithoutInterest();
        } else {
            // default option
            account = new RegularAccountWithoutInterest();
        }
        return account;
    }
}
