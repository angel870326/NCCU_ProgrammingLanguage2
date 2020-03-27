
public class Manager extends Employee {
	
	// Instance Variable

	private double bonusRate;  // The manager can get extra wage (rate).

	
	// Constructor
	
	public Manager() {
		
	}
	
	public Manager(String name, String title, int dailyWage, double bonusRate) {
		super(name, title, dailyWage);
		this.bonusRate = bonusRate;
	}

	
	// Instance Method

	@Override
	public int payment() {
		int wage = (int)Math.round((super.payment() * bonusRate));
		return wage;
	}
}
