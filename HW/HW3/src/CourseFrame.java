import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;



public class CourseFrame extends JFrame{
	
	// Constant Variable
	private static final int FRAME_WIDTH = 360;
	private static final int FRAME_HEIGHT = 160;
	private static final int FIELD_WIDTH = 10;

	// Instance Variable
	private JRadioButton addButton;
	private JRadioButton deleteButton;
	private JLabel courseIDLabel;
	private JLabel courseNameLabel;
	private JLabel courseCreditsLabel;
	private JTextField courseIDField;
	private JTextField courseNameField;
	private JTextField courseCreditsField;
	private JButton submitButton;
	private JButton resetButton;

	// Constructor
	public CourseFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);		
		createPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);     
	}
	
	// Method	
	private Register getRegisterFromRegisterFrame() {
		for(Frame frame: JFrame.getFrames()) { 
			if(frame.getTitle().equals("Course Register")) {
				RegisterFrame registerFrame = (RegisterFrame) frame; 
				return registerFrame.getRegister();
			}
		}
		return null;
	 }
	
	
	
	
	/* GUI */
	
	public void enableFields() {
		courseIDField.setEditable(true);
		courseNameField.setEditable(true);
		courseCreditsField.setEditable(true);
	}
	
	public void disableFields() {
		courseIDField.setEditable(true);
		courseNameField.setEditable(false);
		courseCreditsField.setEditable(false);
	}
	
	public void createAddButton() {
		addButton = new JRadioButton("Add");
		class AddListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(addButton.isSelected()) {
					enableFields();
				}
			}			
		}
		ActionListener listener = new AddListener();
		addButton.addActionListener(listener);
	}
	
	public void createDeleteButton() {
		deleteButton = new JRadioButton("Delete");		
		class DeleteListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(deleteButton.isSelected()){
					disableFields();
				}
			}			
		}
		ActionListener listener = new DeleteListener();
		deleteButton.addActionListener(listener);
	}
	
	public JPanel createAddDeletePanel() {
		createAddButton();
		createDeleteButton();
		ButtonGroup group = new ButtonGroup();
		group.add(addButton);
		group.add(deleteButton);
		addButton.setSelected(true);
		
		JPanel panel = new JPanel();
		panel.add(addButton);
		panel.add(deleteButton);
		return panel;		
	}
	
	public JPanel createCourseInfo() {
		courseIDLabel = new JLabel("Course ID: ");
		courseNameLabel = new JLabel("Course Name: ");
		courseCreditsLabel = new JLabel("Course Credits: ");	
		courseIDField = new JTextField(FIELD_WIDTH);
		courseNameField = new JTextField(FIELD_WIDTH);
		courseCreditsField = new JTextField(FIELD_WIDTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.add(courseIDLabel);
		panel.add(courseIDField);
		panel.add(courseNameLabel);
		panel.add(courseNameField);
		panel.add(courseCreditsLabel);
		panel.add(courseCreditsField);
		return panel;		
	}
	
	public void createSubmitBtn() {
		submitButton = new JButton("Submit");
		class SubmitActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(addButton.isSelected()) {
					getRegisterFromRegisterFrame().addCourse(courseIDField.getText(), courseNameField.getText(), Integer.parseInt(courseCreditsField.getText()));
				}
				else if(deleteButton.isSelected()){
					getRegisterFromRegisterFrame().removeCourse(courseIDField.getText());	
				}
			}			
		}
		ActionListener listener = new SubmitActionListener();
		submitButton.addActionListener(listener);
	}
	
	public void createResetBtn() {
		resetButton = new JButton("Reset");
		class ResetActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				courseIDField.setText(null);
				courseNameField.setText(null);
				courseCreditsField.setText(null);
			}
		}
		ActionListener listener = new ResetActionListener();
		resetButton.addActionListener(listener);
	}
	
	public JPanel createButtonPanel() {
		createSubmitBtn();
		createResetBtn();
		JPanel panel = new JPanel();
		panel.add(submitButton);
		panel.add(resetButton);
		return panel;
	}
	
	public void createPanel() {
		add(createAddDeletePanel(), BorderLayout.NORTH);
		add(createCourseInfo(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);		
	}
	

}
