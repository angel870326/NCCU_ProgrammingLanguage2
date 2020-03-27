
public class Tester {

	public static void main(String[] args) {
		
		Company company = new Company("NCCU");
	
		Employee emp1 = new Employee("Simon", "Staff", 1200);
	
		company.addEmployee(emp1);
		company.addEmployee(new Employee("Ding", "Staff", 1100)); 
		company.addEmployee(new Manager("Wei", "Supervisor", 1500, 1.1));
	
		company.addWorkDays("Simon", 5); 
		company.addWorkDays("Simon", 5); 
		
		company.overtimeWork("Simon", 1); 
		company.overtimeWork("Simon", 1); 
		company.overtimeWork("Simon", 1);
		
		company.addWorkDays("Ding", 7);; 
		company.overtimeWork("Ding", 1);
		
		System.out.println("summarizeWage"); 
		System.out.println(company.summaryWage()); 
		
		System.out.println("analyzeWage"); 
		System.out.println(company.analyzeWage()); 
		
		System.out.println("analyzeOvertime"); 
		System.out.println(company.analyzeOvertime());
		
	}

}
