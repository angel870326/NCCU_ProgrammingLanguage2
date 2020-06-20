import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Register {
	
	// Constructor
	public Register() {			
	}
	

	// Instance methods
	public void addStudent(String id, String name) throws SQLException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("INSERT INTO Student_22" + " VALUES(?, ?, ?, ?)");
			stat.setString(1, id);
			stat.setString(2, name);
			stat.setInt(3, 0);
			stat.setInt(4, 25);
			stat.execute();
		} finally {
			conn.close();
		}						
	}

	public void addCourse(String id, String name, int credits) throws SQLException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("INSERT INTO Course_22" + " VALUES(?, ?, ?)");
			stat.setString(1, id);
			stat.setString(2, name);
			stat.setInt(3, credits);
			stat.execute();
		} finally {
			conn.close();
		}					
	}
	
	public Student findStudent(String studentID) throws SQLException {		
		Student find = null;
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM Student_22 WHERE Student_id = ?");
			stat.setString(1, studentID);
			ResultSet result = stat.executeQuery(); 
			if(result.next() && result.getString("Student_id").equals(studentID)) {
				find = new Student(result.getString("Student_id"), result.getString("Student_name"), result.getInt("Student_current_credits"), result.getInt("Student_max_credits"));
			}
			return find;
		} finally {
			conn.close();
		}						
	}
	
	public Course findCourse(String courseID) throws SQLException{
		Course find = null;
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM Course_22 WHERE Course_id = ?");
			stat.setString(1, courseID);
			ResultSet result = stat.executeQuery(); 
			if(result.next() && result.getString("Course_id").equals(courseID)) {
				find = new Course(result.getString("Course_id"), result.getString("Course_name"), result.getInt("Course_credits"));
			}
			return find;
		} finally {
			conn.close();
		}				
	}
	
	public boolean enrollCourse(String studentID, String courseID) throws SQLException {
		boolean enrolled = false;
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			if(findStudent(studentID) != null && findCourse(courseID) != null) {
				PreparedStatement stat1 = conn.prepareStatement("SELECT COUNT(*) FROM Enroll_22 WHERE Student_id = ? AND Course_id = ?");
				stat1.setString(1, studentID);
				stat1.setString(2, courseID);		
				ResultSet result = stat1.executeQuery();
				result.next();				
				if(findStudent(studentID).getCurrentCredits() + findCourse(courseID).getCredits() <= findStudent(studentID).getMaxCredits() && result.getInt(1) == 0) {
					findStudent(studentID).setCurrentCredits(findStudent(studentID).getCurrentCredits() + findCourse(courseID).getCredits());
					PreparedStatement stat2 = conn.prepareStatement("INSERT INTO Enroll_22" + " VALUES(?, ?, ?)");
					stat2.setString(1, studentID);
					stat2.setString(2, courseID);
					stat2.setInt(3, 0);
					stat2.execute();					
					enrolled = true;
				}
			}
			return enrolled;		
		} finally {
			conn.close();
		}				
	}
	
	public boolean dropCourse(String studentID, String courseID) throws SQLException {
		boolean drop = false;
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			if(findStudent(studentID) != null && findCourse(courseID) != null) {
				PreparedStatement stat1 = conn.prepareStatement("SELECT COUNT(*) FROM Enroll_22 WHERE Student_id = ? AND Course_id = ?");
				stat1.setString(1, studentID);
				stat1.setString(2, courseID);						
				ResultSet result = stat1.executeQuery();
				result.next();				
				if(result.getInt(1) != 0) {
					findStudent(studentID).setCurrentCredits(findStudent(studentID).getCurrentCredits() - findCourse(courseID).getCredits());
					PreparedStatement stat2 = conn.prepareStatement("DELETE FROM Enroll_22" + " WHERE Student_id = ? AND Course_id = ?");
					stat2.setString(1, studentID);
					stat2.setString(2, courseID);
					stat2.execute();					
					drop = true;
				}
			}
			return drop;		
		} finally {
			conn.close();
		}					
	}
	
	public void removeStudent(String studentID) throws SQLException {		
		Connection conn = null;
		try {
			conn = DataSource.getConnection();	
			PreparedStatement stat1 = conn.prepareStatement("DELETE FROM Student_22" + " WHERE Student_id = ?");
			stat1.setString(1, studentID);
			stat1.execute();
			//
			PreparedStatement stat2 = conn.prepareStatement("DELETE FROM Enroll_22" + " WHERE Student_id = ?");
			stat2.setString(1, studentID);
			stat2.execute();	
		} finally {
			conn.close();
		}					
	}
	
	public void removeCourse(String courseID) throws SQLException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();	
			PreparedStatement stat1 = conn.prepareStatement("DELETE FROM Course_22" + " WHERE Course_id = ?");
			stat1.setString(1, courseID);
			stat1.execute();
			//
			PreparedStatement stat2 = conn.prepareStatement("DELETE FROM Enroll_22" + " WHERE Course_id = ?");
			stat2.setString(1, courseID);
			stat2.execute();	
			
		} finally {
			conn.close();
		}					
	}
	
	public void updateGrade(String studentID, String courseID, int grade) throws SQLException {
		Connection conn = null;
		try {
			conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("UPDATE Enroll_22" + " SET Grade = ?" + " WHERE Student_id = ? AND Course_id = ?");
			stat.setInt(1, grade);
			stat.setString(2, studentID);
			stat.setString(3, courseID);
			stat.executeUpdate();
		} finally {
			conn.close();
		}								
	}
	
	
}
