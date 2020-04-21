import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;


public class RegisterFrame extends JFrame {

	// Constant Variable
	private static final int FRAME_WIDTH = 360;
	private static final int FRAME_HEIGHT = 160;
	private static final int FIELD_WIDTH = 10;

	// Instance Variable
	private final Register register;
	private JPanel panel;
	private JLabel studentIDLabel;
	private JLabel courseIDLabel;
	private JTextField studentIDField;
	private JTextField courseIDField;
	private JButton studentInfoButton;
	private JButton courseInfoButton;
	private JButton enrollButton;
	private JButton dropButton;
	
	// Constructor
	public RegisterFrame() {
		register = new Register();
		register.addCourse("306049001", "OOPI", 2);
		register.addCourse("306005001", "ICS", 2);
		register.addCourse("001303999", "Intern", 23); 
		register.addStudent("107306001", "A");
		register.addStudent("107306010", "B");
		
		setTitle("Course Register");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		createPanel();
		add(panel);
		
	}

	public void createStudentIDComp() {
		studentIDLabel = new JLabel("Student ID: ");
		studentIDField = new JTextField(FIELD_WIDTH);
		studentInfoButton = new JButton("Student INFO");
		
		class StudentListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				Student find = register.findStudent(studentIDField.getText());
				if(find != null) {
					System.out.println(find.toString());
				}
				else {
					System.out.println("False");
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
				Course find = register.findCourse(courseIDField.getText());
				if(find != null) {
					System.out.println(find.toString());
				}
				else {
					System.out.println("False");
				}
			}
		}	
		courseInfoButton.addActionListener(new CourseListener());

	}
	
	public void createEnrollBtn() {
		enrollButton = new JButton("Enroll");
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {				
				boolean enroll = register.enrollCourse(studentIDField.getText(), courseIDField.getText());
				if(enroll == true) {
					System.out.println(studentIDField.getText() + " enrolled in " + courseIDField.getText());
				}
				else {
					System.out.println("False");
				}
			}
		}		
		enrollButton.addActionListener(new ClickListener());

	}
	
	public void createDropBtn() {
		dropButton = new JButton("Drop");
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				boolean drop = register.dropCourse(studentIDField.getText(), courseIDField.getText());
				if(drop == true) {
					System.out.println(studentIDField.getText() + " dropped out of " + courseIDField.getText());
				}
				else {
					System.out.println("False");
				}
			}
		}		
		dropButton.addActionListener(new ClickListener());

	}
	
	public void createPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		
		createStudentIDComp();
		JPanel stuPanel = new JPanel();
		stuPanel.add(studentIDLabel);
		stuPanel.add(studentIDField);
		stuPanel.add(studentInfoButton);
		
		createCourseIDComp();
		JPanel courPanel = new JPanel();
		courPanel.add(courseIDLabel);
		courPanel.add(courseIDField);
		courPanel.add(courseInfoButton);
		
		createEnrollBtn();
		createDropBtn();
		JPanel btnPanel = new JPanel();
		btnPanel.add(enrollButton);
		btnPanel.add(dropButton);
		
		panel.add(stuPanel);
		panel.add(courPanel);
		panel.add(btnPanel);
		

	}


	
}
