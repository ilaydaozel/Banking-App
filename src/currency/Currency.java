package currency;

public abstract class Currency {
	private double rate;

	public Currency(double rate) {
		super();
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
