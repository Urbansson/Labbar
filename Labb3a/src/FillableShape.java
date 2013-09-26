import java.awt.Color;


public abstract class FillableShape extends Shape
{
	boolean filled;
	
	public FillableShape(double x, double y, Color color)
	{
		super(x, y, color);
	}
	
	public boolean getFilled()
	{
		return filled;
	}
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}

}
