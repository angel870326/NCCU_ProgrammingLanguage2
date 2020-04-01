// 2
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyTimer {
	
	// 3
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 60;
	
	private static int timeCount = 0;
	private static Timer timer;
	

	public static void main(String[] args) {
		
		// 4
		class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				timeCount += 5;
				System.out.println(timeCount);
			}		
		}
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				System.out.println("Timer started!");
				timer.start();			
			}		
		}
		
		// 5
		JFrame frame = new JFrame();
		
		// 6
		JButton button = new JButton("Start Timer");
		
		// 7
		frame.add(button);
		
		// 8
		ActionListener timerListener = new TimerListener(); 
		timer = new Timer(5000, timerListener);
		
		// 9
		ActionListener clickListener = new ClickListener(); 
		button.addActionListener(clickListener);
		
		// 10
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// 11
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 12
		frame.setVisible(true);

	}

}
