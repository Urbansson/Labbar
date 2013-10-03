public class mainCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BlackJack game = new BlackJack(); 
		Deck test = new Deck();
		test.shuffleCards();
		System.out.println(test.toString());

		test.sortByRank();
		
		System.out.println(test.toString());
		
		//game.play();
		
	}

}
