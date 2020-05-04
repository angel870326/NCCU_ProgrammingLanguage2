import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;         // new
import java.awt.event.ActionListener;      // new


/* Lab 16 */

public class EvaluationFrame extends JFrame {

	// Constant Variable
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_WIDTH = 20;
	private static final int AREA_HEIGHT = 5;
	private static final int RE_HEIGHT = 10;      // new
	private static final int RE_WIDTH = 20;       // new
	
	// Instance Variable
	private JRadioButton mon56Btn;
	private JRadioButton tue23Btn;
	private JLabel myIDLabel;
	private JLabel mateIDLabel;
	private JLabel scoreLabel;
	private JLabel feedbackLabel;
	private JTextField myIDTextField; 
	private JTextField mateIDTextField;
	private JComboBox<String> scoreCombo;
	private JTextArea feedbackTextArea; 
	private JButton submitBtn;
	private ButtonGroup group; 				// new
	private JTextArea resultTextArea; 		// new
	private JButton resetBtn; 				// new
	
	// Constructor
	public EvaluationFrame(){
		 createPanel();
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}
	
	// Instance Method
	
	// modified
	public JPanel createClass() {
		mon56Btn = new JRadioButton("Mon56");
		tue23Btn = new JRadioButton("Tue23");
		group = new ButtonGroup();
		group.add(mon56Btn);
		group.add(tue23Btn);
		
		JPanel panel = new JPanel();
		panel.add(mon56Btn);
		panel.add(tue23Btn);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Class"));
		return panel;		
	}
		
		
	public JPanel createTeam() {
		myIDLabel = new JLabel("My Stu. ID");
		mateIDLabel = new JLabel("Teammate's Stu. ID");
		myIDTextField = new JTextField(FIELD_WIDTH);
		mateIDTextField = new JTextField(FIELD_WIDTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(myIDLabel);
		panel.add(myIDTextField);
		panel.add(mateIDLabel);
		panel.add(mateIDTextField);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Team Info."));
		return panel;				
	}
		
		
	public JPanel createEvaluation() {
		scoreLabel = new JLabel("Score");
		feedbackLabel= new JLabel("Feedback");
		scoreCombo = new JComboBox();
		feedbackTextArea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);
		
		scoreCombo.addItem("0");
		scoreCombo.addItem("1");
		scoreCombo.addItem("2");
		scoreCombo.addItem("3");
		scoreCombo.addItem("4");
		scoreCombo.addItem("5");
		
		JPanel panel = new JPanel();
		panel.add(scoreLabel);
		panel.add(scoreCombo);
		panel.add(feedbackLabel);
		panel.add(feedbackTextArea);
		return panel;
	}
		
	
	// new	
	public JPanel createResult() {
		resultTextArea = new JTextArea(RE_HEIGHT,RE_WIDTH);
		resultTextArea.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(resultTextArea);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Result"));
		return panel;	
	}
	

	// modified	
	public void createSubmitBtn() {
		submitBtn = new JButton("Submit");
		class SubmitActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(mon56Btn.isSelected()) {
					resultTextArea.append(String.format("Class: %s\nMy ID: %s\nTeammate's ID: %s\nScore: %s\nFeedback: \n%s\n", mon56Btn.getText(), myIDTextField.getText(), mateIDTextField.getText(), scoreCombo.getSelectedItem(), feedbackTextArea.getText()));
				}
				else if(tue23Btn.isSelected()){
					resultTextArea.append(String.format("Class: %s\nMy ID: %s\nTeammate's ID: %s\nScore: %s\nFeedback: \n%s\n", tue23Btn.getText(), myIDTextField.getText(), mateIDTextField.getText(), scoreCombo.getSelectedItem(), feedbackTextArea.getText()));
				}
			}			
		}
		ActionListener listener = new SubmitActionListener();
		submitBtn.addActionListener(listener);
	}
	
	
	// new
	public void createResetBtn() {
		resetBtn = new JButton("Reset");
		class ResetActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				group.clearSelection();
				//
				myIDTextField.setText(null);
				mateIDTextField.setText(null);
				scoreCombo.setSelectedIndex(0);
				feedbackTextArea.setText(null);
			}
		}
		ActionListener listener = new ResetActionListener();
		resetBtn.addActionListener(listener);
	}
	
	
	// modified	
	public void createPanel() {
		JPanel mainPanel = new JPanel();
		JPanel southPanel = new JPanel();         // modified
		JPanel class_team_panel = new JPanel();
		JPanel centPanel = new JPanel();          // new
				
		class_team_panel.add(createClass());
		class_team_panel.add(createTeam());
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(class_team_panel);
		mainPanel.add(createEvaluation());
		
		centPanel.add(mainPanel, BorderLayout.CENTER);     // modified
		
		createSubmitBtn();
		createResetBtn();
		southPanel.add(submitBtn);
		southPanel.add(resetBtn);
		
		// new	
		add(centPanel, BorderLayout.CENTER);
		add(createResult(), BorderLayout.EAST);
		add(createResult(), BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);        // modified

		
	}

	
}
