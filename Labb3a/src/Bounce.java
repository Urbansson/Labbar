import javax.swing.*;
			
public class Bounce {
	public static void main(String[] args) {
		
		// Create a window (frame)
		JFrame frame = new JFrame("Bounce with Shapes");
		
		// Create a canvas (BouncePanel) and add it to the window
		BouncePanel panel = new BouncePanel();
		frame.getContentPane().add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}
}