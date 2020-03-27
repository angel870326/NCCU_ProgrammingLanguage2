import java.util.ArrayList;

public class Company {
	
	// Instance Variable
	
	private String name;
	private ArrayList<Employee> employees;
	private WageAnalyzer wageAnalyzer;
	private OvertimeAnalyzer overtimeAnalyzer;


	// Constructor
	 public Company(String name) {
		 this.name = name;
		 this.employees = new ArrayList<Employee>();
		 this.wageAnalyzer = new WageAnalyzer(employees);
		 this.overtimeAnalyzer = new OvertimeAnalyzer(employees);
	 }
	

	 // Instance Method
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public Employee findEmployee(String name) {	
		Employee find = null;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getName().equals(name)) {
				find = employees.get(i);
			}
		}
		return find;
	}
	
	public void addWorkDays(String name, int day) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getName().equals(name)) {
				employees.get(i).addWorkDays(day);
			}
		}
		/*
		Employee find = findEmployee(name);
		find.addWorkDays(day);
		*/
	}
	
	public void overtimeWork(String name, int hour) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getName().equals(name)) {
				employees.get(i).overtimeWork(hour);;
			}
		}
		/*
		Employee find = findEmployee(name);
		find.overtimeWork(hour);
		*/
	}
	
	public String summaryWage() {
		String employeeStr = "";
		for(int i = 0; i < employees.size(); i++) {
			employeeStr = employeeStr + String.format("%10s%10d%15d%21d%7d%12s\n", employees.get(i).getName(), employees.get(i).getWorkDay(), employees.get(i).getOvertimeCount(), employees.get(i).getOvertime(), employees.get(i).payment(), employees.get(i).getTitle());
		}
		return String.format("%10s%10s\n%10s%10s%15s%21s%7s%12s\n%s", "Company:", name, "Name", "Work Day", "Overtime Count", "Overtime Hour(Total)", "Wage", "Title", employeeStr);
	}
	
	public String analyzeWage() {
		return wageAnalyzer.summary();
	}
	
	public String analyzeOvertime() {
		return overtimeAnalyzer.summary();
	}
	

}
