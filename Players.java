package cardgames;

import java.util.*;

//player class
public class Players {
	Random randomOrder = new Random();
	int numberOfPlayers;
	ArrayList<Integer> sequence=new ArrayList<Integer>(numberOfPlayers);
	
	ArrayList<PlayerCards> players;
	
	/**
	 * constructor to initialize number of players playing the game
	 * @param n
	 */
	Players(int n){
		System.out.println(n+" players are added to the game");
		numberOfPlayers=n;
		players= new ArrayList<PlayerCards>(numberOfPlayers);
		for(int i=0;i<numberOfPlayers;i++)
            players.add(i,new PlayerCards());
	}
	
	/**
	 * @method to sequence the players order
	 */
	public void PlayersOrder() {
		Integer rand;
		int count=0;
		while(numberOfPlayers > count) {
			rand = randomOrder.nextInt(numberOfPlayers);
			if(sequence.contains(rand)) {
				continue;
			}else {
				sequence.add(rand);
				count++;
			}	
		}
	}
	
	//method distribute cards according to player sequence
	public void distributeCards(ArrayList<Cards> cards) {
		int countCards=0;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < numberOfPlayers; j++) {
				PlayerCards eachPlayer = players.get(sequence.get(j));
				eachPlayer.setCard(cards.get(countCards));		// set each player object with a card
				countCards++;
			}
		}
	}
	
	/**
	 * @method to output count of different type of cards received by a player
	 */
	public void suitsForEachPlayer() {
		for(int i=0;i<numberOfPlayers;i++) {
			PlayerCards eachPlayer=players.get(sequence.get(i));
			System.out.println("Player "+(i+1)+" has"+" recieved");
			System.out.println(eachPlayer.suitsCardsForEach());
		}
	}
	
	/**
	 * @method to order the cards in sequence of
	 * lower rank to higher rank
	 */
	public void sortCards() {
		for (PlayerCards player : players) {
			// hand of the player
			ArrayList<Cards> playerIterate = player.getCards();
			// to sort the cards
			for (int i = 0; i < playerIterate.size(); i++) {
				for (int j = 0; j < playerIterate.size() - i - 1; j++) {
					// get the card
					Cards rankOfCard1 = playerIterate.get(j);
					Cards rankOfCard2 = playerIterate.get(j + 1);
					// to compare which card has highest rank
					if (compare(rankOfCard1, rankOfCard2) == rankOfCard2) {
						// replace the cards
						playerIterate.set(j, rankOfCard2);
						playerIterate.set(j + 1, rankOfCard1);
					}
				}
			}
		}
		for(int i=0;i<numberOfPlayers;i++) {
			PlayerCards eachPlayer=players.get(sequence.get(i));
			System.out.println("Player "+(i+1)+" has");
			System.out.println(eachPlayer.getCards());
		}
	}
	
	/**
	 * @method to return lower rank card
	 * @param rankOfPlayer1
	 * @param rankOfPlayer2
	 * @return
	 */
	public Cards compare(Cards rankOfCard1, Cards rankOfCard2) {
		final List<String> rankings = new ArrayList<String>(
				List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"));
		if (rankings.indexOf(rankOfCard1.getRank()) < rankings.indexOf(rankOfCard2.getRank()))
			return rankOfCard1;
		else
			return rankOfCard2;
	}
	
}
	
