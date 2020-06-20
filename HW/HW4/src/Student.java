import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

	// Instance Variable
	private String studentID;
	private String studentName;
	private int currentCredits;
	private int maxCredits;

	// Constructor
	public Student() {		
	}
	
	public Student(String studentID, String name, int credit, int max) {
		this.studentID = studentID;
		this.studentName = name;
		this.currentCredits = credit;
		this.maxCredits = max;
	}

	// Getter
	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getCurrentCredits() {
		return currentCredits;
	}
	
	public int getMaxCredits() {
		return maxCredits;
	}
		
	// Setter
	public void setCurrentCredits(int currentCredits) throws SQLException{
		this.currentCredits = currentCredits;
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("UPDATE Student_22" + " SET Student_current_credits = ?" + " WHERE Student_id = ?");
			stat.setInt(1, currentCredits);
			stat.setString(2, studentID);
			stat.executeUpdate();
		} finally {
			conn.close();
		}				
	}
	
	
	// Instance Methods
	public String info() throws SQLException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("SELECT E.Student_id, E.Course_id, C.Course_Name, E.Grade" + " FROM Course_22 AS C, Enroll_22 AS E" + " WHERE Student_id = ? AND C.Course_id = E.Course_id");
			stat.setString(1, studentID);						
			ResultSet result = stat.executeQuery();	
			String course = "";
			while (result.next() && result.getString("Student_id").equals(studentID)) {
				course = course + String.format("%s-%s-%d\n", result.getString("Course_id"), result.getString("Course_name"), result.getInt("Grade"));
			}
			String info = String.format("Student ID: %s\nStudent Name: %s\nCredits: %d/%d\nEnrolledCourses:\n%s", studentID, studentName, currentCredits, maxCredits, course);			
			return info;
			
		} finally {
			conn.close();
		}
		
	}
		
}
