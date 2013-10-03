import java.awt.Color;


public abstract class FillableShape extends Shape
{
	boolean filled;
	
	public FillableShape(double x, double y, Color color){
		//superklassens konstruktor med matchande parametrar kallas, som finns i Shape
		super(x, y, color);
	}
	
	public boolean getFilled(){
		return filled;
	}
	
	// Vi sätter att den är filled med en boolean, om den är true kommer den va filled om den är false kommer den inte va filled
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	

}
