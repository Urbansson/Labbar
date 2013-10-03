import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class Shape {

	private double x, y; 
	private double dx, dy; 
	private Color color;
	private Rectangle box; 

	protected Shape(double x, double y, Color color) {
		this.x = x; this.y = y;
		this.color = color;
	}

	
	public double getX(){ 
		// Returnera position x
		return x;
	}

	
	public double getY(){ 
		// returnera poistion y
		return y; 
	}

	
	public double getDX(){ 
		// Returnera hastighet i X-led
		return dx; 
	}

	
	public double getDY() { 
		// Returnerar hastighet i y-led
		return dy;
	}

	
	public void setDX(double dx){ 
		// sätter hastigheten till dx i x-led
		this.dx = dx;
	}

	
	public void setDY(double dy) { 
		// sätter hastigheten till dy i y-led
		this.dy = dy; 
	}

	
	public Color getColor() {
		// Returnerar färgen
		return color; 
	}

	
	public Rectangle getBoundingBox(){
		// Returnerar rektangeln box
		return box; 
	}

	
	public void setBoundingBox(Rectangle box){
		// Sätter värden till rektangeln box
		this.box = box;
	} 

	
	public void setVelocity(double dx, double dy){
		// Sätter hastigheten med dx och dy, hastigheterna i y och x-led
		this.dx = dx; this.dy = dy;
	}

	/** 
	 * Rör på formen innanför constrainen, med hastigheten (dx, dy)
	 */
	public void move(){
		x += dx;
		y += dy;
		constrain(); 
	}

	/**
	 * Hållen formen innanför en begränsade rutan
	 *  Vi overridar metoden i våra subklasser
	 */
	protected void constrain(){

		double x0 = box.x, y0 = box.y;
		double x1 = x0 + box.width;
		double y1 = y0 + box.height;

		// If outside box, change direction
		if(x < x0) dx = Math.abs(dx);
		if(x > x1) dx = -Math.abs(dx);
		if(y < y0) dy = Math.abs(dy);
		if(y > y1) dy = -Math.abs(dy);
	} 

	/** Paint this shape (abstract method)
	 */
	abstract public void paint(Graphics g);
}