import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/**
 * BouncePanel represents a canvas (drawing area) for objects of type Shape. A
 * timer-object periodically updates the canvas, in the actionPerformed method, 
 * by moving and repainting the objects.
 */

public class BouncePanel extends JPanel implements ActionListener {

	private int width = 500, height = 530;
	private Timer timer;
	private Color color;
	private Rectangle boundingBox;
	private Scanner scan = new Scanner(System.in);
	int x,y;
	

	private ArrayList<Shape> Shapes = new ArrayList<Shape>();
	
	Shape test;
	
	public BouncePanel() {
		// Set the the dimensions of the drawing area
		setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.lightGray);
		boundingBox = new Rectangle(width, height);
		
		// Create the timer-object, responsible for the animation
		createShapes();
		timer = new Timer(30, this);
		timer.start();
	}
	
	/**
	 * H�r g�r vi en loop d�r vi fr�gar anv�ndaren vilken shape han/hon vill rita och f�r �ven best�mma m�tten samt hastighet.
	 */
	public void createShapes(){
		int choise =0;
		FillableShape temp;
		color = Color.red;
		boolean running = true;
		int i=0;
		int x,y,x2,y2;
		int dx,dy;
		int length,width,radius;

		while(running){
			System.out.println("What shape do you want to create: ");
			System.out.println("1. Line");
			System.out.println("2. Rectangle");
			System.out.println("3. Circle");
			choise = scan.nextInt();

			switch(choise){			
			case 1:
				System.out.print("Enter x y x2 y2: ");
				x = scan.nextInt();
				y = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				// L�gger till en linje i ArrayListen
				Shapes.add(new Line(x,y,x2,y2,color));
				break;
			case 2:
				System.out.print("Enter x y length width: ");
				x = scan.nextInt();
				y = scan.nextInt();
				 length= scan.nextInt();
				 width = scan.nextInt();
				 // L�gger till en rektangel i ArrayListen
				Shapes.add(new Rect(x,y,length,width,color));
				break;
			case 3:
				System.out.print("Enter x y radius: ");
				x = scan.nextInt();
				y = scan.nextInt();
				radius = scan.nextInt();
				// L�gger till en cirkel i ArrayListen
				Shapes.add(new Circle(x,y,radius,color));
				break;
			case 4:
				running = false;
			default:
				break;
			}
			if(!running)
				break;

			// Kollar om shape inneh�ller fillableshape. Om Shapes �r en instans av FillebaleShape eller subclass 
			if(Shapes.get(i) instanceof FillableShape){
				System.out.print("Do you want you Shape Filled (1/0): ");
				choise = scan.nextInt();
				// Om du v�ljer att fylla din shape, skapas en tempor�r Shape av typen Filleable FillableShape och tar tempor�rt bort den och g�r den till fillable och l�gger sedan in den i ArrayListen igen. 
				if(choise == 1){
					temp = (FillableShape)Shapes.remove(i);
					temp.setFilled(true);
					Shapes.add(temp);
				}
			}
			
			// S�tter en begr�nsad box f�r formerna
			Shapes.get(i).setBoundingBox(boundingBox);
			
			// Anv�ndaren f�r v�lja hastighet f�r de olika formerna.
			System.out.print("Enter dx dy: ");
			dx = scan.nextInt();
			dy = scan.nextInt();
			Shapes.get(i).setDX(dx);
			Shapes.get(i).setDY(dy);
			i++;
		}
	}

	/**
	 * Ritar ut alla former p� sk�rmen. Called by repaint().
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Kollar igenom hela Shape ArrayList:en och h�mtar den p� positionen i och ritar ut den p� sk�rmen med paint
		for (int i = 0; i < Shapes.size(); i++) {
			Shapes.get(i).paint(g);	
		}
	}
	
	/**
	 * Update the position of the ball and repaint. This method is executed by
	 * the timer-object.
	 */
	public void actionPerformed(ActionEvent event) {

		// Kollar igenom hela Shapes ArrayList:en och f�r alla former att r�ra p� sig med metoden move()
		for (int i = 0; i < Shapes.size(); i++) {
			Shapes.get(i).move();
		}
		
		repaint(); // Calls paintComponent(g)
	}

	private static final long serialVersionUID = 1L;
}