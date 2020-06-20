/* From Assignment2 */

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;						// new
import javax.swing.JTextArea;						// new
import javax.swing.JMenuBar;						// new
import javax.swing.JMenu;							// new
import javax.swing.JMenuItem;						// new



public class RegisterFrame extends JFrame {

	// Constant Variable
	private static final int FRAME_WIDTH = 380;
	private static final int FRAME_HEIGHT = 360;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_WIDTH = 30;        // new
	private static final int AREA_HEIGHT = 10;       // new

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
	private JScrollPane scrollPane;					// new
	private JTextArea outputTextArea;				// new
	private JMenuBar menuBar;						// new
	
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
		
		createMenuBar();			// new
		setJMenuBar(menuBar);		// new
		
	}
	
	// Getter
	public Register getRegister() {
		return register;
	}
	
	// Instance Methods (modified -> append to Text Area)

	public void createStudentIDComp() {
		studentIDLabel = new JLabel("Student ID: ");
		studentIDField = new JTextField(FIELD_WIDTH);
		studentInfoButton = new JButton("Student INFO");
		
		class StudentListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				Student find = register.findStudent(studentIDField.getText());
				if(find != null) {
					outputTextArea.append(find.toString() + "\n");
				}
				else {
					outputTextArea.append("False\n");
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
					outputTextArea.append(find.toString() + "\n");
				}
				else {
					outputTextArea.append("False\n");
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
					outputTextArea.append(studentIDField.getText() + " enrolled in " + courseIDField.getText() + "\n");
				}
				else {
					outputTextArea.append("False\n");
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
					outputTextArea.append(studentIDField.getText() + " dropped out of " + courseIDField.getText() + "\n");
				}
				else {
					outputTextArea.append("False\n");
				}
			}
		}		
		dropButton.addActionListener(new ClickListener());

	}
	
	/* new: Output Area */
	
	public void createOutputArea() {
		outputTextArea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);	
		scrollPane = new JScrollPane(outputTextArea);	
		outputTextArea.setLineWrap(true);
		outputTextArea.setWrapStyleWord(true);
	}
	
	/* new: File Menu */
	
	public JMenu createFileMenu() {
		JMenu file = new JMenu("File");
		file.add(createFileShowStuItem());
		file.add(createFileShowCourseItem());
		file.add(createFileExitItem());
		return file;
	}
	
	public JMenuItem createFileShowStuItem() {
		JMenuItem show = new JMenuItem("Show students");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				outputTextArea.append(register.getStudentList().toString() + "\n");
			}
		}
		ActionListener listener = new MenuItemListener();
		show.addActionListener(listener);		
		return show;
	}
	
	public JMenuItem createFileShowCourseItem() {
		JMenuItem show = new JMenuItem("Show courses");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				outputTextArea.append(register.getCourseList().toString() + "\n");
			}
		}
		ActionListener listener = new MenuItemListener();
		show.addActionListener(listener);		
		return show;
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
	
	/* new: Manage Menu */

	public JMenu createManageMenu() {
		JMenu manage = new JMenu("Manage");
		manage.add(createMngStuItem());
		manage.add(createMngCourseItem());
		return manage;
	}
	
	public JMenuItem createMngStuItem() {
		JMenuItem manage = new JMenuItem("Student");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				StudentFrame stuFrame = new StudentFrame();
				stuFrame.setTitle("Manage Students");
				stuFrame.setLocation(FRAME_WIDTH, 0);							
			}
		}
		ActionListener listener = new MenuItemListener();
		manage.addActionListener(listener);		
		return manage;
	}
	
	public JMenuItem createMngCourseItem() {
		JMenuItem manage = new JMenuItem("Course");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				CourseFrame courseFrame = new CourseFrame();
				courseFrame.setTitle("Manage Courses");
				courseFrame.setLocation(FRAME_WIDTH, 0);							
			}
		}
		ActionListener listener = new MenuItemListener();
		manage.addActionListener(listener);		
		return manage;
	}
	
	/* new: Menu Bar */
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createManageMenu());	
		
	}
	
	// modified
	
	public void createPanel() {
		panel = new JPanel();
		JPanel panel1 = new JPanel();				// modified
		panel1.setLayout(new GridLayout(3,1));		// modified
		
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
		
		panel1.add(stuPanel);
		panel1.add(courPanel);
		panel1.add(btnPanel);
		
		/* new */
		
		createOutputArea();
		panel.add(panel1);
		panel.add(scrollPane);

	}


	
}
