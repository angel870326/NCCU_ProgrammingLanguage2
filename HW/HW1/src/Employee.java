
public class Employee {

	// Instance Variable
	
	private String name;
	private String title;
	private int dailyWage;
	private int workDay;
	private int overtimeCount;  // The days the employee works overtime.
	private int overtime;       // Total hours of working overtime.

	
	// Constructor
	
	public Employee() {
	}
	
	public Employee(String name, String title, int dailyWage) {
		this.name = name;
		this.title = title;
		this.dailyWage = dailyWage;
		this.workDay = 0;
		this.overtimeCount = 0;
		this.overtime = 0;
	}
	

	// Getter
	
	public String getName() {
		return name;
	}
	public int getWorkDay() {
		return workDay;
	}
	public int getOvertimeCount() {
		return overtimeCount;
	}
	public int getOvertime() {
		return overtime;
	}	
	public String getTitle() {
		return title;
	}

	
	// Instance Method
	
	public int payment() {
		int wage = dailyWage * workDay + overtime * 150;
		return wage;
	}
	
	public void addWorkDays(int dayCount) {
		workDay = workDay + dayCount;
	}
	
	public void overtimeWork(int hour) {
		overtime = overtime + hour;
		overtimeCount++;
	}
	
	
}
