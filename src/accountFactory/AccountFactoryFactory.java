package accountFactory;

public class AccountFactoryFactory {
	public AccountFactory createAccountFactory(String factoryType) {
		AccountFactory accountFactory;
		if(factoryType.equals("Regular")) {
			accountFactory = new RegularAccountFactory();
		}
		else if (factoryType.equals("Foreign Currency")) {
			accountFactory = new ForeignCurrencyAccountFactory();
		}
		else if (factoryType.equals("Gold")) {
			accountFactory = new GoldAccountFactory();
		}
		else if (factoryType.equals("Investment")) {
			accountFactory = new InvestmentAccountFactory();
		}
		else {
			//default option
			accountFactory = new RegularAccountFactory();
		}
		return accountFactory;
	}
}
