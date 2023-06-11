package investment;

//Stock class
public class Stock extends Commodity {

	public Stock(String name, double value) {
		super(name, value);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Stock name: "+ getName() +" - Value: "+ getValue();
	}

}
