package cardgames;

import java.util.*;
public class CardGame {
	private List<Cards> cards;

	//initial setup Constructs a standard deck of 52 cards.
	private static final List<String> RANKS = new ArrayList<String>(List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"));
	private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public CardGame() {
		this.cards = new ArrayList<Cards>(52);
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				cards.add(new Cards(SUITS[suit], RANKS.get(rank)));
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfPlayers;
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of players");
		numberOfPlayers=sc.nextInt();			// number of player added from console
		if (numberOfPlayers < 2 || numberOfPlayers > 4) {
			System.out.println("Enter the value between 2 and 4");
			numberOfPlayers = sc.nextInt();
		}else {
			Players player=new Players(numberOfPlayers);
		}
		
	}
}

