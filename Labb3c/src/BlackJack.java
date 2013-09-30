/** Objects of this class represents the game Blackjack
 *	it contains Players and a deck
 *	The computer is the dealer and the humans are the players
 *	there is no real limit in the number of players
 */
import java.util.ArrayList;
import java.util.Scanner;


public class BlackJack {
	
	
	private Scanner scan = new Scanner(System.in);

	private Computer comp = new Computer();
	private Deck gameDeck = new Deck();
	private ArrayList<Human> Player = new ArrayList<Human>();
	private int numberOfPlayers;
	
	
	/** The constructor asks how many players there is and makes space for them
	 */
	public BlackJack(){
		System.out.print("How Many Players Wants to play: ");
		numberOfPlayers = scan.nextInt();
		
		for(int i = 0; i < numberOfPlayers; i++){
			Player.add(new Human());
		}
	}

	/** play is the game loop
	 */
	public void play(){

		do{
			gameDeck.shuffleCards();

			for(int i = 0; i < Player.size(); i++){
				this.dealCards(Player.get(i), 2);
				this.printCardsPlayer(i);

			}
			this.dealCards(comp, 2);
			printCardsDealer(comp);

			System.out.println("----------------------------------------------------");

			playerChoises();
			dealerChoise();

			results();
			points();
		}while(playAgain());


	}
	
	/** Asks if you wants to play another round 
	 * if not it quits the game
	 */
	private boolean playAgain(){
		System.out.println("\nPlay Again?(1/0)");
		if(scan.nextInt() == 1){
			for(int i = 0; i < Player.size(); i++){
				Player.get(i).newHand();
			}
			comp.newHand();
			gameDeck.fill();
			return true;
		}
		else
			return false;	
	}

	/** Shows the players the amoubnt of points they have
	 */
	private void points(){
		System.out.println("\nPoints");
		for(int i = 0; i < Player.size(); i++){
			System.out.println("Player " +(i+1)+" points: " + Player.get(i).getPoints());
		}

	}
	/** Prints the results from the round
	 */
	private void results(){
		System.out.println("-------------RESULTS--------------------------------");		

		for(int i = 0; i < Player.size(); i++){
			System.out.print("Player " + (i+1) +" Cards: \n" + Player.get(i).toString());
			System.out.println("Total Value: " + Player.get(i).getTotalValue()+"\n");
		}	

		System.out.print("Computers Cards: \n" + comp.toString());
		System.out.println("Total Value: " + comp.getTotalValue()+"\n");

		for(int i = 0; i < Player.size(); i++){

			if(comp.bustStatus()){
				System.out.println("Computer Bust!");
				System.out.println("You Win!");
				Player.get(i).addPoint();
			} else {
				if(Player.get(i).getTotalValue() > comp.getTotalValue() && !Player.get(i).bustStatus()){
					System.out.println("Player " +(1+i)+ " Wins!");
					Player.get(i).addPoint();
				}else if(Player.get(i).bustStatus()){
					System.out.println("Player " +(1+i)+ " BUSTS!");
				}
					
			}
		}
	}
	
	/** Checks if all the players busted otherwise
	 * it draws card until the dealer don't want anymore
	 */
	
	private void dealerChoise(){
		for(int i = 0; i < Player.size(); i++){
			if(!Player.get(i).bustStatus()){
				while(comp.makeChoise()){
					comp.addCardToHand(gameDeck.dealCard());
					printCardsDealer(comp);
					if(this.checkBust(comp)){
						System.out.println("DEALER BUST!");
						comp.bust();
						break;
					}
				}
				break;
			}
		}
	}
	/** Checks if the player have busted if not 
	 * it lets the player make the chose if it wants another card
	 */
	
	private void playerChoises(){
		for(int i = 0; i < Player.size(); i++){
			while(true){
				this.printCardsPlayer(i);
				if(!this.checkBust(Player.get(i))){
					if(this.askForCard(i)){
						Player.get(i).addCardToHand(gameDeck.dealCard());	
					}
					else{
						break;
					}
				}
				else{
					System.out.println("YOU BUST!");
					Player.get(i).bust();
					break;
				}
			}	
			System.out.println("----------------------------------------------------");
		}
	}
	
	/** Checks if the value is over 21
	 */
	private boolean checkBust(Player player){
		if(player.getTotalValue()>21){
			return true;
		}
		return false;
	}
	
	/** Asks the player to make a choise
	 */
	private boolean askForCard(int playerPos){
		if(Player.get(playerPos).makeChoise(scan)){
			return true;
		}
		else 
			return false;
	}
	
	/** Deals a amount of cards to the player
	 */
	private void dealCards(Player player, int numberOfCards){
		for(int i = 0; i < numberOfCards; i++){
			player.addCardToHand(gameDeck.dealCard());
	}
		
	}
	/** Prints the cards a player have in his/hers hand
	 */
	private void printCardsPlayer(int playerPos){
		
			System.out.print("Player " + (playerPos+1) +" Cards: \n" + Player.get(playerPos).toString());
			System.out.println("Total Value: " + Player.get(playerPos).getTotalValue()+"\n");
	}
	
	/** Prints the dealers cards
	 */
	private void printCardsDealer(Player dealer){
		
		System.out.print("DEALER Cards: \n" + dealer.toString());
		System.out.println("Total Value: " + dealer.getTotalValue()+"\n");
}
	
}
