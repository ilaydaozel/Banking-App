package account;

import enums.CurrencyType;
import interfaces.IWithInterest;

public class RegularAccountWithInterest extends AbstractRegularAccount implements IWithInterest{

	public RegularAccountWithInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Regular Account With Interest");
		
	}
	/*public void exchangeToThis(AbstractAccount exchangeAccount, double amount) {
        double exchangeRate = getBank().convert(null, null, amount)
        double exchangedBalance = amount * exchangeRate;
        setBalance(getBalance() - amount);
        // Update the foreign currency euro account balance
        exchangeAccount.setBalance(exchangeAccount.getBalance() + exchangedBalance);
    }
	public void exchangeFromThis(AbstractAccount exchangeAccount, double amount) {
        // Get the bank's currency exchange rate for EUR to TRY
        double exchangeRate = getBank().getCurrencyExchangeRate(CurrencyType.EUR, CurrencyType.TRY);

        // Calculate the exchanged balance based on the exchange rate
        double exchangedBalance = amount * exchangeRate;

        // Update the account's balance
        setBalance(getBalance() + exchangedBalance);
        // Update the foreign currency euro account balance
        exchangeAccount.setBalance(exchangeAccount.getBalance() - amount);
    }*/
	@Override
	public void exchangeToThis(AbstractAccount exchangeAccount, CurrencyType exchangeAccountType, double amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exchangeFromThis(AbstractAccount exchangeAccount, CurrencyType exchangeAccountType, double amount) {
		// TODO Auto-generated method stub
		
	}

}
