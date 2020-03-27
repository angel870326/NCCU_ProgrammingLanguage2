
public class ForeignerTax implements Tax {

	@Override
	public double addTax(double price) {
		// TODO Auto-generated method stub
		if(price >= 2000) {
			return 0;			
		}
		else {
			return price * 0.05;
		}
	}

}
