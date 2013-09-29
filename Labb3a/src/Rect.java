import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Rect extends FillableShape
{
	private double width, height;
	
	public Rect(double x, double y, double height, double width, Color color){
		super(x, y, color);
		this.height = height;
		this.width = width;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		if(super.getFilled()){
			g.fillRect((int) super.getX(), (int) super.getY(),(int) width, (int) height);
		}
		g.drawRect((int) super.getX(), (int) super.getY(),(int) width, (int) height);
	}

	
	protected void constrain(){
		Rectangle box = super.getBoundingBox();
		
		double x0 = box.x, y0 = box.y;
		double x1 = x0 + box.width;
		double y1 = y0 + box.height;

		// If outside box, change direction
		if(super.getX() < x0) super.setDX(Math.abs(super.getDX()));
		if(super.getX()+width > x1) super.setDX(-Math.abs(super.getDX()));
		if(super.getY() < y0) super.setDY(Math.abs(super.getDY()));
		if(super.getY()+height > y1) super.setDY(-Math.abs(super.getDY()));
	} 
}
