package account;

import interfaces.IWithInterest;

public class GoldAccountWithInterest extends AbstractGoldAccount implements IWithInterest {
    private int interestStartDate;

    public GoldAccountWithInterest(int id) {
        super(id);
    }

    @Override
    public void display() {
        System.out.println("- id:" + super.getId() + " Gold Account XAU With Interest");
    }

    @Override
    public void exchange(AbstractAccount targetAccount, double amount) {
        if (!targetAccount.equals(this)) {
            if (endInterest()) {
                if (getBalance() >= amount) {
                    if (isExchangeAllowed(targetAccount)) {
                        performExchange(targetAccount, amount);
                    } else {
                        System.out.println("You can only exchange with a gold account (XAU)!");
                    }
                } else {
                    System.out.println("Your balance is not enough!");
                }
            }
        } else {
            System.out.println("You can't exchange to the account itself, please choose another account!");
        }
    }

    @Override
    public boolean isExchangeAllowed(AbstractAccount targetAccount) {
        return targetAccount instanceof AbstractGoldAccount;
    }

    @Override
    public void performExchange(AbstractAccount targetAccount, double amount) {
        double convertedAmount = getBank().convert(getCurrencyType(), targetAccount.getCurrencyType(), amount);
        // Update balances
        setBalance(getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
        if (targetAccount instanceof IWithInterest) {
        	//set interest start day 
        	((IWithInterest) targetAccount).resetInterestDay();
        }
        System.out.println("Exchanged " + convertedAmount + " " + targetAccount.getCurrencyType().toString() + " to target account!");
    }

    public int getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(int interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public void resetInterestDay() {
        setInterestStartDate(getBank().getCurrentDay());
    }

    public boolean endInterest() {
        double totalDays = getBank().getCurrentDay() - getInterestStartDate();
        if (totalDays > 0) {
            double interestRate = getBank().getInterestRate(getCurrencyType().toString());
            double compoundInterest = calculateCompoundInterest(getBalance(), interestRate, totalDays);
            setBalance(getBalance() + compoundInterest);
            System.out.println(getCurrencyType().toString() + " account new balance: " + getBalance());
            return true;
        } else {
            System.out.println("Exchange Failed. 0 days have passed since interest started.");
            return false;
        }
    }

    private double calculateCompoundInterest(double principal, double interestRate, double totalDays) {
        double dailyRate = 1.0 + (interestRate / 365.0); // Assuming interest is calculated daily
        double compoundInterest = principal * Math.pow(dailyRate, totalDays) - principal;
        return compoundInterest;
    }

    public double checkExpectedBalance(int days) {
        double interestRate = getBank().getInterestRate(getCurrencyType().toString());
        double compoundInterest = calculateCompoundInterest(getBalance(), interestRate, days);
        double expectedBalance = getBalance() + compoundInterest;
        return expectedBalance;
    }

    public void updateInterest() {
        double totalDays = getBank().getCurrentDay() - getInterestStartDate();
        if (totalDays > 0) {
            double interestRate = getBank().getInterestRate(getCurrencyType().toString());
            double compoundInterest = calculateCompoundInterest(getBalance(), interestRate, totalDays);
            setBalance(getBalance() + compoundInterest);
        }
    }
}
