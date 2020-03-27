import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Tax tax = new LocalTax();
		Cashier cashier1 = new Cashier(tax);
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Input format: price amount. 'd' for checkout");
			String input = scanner.next();
			if(!"d".equals(input)) {
				double price = Double.parseDouble(input);
				int amount = scanner.nextInt();
				cashier1.add(price, amount);
			}
			else {
				break;
			}
		}
		scanner.close();
		System.out.println(cashier1.checkOut());
		
		System.out.println("----------");
		
		Tax foreignerTax = new ForeignerTax();
		Cashier cashier2 = new Cashier(foreignerTax);
		cashier2.add(1000, 2);
		cashier2.add(1500, 1);
		System.out.println(cashier2.checkOut());		
		
	}

}
