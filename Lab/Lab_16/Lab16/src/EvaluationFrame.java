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



public class EvaluationFrame extends JFrame {

	// Constant Variable
	private static final int FRAME_WIDTH = 550;
	private static final int FRAME_HEIGHT = 280;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_WIDTH = 20;
	private static final int AREA_HEIGHT = 5;
	
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
	
	// Constructor
	public EvaluationFrame(){
		 createPanel();
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}
	
	// Instance Method
	public JPanel createClass() {
		mon56Btn = new JRadioButton("Mon56");
		tue23Btn = new JRadioButton("Tue23");		
		ButtonGroup group = new ButtonGroup();
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
	
	
	public void createSubmitBtn() {
		submitBtn = new JButton("Submit");
	}
	
	public void createPanel() {
		JPanel mainPanel = new JPanel();
		JPanel submitPanel = new JPanel();
		JPanel class_team_panel = new JPanel();
		
		class_team_panel.add(createClass());
		class_team_panel.add(createTeam());
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(class_team_panel);
		mainPanel.add(createEvaluation());
		createSubmitBtn();
		submitPanel.add(submitBtn);
		
		add(mainPanel, BorderLayout.CENTER);
		add(submitPanel, BorderLayout.SOUTH);
		
	}

	
}
