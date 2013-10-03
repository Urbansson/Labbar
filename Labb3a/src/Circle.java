import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Circle extends FillableShape
{
	private double diameter;
	
	public Circle(double x, double y, double diameter, Color color){
		//superklassens konstruktor med matchande parametrar kallas
		super(x, y, color);
		this.diameter = diameter;
	}
	
	public double getDiameter(){
		return diameter;
	}

	/**
	 * Overridar paint metoden d�r vi kollar om vi valt att fylla cirkeln, d� fyller vi den.
	 * H�r s�ger vi hur vi vill rita cirkeln/ovalen som vi sedan f�r rita ut i Bounce panel
	 */
	@Override
	public void paint(Graphics g){
		
		g.setColor(super.getColor());
		if(super.getFilled()){
			g.fillOval((int)super.getX(),(int) super.getY(), (int)diameter, (int)diameter);
		}
	    g.drawOval((int)super.getX(),(int) super.getY(), (int)diameter, (int)diameter);
		
	}
	
	/**
	 * Override constrain
	 *  Den h�r metoden beh�ller cirkeln i spelboxen
	 *  Den kommer att studsa p� v�ggarna i motsatt riktning
	 */
	protected void constrain(){
		Rectangle box = super.getBoundingBox();
		
		double x0 = box.x, y0 = box.y;
		double x1 = x0 + box.width;
		double y1 = y0 + box.height;

		// If outside box, change direction
		if(super.getX() < x0) super.setDX(Math.abs(super.getDX()));
		if(super.getX()+diameter > x1) super.setDX(-Math.abs(super.getDX()));
		if(super.getY() < y0) super.setDY(Math.abs(super.getDY()));
		if(super.getY()+diameter > y1) super.setDY(-Math.abs(super.getDY()));
	} 
	
}
