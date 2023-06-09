package account;

import currency.Currency;
import enums.CurrencyType;
import interfaces.IWithoutInterest;
import user.Bank;

public class ForeignCurrencyAccountWithoutInterest extends AbstractForeignCurrencyAccount implements IWithoutInterest{



	public ForeignCurrencyAccountWithoutInterest(int id, CurrencyType curType) {
		super(id, curType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Foreign Currency Account Without Interest");
		
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
    	setBalance(2000);
    	setBank(new Bank());
        double convertedAmount = this.getBank().convert(this.getCurrencyType(), CurrencyType.TRY, amount);
        System.out.println("convertedAmount" + convertedAmount);
        // Update the account's balance
        setBalance(getBalance() - amount);
        // Update the exchange account's balance
        exchangeAccount.setBalance(exchangeAccount.getBalance() + convertedAmount);
    }

	
}
