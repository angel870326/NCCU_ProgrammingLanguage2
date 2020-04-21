import java.util.ArrayList;

public class Student {

	// Instance Variable
	private String studentID;
	private String studentName;
	private ArrayList<String> enrolledCourses;
	private int currentCredits;
	private int maxCredits;

	// Constructor
	public Student() {		
	}
	
	public Student(String studentID, String name) {
		this.studentID = studentID;
		this.studentName = name;
		currentCredits = 0;
		maxCredits = 25;
		enrolledCourses = new ArrayList<String>();
	}

	// Getter
	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public ArrayList<String> getEnrolledCourses() {
		return enrolledCourses;
	}

	public int getCurrentCredits() {
		return currentCredits;
	}
	
	public int getMaxCredits() {
		return maxCredits;
	}
		
	// Setter
	public void setCurrentCredits(int currentCredits) {
		this.currentCredits = currentCredits;
	}
	
	public void setMaxCredits(int maxCredits) {
		this.maxCredits = maxCredits;
	}
	
	// Instance Methods
	@Override
	public String toString() {
		return String.format("[StudentID: %s, StudentName: %s, EnrolledCourses: %s, CurrentCredits: %d, MaxCredits: %d]", studentID, studentName, enrolledCourses, currentCredits, maxCredits);
	}
	
	
}
