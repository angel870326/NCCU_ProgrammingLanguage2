import java.util.ArrayList;

public class OvertimeAnalyzer implements Analyzer {

	// Instance Variable
	
	private ArrayList<Employee> employees;

	
	// Constructor
	
	public OvertimeAnalyzer() {
	}
	public OvertimeAnalyzer(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	
	// Instance Method
	
	@Override
	public String summary() {
		return String.format("%19s%7d\n%19s%7d\n%19s%7d\n%19s%7d\n%19s%7d\n", "Total employees:", count(), "Total hours:", sum(), "Average hours:", avg(), "Min hours:", min(), "Max hours:", max());
	}

	// Return the number of employees who working overtime.
	@Override
	public int count() {
		int count = 0;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getOvertimeCount() > 0) {
				count++;
			}
		}		
		return count;
	}

	// Return the sum of all overtime hours.
	@Override
	public int sum() {
		int hourSum = 0;
		for(int i = 0; i < employees.size(); i++) {
			hourSum = hourSum + employees.get(i).getOvertime();
		}
		return hourSum;
	}

	// Return the average of the overtime hours.
	@Override
	public int avg() {
		if(count() != 0) {
			return sum() / count();			
		}
		else {
			return 0;
		}
	}

	// Return the max value of the overtime hours.
	@Override
	public int max() {
		int max = 0;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getOvertime() > max) {
				max = employees.get(i).getOvertime();
			}
		}
		return max;
	}

	// Return the min value of the overtime hours.
	@Override
	public int min() {
		int min = 0;
		for(int i = 0; i < employees.size(); i++) {
			if( employees.get(i).getOvertimeCount() > 0 && (employees.get(i).getOvertime() < min || min == 0)) {
				min = employees.get(i).getOvertime();
			}
		}
		return min;
	}

}
