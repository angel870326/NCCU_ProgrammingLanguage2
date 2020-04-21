import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField;


public class GUICalculator {
	
	private static final int FRAME_WIDTH = 480;
	private static final int FRAME_HEIGHT = 100;
	private static final int FIELD_WIDTH = 10;

	// This method can handle the four types of calculation: +, -, *, and /.
	private static int doCalculate(int num1, int num2, String operator) {
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


	public static void main(String[] args) {

		// A
		JFrame frame = new JFrame("Calculator");
		
		// B
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton multiply = new JButton("x");
		JButton divide = new JButton("/");
		
		// C
		JTextField firstNum = new JTextField(FIELD_WIDTH);
		JTextField secondNum = new JTextField(FIELD_WIDTH);
		
		// D
		JLabel first = new JLabel("First Number");
		JLabel second = new JLabel("Second Number");
		JLabel result = new JLabel("Result: ");

		// inner class
		class plusActionListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				int num1 = Integer.parseInt(firstNum.getText());
				int num2 = Integer.parseInt(secondNum.getText());
				
				int calculate = doCalculate(num1, num2, "+");
				result.setText("Result: " + calculate);
			}
		}
		class minusActionListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				int num1 = Integer.parseInt(firstNum.getText());
				int num2 = Integer.parseInt(secondNum.getText());
				
				int calculate = doCalculate(num1, num2, "-");
				result.setText("Result: " + calculate);
			}
		}
		class multiplyActionListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				int num1 = Integer.parseInt(firstNum.getText());
				int num2 = Integer.parseInt(secondNum.getText());
				
				int calculate = doCalculate(num1, num2, "*");
				result.setText("Result: " + calculate);
			}
		}
		class divideActionListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				int num1 = Integer.parseInt(firstNum.getText());
				int num2 = Integer.parseInt(secondNum.getText());
				
				int calculate = doCalculate(num1, num2, "/");
				result.setText("Result: " + calculate);
			}
		}
		
		// G
		plus.addActionListener(new plusActionListener());
		minus.addActionListener(new minusActionListener());
		multiply.addActionListener(new multiplyActionListener());
		divide.addActionListener(new divideActionListener());

		// H
		JPanel panel = new JPanel();
		
		// I
		panel.add(first);
		panel.add(firstNum);
		panel.add(second);
		panel.add(secondNum);
		panel.add(plus);
		panel.add(minus);
		panel.add(multiply);
		panel.add(divide);
		panel.add(result);
		
		// J
		frame.add(panel);
		
		// K、L、M
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
