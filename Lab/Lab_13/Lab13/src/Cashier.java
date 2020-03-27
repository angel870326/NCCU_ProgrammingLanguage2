
public class Cashier {

	// Instance Variable
	
	private Tax tax;             // The applied tax policy.
	private double beforeTax;    // Subtotal amount before calculating the tax.
	private double afterTax;     // Total amount after calculating the tax.
	private int itemCount;       // Total amount of item purchased.

	// Constructor
	
	public Cashier() {
	}
	
	public Cashier(Tax aTax) {
		this.tax = aTax;
		this.beforeTax = 0;
		this.afterTax = 0;
		this.itemCount = 0;
	}

	// Instance Methods
	
	public void add(double price, int amount) {
		beforeTax = beforeTax + price * amount;
		itemCount = itemCount + amount;
	}
	
	public String checkOut() {
		afterTax = beforeTax + tax.addTax(beforeTax);
		String descrip = String.format("Total amount: %d\nBefore tax: %.2f\nAfter tax: %.2f", itemCount, beforeTax, afterTax);
		return descrip;
	}
	
}
