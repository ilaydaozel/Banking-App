package accountFactory;

public class AccountFactoryFactory {
	private int idCounter = 0;
	
	public AccountFactory createAccountFactory(String factoryType) {
		AccountFactory accountFactory;
		if(factoryType.equals("Regular")) {
			accountFactory = new RegularAccountFactory(idCounter);
			idCounter ++;
		}
		else if (factoryType.equals("Foreign Currency")) {
			accountFactory = new ForeignCurrencyAccountFactory(idCounter);
			idCounter ++;
		}
		else if (factoryType.equals("Gold")) {
			accountFactory = new GoldAccountFactory(idCounter);
			idCounter ++;
		}
		else if (factoryType.equals("Investment")) {
			accountFactory = new InvestmentAccountFactory(idCounter);
			idCounter ++;
		}
		else {
			//default option
			accountFactory = new RegularAccountFactory(idCounter);
			idCounter ++;
		}
		
		return accountFactory;
	}
}
