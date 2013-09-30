import java.io.Serializable;

public class Author implements Serializable  {

	final private String name;
	
	public Author(String name){
		this.name = name;	
	}
	
	public String getName(){
		return name;
	}
	
    private static final long serialVersionUID = 1L;

}
