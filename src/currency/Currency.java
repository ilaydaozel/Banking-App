package currency;

public abstract class Currency {
	private double rate;
	private double dailyInterestRate;
	public Currency(double rate,double dailyInterestRate) {
		super();
		this.rate = rate;
		this.setDailyInterestRate(dailyInterestRate);
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getDailyInterestRate() {
		return dailyInterestRate;
	}

	public void setDailyInterestRate(double dailyInterestRate) {
		this.dailyInterestRate = dailyInterestRate;
	}
}
