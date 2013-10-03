/** Objects of this class represents one Author
 * with a Name
 */


import java.io.Serializable;

public class Author implements Serializable  {

	final private String name;
	
	/** To create a Author you need to enter a Name
	 */

	public Author(String name){
		this.name = name;	
	}
	
	/** Returns The author name
	 */

	public String getName(){
		return name;
	}
	
    private static final long serialVersionUID = 1L;

}
