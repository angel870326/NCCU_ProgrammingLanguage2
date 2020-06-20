
public class Course {

	// Instance Variable
	private String courseID;
	private String courseName;
	private int credits;
	
	// Constructor
	public Course() {
	}
	
	public Course(String id, String name, int credits) {
		this.courseID = id;
		this.courseName = name;
		this.credits = credits;
	}

	// Getter
	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCredits() {
		return credits;
	}
	
	// Instance Methods
	@Override
	public String toString() {
		return String.format("[CourseID: %s, CourseName: %s, Credits: %d]", courseID, courseName, credits);
	}
	
	
	
	
}
