/* From Assignment2 */

import java.util.ArrayList;

public class Register {

	//Instance Variable
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	
	// Constructor
	public Register() {	
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
	}
	
	/* Getter (new) */
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
		
	// Instance methods
	public void addStudent(String id, String name) {
		Student student = new Student(id, name);
		studentList.add(student);
	}

	public void addCourse(String id, String name, int credits) {
		Course course = new Course(id, name, credits);
		courseList.add(course);
	}
	
	public Student findStudent(String studentID) {
		Student find = null;
		if(studentList.size() > 0) {
			for(int i = 0; i < studentList.size(); i++) {
				if(studentList.get(i).getStudentID().equals(studentID)) {
					find = studentList.get(i);
				}
			}
		}	
		return find;
	}
	
	public Course findCourse(String course) {
		Course find = null;
		if(courseList.size() > 0) {
			for(int i = 0; i < courseList.size(); i++) {
				if(courseList.get(i).getCourseID().equals(course)) {
					find = courseList.get(i);
				}
			}			
		}
		return find;
	}
	
	public boolean enrollCourse(String studentID, String courseID) {
		boolean enrolled = false;
		if(findStudent(studentID) != null && findCourse(courseID) != null) {
			if(findStudent(studentID).getCurrentCredits() + findCourse(courseID).getCredits() <= findStudent(studentID).getMaxCredits() && !findStudent(studentID).getEnrolledCourses().contains(courseID)) {
				findStudent(studentID).setCurrentCredits(findStudent(studentID).getCurrentCredits() + findCourse(courseID).getCredits());
				findStudent(studentID).getEnrolledCourses().add(courseID);
				enrolled = true;
			}
		}
		return enrolled;
	}
	
	public boolean dropCourse(String studentID, String courseID) {
		boolean drop = false;
		if(findStudent(studentID) != null && findCourse(courseID) != null) {
			if(findStudent(studentID).getEnrolledCourses().contains(courseID)) {
				findStudent(studentID).setCurrentCredits(findStudent(studentID).getCurrentCredits() - findCourse(courseID).getCredits());
				findStudent(studentID).getEnrolledCourses().remove(courseID);
				drop = true;
			}
		}
		return drop;
	}
	
	/* new */
	
	public void removeStudent(String studentID) {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentID().equals(studentID)) {
				studentList.remove(i);
			}
		}
	}
	
	public void removeCourse(String courseID) {
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseID().equals(courseID)) {
				courseList.remove(i);
			}
		}
	}
	
}
