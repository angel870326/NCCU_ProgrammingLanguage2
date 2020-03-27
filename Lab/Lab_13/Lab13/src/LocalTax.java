
public class LocalTax implements Tax {
	
	@Override
	public double addTax(double price) {
		// TODO Auto-generated method stub
		return price * 0.05;
	}

}
