
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class RegisterFrame extends JFrame {

	// Constant Variable
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 360;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_WIDTH = 30;
	private static final int AREA_HEIGHT = 10;

	// Instance Variable
	private final Register register;
	private JPanel panel;
	private JLabel studentIDLabel;
	private JLabel courseIDLabel;
	private JLabel gradeLabel;					// new
	private JTextField studentIDField;
	private JTextField courseIDField;
	private JTextField gradeField;				// new
	private JButton studentInfoButton;
	private JButton courseInfoButton;
	private JButton enrollButton;
	private JButton dropButton;	
	private JButton updateButton;				// new
	private JScrollPane scrollPane;	
	private JTextArea outputTextArea;
	private JMenuBar menuBar;
	
	// Constructor
	public RegisterFrame() {
		register = new Register();	
		setTitle("Course Register");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		createPanel();
		add(panel);
		
		createMenuBar();
		setJMenuBar(menuBar);
		
	}
	
	// Getter
	public Register getRegister() {
		return register;
	}
	
	// Instance Methods
	
	public void createStudentIDComp() {
		studentIDLabel = new JLabel("Student ID: ");
		studentIDField = new JTextField(FIELD_WIDTH);
		studentInfoButton = new JButton("Student INFO");
		
		class StudentListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				String stuID = studentIDField.getText();
				if(stuID.length() != 9) {
					JOptionPane.showMessageDialog(null, "Student ID length should be 9.");	
				}
				else {
					try {
						Student find = register.findStudent(stuID);
						if(find != null) {
							outputTextArea.append(find.info() + "\n");
						}
						else {
							outputTextArea.append("False\n");
						}					
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
//						e.printStackTrace();											
					}
				}		
			}
		}		
		studentInfoButton.addActionListener(new StudentListener());
	}
	
	public void createCourseIDComp() {		
		courseIDLabel = new JLabel("Course ID: ");
		courseIDField = new JTextField(FIELD_WIDTH);
		courseInfoButton = new JButton("Course INFO");
		
		class CourseListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				String courseID = courseIDField.getText();			
				if(courseID.length() != 9) {
					JOptionPane.showMessageDialog(null, "Course ID length should be 9.");	
				}
				else {
					try {
						Course find = register.findCourse(courseID);
						if(find != null) {
							outputTextArea.append(find.toString() + "\n");
						}
						else {
							outputTextArea.append("False\n");
						}		
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null, e.getMessage());	
					}
				}		
			}
		}	
		courseInfoButton.addActionListener(new CourseListener());
	}
	
	
	// new
	public void createGradeComp() {
		gradeLabel = new JLabel("Grade: ");
		gradeField = new JTextField(FIELD_WIDTH);
		updateButton = new JButton("Update grade");
		
		class GradeListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				String grade = gradeField.getText();
				try {
					int gradeInt = Integer.parseInt(grade);
					register.updateGrade(studentIDField.getText(), courseIDField.getText(), gradeInt);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Grade must be integer.");	
				}
				catch(SQLException e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}			
			}
		}	
		updateButton.addActionListener(new GradeListener());		
	}
	
	
	public void createEnrollBtn() {
		enrollButton = new JButton("Enroll");	
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {	
				String studentID = studentIDField.getText();
				String courseID = courseIDField.getText();
				if(studentID.length() != 9 || courseID.length() != 9) {
					JOptionPane.showMessageDialog(null, "Course/Student ID length should be 9.");	
				}
				else {
					try {
						boolean enroll = register.enrollCourse(studentID, courseID);
						if(enroll == true) {
							outputTextArea.append(studentIDField.getText() + " enrolled in " + courseIDField.getText() + "\n");
						}
						else {
							outputTextArea.append("False\n");
						}
					}
					catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());	
					}										
				}		
			}
		}		
		enrollButton.addActionListener(new ClickListener());
	}
	
	public void createDropBtn() {
		dropButton = new JButton("Drop");	
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				String studentID = studentIDField.getText();
				String courseID = courseIDField.getText();
				if(studentID.length() != 9 || courseID.length() != 9) {
					JOptionPane.showMessageDialog(null, "Course/Student ID length should be 9.");	
				}
				else {
					try {
						boolean drop = register.dropCourse(studentIDField.getText(), courseIDField.getText());
						if(drop == true) {
							outputTextArea.append(studentIDField.getText() + " dropped out of " + courseIDField.getText() + "\n");
						}
						else {
							outputTextArea.append("False\n");
						}
					}
					catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
//						e.printStackTrace();
					}	
				}			
			}
		}		
		dropButton.addActionListener(new ClickListener());
	}
	
	/* Output Area */
		
	public void createOutputArea() {
		outputTextArea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);	
		scrollPane = new JScrollPane(outputTextArea);	
		outputTextArea.setLineWrap(true);
		outputTextArea.setWrapStyleWord(true);
	}
	
	/* File Menu */
		
	public JMenu createFileMenu() {
		JMenu file = new JMenu("File");
		file.add(createFileStuItem());
		file.add(createFileCourseItem());
		file.add(createFileExitItem());
		return file;
	}
	
	public JMenuItem createFileStuItem() {
		JMenuItem student = new JMenuItem("Student");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				StudentFrame stuFrame = new StudentFrame();
				stuFrame.setTitle("Manage Students");
				stuFrame.setLocation(FRAME_WIDTH, 0);							
			}
		}
		ActionListener listener = new MenuItemListener();
		student.addActionListener(listener);		
		return student;		
	}
	
	public JMenuItem createFileCourseItem() {
		JMenuItem course = new JMenuItem("Course");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				CourseFrame courseFrame = new CourseFrame();
				courseFrame.setTitle("Manage Courses");
				courseFrame.setLocation(FRAME_WIDTH, 0);							
			}
		}
		ActionListener listener = new MenuItemListener();
		course.addActionListener(listener);		
		return course;
	}
	
	public JMenuItem createFileExitItem() {
		JMenuItem exit = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		exit.addActionListener(listener);		
		return exit;
	}
	
	
	/* Menu Bar */
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.add(createFileMenu());		
	}
	
	
	/* Create Panel */

	public void createPanel() {
		panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,3));
		
		createStudentIDComp();		
		createCourseIDComp();
		createGradeComp();
		
		panel1.add(studentIDLabel);
		panel1.add(studentIDField);
		panel1.add(studentInfoButton);
		panel1.add(courseIDLabel);
		panel1.add(courseIDField);
		panel1.add(courseInfoButton);
		panel1.add(gradeLabel);
		panel1.add(gradeField);
		panel1.add(updateButton);
		
		createEnrollBtn();
		createDropBtn();
		JPanel btnPanel = new JPanel();
		btnPanel.add(enrollButton);
		btnPanel.add(dropButton);
		
		createOutputArea();
		panel.add(panel1);		
		panel.add(btnPanel);		
		panel.add(scrollPane);
	}
	
}
