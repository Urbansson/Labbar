import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> Cards;
	private int numberOfCards = 0;
	
	public Hand(){	
		Cards = new ArrayList<Card>();
	}
	
	public int getNoOfCards(){
		return numberOfCards;
	}

	public void addCard(Card newCard){
		Cards.add(newCard);
		numberOfCards++;
	}
	
	public Card getCard(int i){
		if(i <= numberOfCards && i != 0)
			return Cards.get(i-1);
		else
			return null;
	}
	
	public Card removeCard(int i){
		if(i <= numberOfCards && i != 0){
			numberOfCards--;
			return Cards.remove(i-1);
		}
		else
			return null;
	}	
	
	public void clearHand(){
		Cards.clear();
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