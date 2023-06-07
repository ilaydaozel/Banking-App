package account;

public abstract class AbstractInvestmentAccount extends AbstractAccount {
	private int id;
	public AbstractInvestmentAccount(int id) {
		this.setId(id);
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
