package account;

import enums.CurrencyType;
import interfaces.IWithInterest;

public class ForeignCurrencyAccountWithInterest extends AbstractForeignCurrencyAccount implements IWithInterest{
	

	public ForeignCurrencyAccountWithInterest(int id, CurrencyType curType) {
		super(id, curType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("- id:" + super.getId() + " Foreign Currency Account With Interest ");
		
	}

	
    public void exchangeToThis(AbstractAccount exchangeAccount, double amount) {
        // Get the bank's currency exchange rate for EUR to the specified exchange account type
        double convertedAmount = getBank().convert(CurrencyType.TRY, this.getCurrencyType(), amount);

        // Update the account's balance
        setBalance(getBalance() + convertedAmount);
        // Update the exchange account's balance
        exchangeAccount.setBalance(exchangeAccount.getBalance() - amount);
    }

    public void exchangeFromThis(AbstractAccount exchangeAccount, double amount) {

        double convertedAmount = getBank().convert(this.getCurrencyType(), CurrencyType.TRY, amount);

        // Update the account's balance
        setBalance(getBalance() - amount);
        // Update the exchange account's balance
        exchangeAccount.setBalance(exchangeAccount.getBalance() + convertedAmount);
    }

}
