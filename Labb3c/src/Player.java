/** Objects of this class represents 
 *	a player of blackjack
 *	a player have a hand of cards and a set of points
 */

public class Player {
	
	private int points;
	private Hand playerHand;
	private int totalValue = 0;
	private int aces = 0;
	private boolean bust = false;
	
	/** the constructor creates a new hand ans sets the points to 0
	 */
	public Player(){
		newHand();
		points = 0;
	}
	/** Adds a point to the player
	 */
	public void addPoint(){
		points++;
	}
	
	/** returns the amount of points the player have
	 */
	public int getPoints(){
		return points;
	}
	
	/** Stores if the player have busted
	 */
	public void bust(){
		bust = true;
	}
	/** Returns if the player have busted or not
	 */
	public boolean bustStatus(){
		return bust;
	}
	/** Gives the player a new hand of cards
	 */	
	public void newHand(){
		playerHand = new Hand();
		aces = 0;
		bust = false;
	}
	
	/**Adds a card to the hand
	 */
	public void addCardToHand(Card newCard){
		playerHand.addCard(newCard);
		if(newCard.getRank() == Rank.Ace)
			aces++;
	}
	/** returns the amount of cards in the hand
	 */
	public int cardsInHand(){
		return playerHand.getNoOfCards();
	}
	/** Returns the total value of the cards in the hand
	 */
	public int getTotalValue(){		
		totalValue = 0;
		for(int i = 1;i <= this.cardsInHand();i++){
			if(playerHand.getCard(i).getRank() != Rank.Ace){
				if(playerHand.getCard(i).getRank().getCode() > Rank.Ten.getCode()){
					totalValue += 10;
				}
				else{
					totalValue += playerHand.getCard(i).getRank().getCode(); 
				}
			}	
		}
		
		for(int i = 0; i < aces; i++){
			if(totalValue+11>21)
				totalValue+=1;
			else
				totalValue+=11;
		}
		return totalValue;
	}
	
	public String toString(){
		return playerHand.toString();
	}
	
}
