/** Objects of this class represents 
 *	a AI player of the game 
 *	it draws cards until it reaches 17
 *	it is a extension of the player object
 */

public class Computer extends Player {

	public Computer(){
		super();
	}
	
	public boolean makeChoise(){

		if(super.getTotalValue()<17){
			return true;
		}
		else{
			return false; 
		}
		
	}
	
}
