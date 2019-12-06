
import java.awt.EventQueue;

import javax.swing.JFrame;



public class ZadanieDwaMain {
	public static void main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ButtonDwaZadanie();
				
				frame.setTitle("ButtonZadanieDwa");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
