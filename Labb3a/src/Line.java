import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private double x2, y2;
	
	public Line(double x, double y, double x2, double y2, Color color )
	{
		super(x, y, color);
		this.x2 = x2; 
		this.y2 = y2;
	}
	
	public double getX2() {
		return x2;
	}
	
	public double getY2() {
		return y2;
	}
	
	public void paint(Graphics g)
	{	
		g.setColor(super.getColor());
		g.drawLine((int)super.getX(), (int)super.getY(), (int)x2, (int)y2);
	}

}
