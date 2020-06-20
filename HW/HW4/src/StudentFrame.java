import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.SQLException;



public class StudentFrame extends JFrame{
	// Constant Variable
	private static final int FRAME_WIDTH = 360;
	private static final int FRAME_HEIGHT = 160;
	private static final int FIELD_WIDTH = 10;
	
	// Instance Variable
	private JRadioButton addButton;
	private JRadioButton deleteButton;
	private JLabel studentIDLabel;
	private JLabel studentNameLabel;
	private JTextField studentIDField;
	private JTextField studentNameField;
	private JButton submitButton;
	private JButton resetButton;

	// Constructor
	public StudentFrame() {
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
		studentIDField.setEditable(true);
		studentNameField.setEditable(true);
	}
	
	public void disableFields() {
		studentIDField.setEditable(true);
		studentNameField.setEditable(false);
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
	
	public JPanel createStudentInfo() {
		studentIDLabel = new JLabel("Student ID: ");
		studentNameLabel = new JLabel("Student Name: ");
		studentIDField = new JTextField(FIELD_WIDTH);
		studentNameField = new JTextField(FIELD_WIDTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(studentIDLabel);
		panel.add(studentIDField);
		panel.add(studentNameLabel);
		panel.add(studentNameField);
		return panel;		
	}
	
	public void createSubmitBtn() {
		submitButton = new JButton("Submit");
		class SubmitActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				try {
					if(addButton.isSelected()) {
						getRegisterFromRegisterFrame().addStudent(studentIDField.getText(), studentNameField.getText());
					}
					else if(deleteButton.isSelected()){
						getRegisterFromRegisterFrame().removeStudent(studentIDField.getText());	
					}
				}
				catch(SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
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
				studentIDField.setText(null);
				studentNameField.setText(null);
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
		add(createStudentInfo(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);		
	}

	
}
