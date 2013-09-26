import java.awt.Color;
import java.awt.Graphics;


public class Rect extends FillableShape
{
	private double width, height;
	
	public Rect(double x, double y, double height, double width, Color color)
	{
		super(x, y, color);
		this.height = height;
		this.width = width;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}

	@Override
	public void paint(Graphics g) 
	{
		// TODO Auto-generated method stub
		if(super.getFilled())
		{
			g.fillRect((int) super.getX(), (int) super.getY(),(int) width, (int) height);
		}
		g.drawRect((int) super.getX(), (int) super.getY(),(int) width, (int) height);
	}
	
}
