import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * BouncePanel represents a canvas (drawing area) for objects of type Shape. A
 * timer-object periodically updates the canvas, in the actionPerformed method, 
 * by moving and repainting the objects.
 */

public class BouncePanel extends JPanel implements ActionListener {

	private int width = 500, height = 530;
	private Timer timer;

	private Shape[] theShapes ; 
	Rectangle r;
	
	public BouncePanel() {

		// Create and initialize objects of (sub types of) Shape
		r = new Rectangle(0, 0, width, height);
		// Set the the dimensions of the drawing area
		setPreferredSize(new Dimension(width, height));
		
		// Create the timer-object, responsible for the animation
		timer = new Timer(20, this);
		timer.start();
	}

	/**
	 * Define what to draw. Called by repaint().
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw all shape objects
		// ..
	}

	/**
	 * Update the position of the ball and repaint. This method is executed by
	 * the timer-object.
	 */
	public void actionPerformed(ActionEvent event) {
		
		// Move all shape objects
		// ...
		
		repaint(); // Calls paintComponent(g)
	}

	private static final long serialVersionUID = 1L;
}