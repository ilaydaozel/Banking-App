package account;

import interfaces.IWithInterest;

public class GoldAccountWithInterest extends AbstractGoldAccount implements IWithInterest {
	private int interestStartDate;
	public GoldAccountWithInterest(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void display() {
		System.out.println("- id:" + super.getId() +" Gold Account With Interest");
		
	}
	
	@Override
	public void exchange(AbstractAccount targetAccount, double amount) {
		if(endInterest()) {
			if (this.getBalance() >= amount) {
				if (targetAccount instanceof GoldAccountWithoutInterest) {
		            double convertedAmount = this.getBank().convert(this.getCurrencyType(), targetAccount.getCurrencyType(), amount);
		            // Update balances
		            setBalance(this.getBalance() - amount);
		            targetAccount.setBalance(targetAccount.getBalance() + convertedAmount);
		            System.out.println("Exchanged " + convertedAmount + " "+ targetAccount.getCurrencyType().toString() + " to target account!");
		        
			    } else {
			        System.out.println("You can only with a gold account without interest (XAU)!");
			    }
			} else {
			    System.out.println("Your balance is not enough!");
			}
		}
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
	        resetInterestDay();
	        double interestRate = getBank().getInterestRate(getCurrencyType().toString());
	        double compoundInterest = calculateCompoundInterest(getBalance(), interestRate, totalDays);
	        setBalance(getBalance() + compoundInterest);
	        System.out.println(getCurrencyType().toString() + " account new balance: " + getBalance());
	        return true;
	    } else {
	        System.out.println("Exchange Failed. 0 days has passed since interest started.");
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
