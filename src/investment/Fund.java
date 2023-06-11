package investment;

//Fund class
public class Fund extends Commodity {

	public Fund(String name, double value) {
		super(name, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fund name: "+ getName() +" - Value: "+ getValue();
	}

}
