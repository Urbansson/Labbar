import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Line extends Shape{
	private double x2, y2;
	
	public Line(double x, double y, double x2, double y2, Color color )
	{
		super(x, y, color);
		this.x2 = x2; 
		this.y2 = y2;
	}
	
	public double getX2(){
		return x2;
	}
	
	public double getY2(){
		return y2;
	}
	
	public void paint(Graphics g) {	
		g.setColor(super.getColor());
		g.drawLine((int)super.getX(), (int)super.getY(), (int)(super.getX()+x2), (int)(super.getY()+y2));
	}

	protected void constrain(){
		Rectangle box = super.getBoundingBox();
		
		double x0 = box.x, y0 = box.y;
		double x1 = x0 + box.width;
		double y1 = y0 + box.height;

		// If outside box, change direction
		if(super.getX() < x0) super.setDX(Math.abs(super.getDX()));
		if(super.getX()+x2 > x1) super.setDX(-Math.abs(super.getDX()));
		if(super.getY() < y0) super.setDY(Math.abs(super.getDY()));
		if(super.getY()+y2 > y1) super.setDY(-Math.abs(super.getDY()));
	} 
}
