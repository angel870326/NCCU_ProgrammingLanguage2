import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JPanel; 



public class Calculator extends JFrame{
	
	private static final int FRAME_WIDTH = 480;
	private static final int FRAME_HEIGHT = 100;
	private static final int FIELD_WIDTH = 10;

	private JLabel firstNumLabel;
	private JLabel secondNumLabel;
	private JLabel resultNumLabel;
	private JTextField firstNumField;
	private JTextField secondNumField;

	public Calculator() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		createPanel();
	}

	public JButton createOperatorButton(final String operator) {
		JButton button = new JButton(operator);
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {			
				try { 
					int num1 = Integer.parseInt(firstNumField.getText());
					int num2 = Integer.parseInt(secondNumField.getText());
					
					int result = doCalculate(num1, num2, operator);
					
					resultNumLabel.setText("Result: " + result);
				} 
				catch (NumberFormatException e) { 
					resultNumLabel.setText("please input integer");
		        } 
				catch (ArithmeticException e) { 
					resultNumLabel.setText("can't divide by 0");
		        } 			
			}			
		}
		ActionListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;

	}
	
	public int doCalculate(int num1, int num2, String operator) throws NumberFormatException, ArithmeticException{
		int result;
		if (operator.equals("+")) {
			result = num1 + num2;
		}
		else if (operator.equals("-")) {
			result = num1 - num2;
		}
		else if (operator.equals("*")) {
			result = num1 * num2;
		}
		else {
			result = num1 / num2;
		}
		return result;
	}

	public void createPanel(){
		
		JPanel panel = new JPanel();
		
		JButton plus = createOperatorButton("+");
		JButton minus = createOperatorButton("-");
		JButton multiply = createOperatorButton("*");
		JButton divide = createOperatorButton("/");
		
		firstNumField = new JTextField(FIELD_WIDTH);
		secondNumField = new JTextField(FIELD_WIDTH);
		
		firstNumLabel = new JLabel("First Number");
		secondNumLabel = new JLabel("Second Number");
		resultNumLabel = new JLabel("Result: ");
		
		panel.add(firstNumLabel);
		panel.add(firstNumField);
		panel.add(secondNumLabel);
		panel.add(secondNumField);
		panel.add(plus);
		panel.add(minus);
		panel.add(multiply);
		panel.add(divide);
		panel.add(resultNumLabel);
		
		add(panel);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Calculator(); 
		frame.setTitle("GUICalculator"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);

	}

}
