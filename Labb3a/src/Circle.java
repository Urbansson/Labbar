import java.awt.Color;
import java.awt.Graphics;


public class Circle extends FillableShape
{
	private double diameter;
	
	public Circle(double x, double y, double diameter, Color color)
	{
		super(x, y, color);
		this.diameter = diameter;
	}
	
	public double getDiameter()
	{
		return diameter;
	}

	@Override
	public void paint(Graphics g) {
		
		if(super.getFilled())
		{
			g.fillOval((int)super.getX(),(int) super.getY(), (int)diameter, (int)diameter);
		}
	    g.drawOval((int)super.getX(),(int) super.getY(), (int)diameter, (int)diameter);
		
	}
	
}
