/** Objects of this class represents 
 *	a deck (of cards).
 *	you can get the amounts of cards in the deck 
 *	But you can only deal the cord on the top
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	
	private ArrayList<Card> Cards = new ArrayList<Card>();
	private int numberOfCards;
	
	/** The constructor fills the deck with 52 cards
	 */
	public Deck(){
		fill();
	}
	
	/** Returns the number of cards in the deck
	 */
	public int getNoOfCars(){
		return numberOfCards;
	}
	
	/** Deals out the card on top in the deck
	 */
	public Card dealCard(){
		Card cardToBeDealed;
		cardToBeDealed = Cards.remove(0);
		numberOfCards--;
		return cardToBeDealed;
	}
	
	/** Shuffles the deck
	 */
	public void shuffleCards(){
		Collections.shuffle(Cards);
	}
	/** Fills the deck with 52 new cards
	 */
	public void fill(){
		Cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
            	Cards.add(new Card(rank, suit));
            	numberOfCards++;
            }
        }
	}
	
	public String toString(){
		String tempString = "";
		Card tempCard;
		for(int i = 0; i < Cards.size(); i++){
			tempCard = Cards.get(i);
			tempString += tempCard.toString() + "\n";
		}	
		return tempString;
	}
}
