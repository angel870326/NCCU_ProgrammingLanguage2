import java.util.ArrayList;

public class WageAnalyzer implements Analyzer {

	// Instance Variable
	
	private ArrayList<Employee> employees;

	
	// Constructor
	
	public WageAnalyzer() {
	}
	public WageAnalyzer(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	
	// Instance Method
	
	@Override
	public String summary() {
		return String.format("%19s%7d\n%19s%7d\n%19s%7d\n%19s%7d\n%19s%7d\n", "Total employees:", count(), "Total wage:", sum(), "Average wage:", avg(), "Min wage:", min(), "Max wage:", max());
	}

	/* Return the number of employees. */
	@Override
	public int count() {
		return employees.size();
	}

	/* Return the sum of all wage. */
	@Override
	public int sum() {
		int wageSum = 0;
		for(int i = 0; i < employees.size(); i++) {
			wageSum = wageSum + employees.get(i).payment();
		}
		return wageSum;
	}

	/* Return the average of the wage. */
	@Override
	public int avg() {
		if(count() != 0) {
			return sum() / count();			
		}
		else {
			return 0;
		}
	}

	/* Return the max value of the wage. */
	@Override
	public int max() {
		int max = 0;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).payment() > max) {
				max = employees.get(i).payment();
			}
		}
		return max;
	}

	/* Return the min value of the wage. */
	@Override
	public int min() {
		int min;
		if(employees.size() > 0) {
			min = employees.get(0).payment();
			for(int i = 1; i < employees.size(); i++) {
				if(employees.get(i).payment() < min) {
					min = employees.get(i).payment();
				}
			}
		}
		else {
			min = 0;
		}		
		return min;
	}

}
