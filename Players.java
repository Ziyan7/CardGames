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
		System.out.println(n+" players are added to the game!");
		numberOfPlayers=n;
		players= new ArrayList<PlayerCards>(numberOfPlayers);
		for(int i=0;i<n;i++)
            players.add(i,new PlayerCards());
	}
	
	/**
	 * @method to sequence the players order
	 */
	public void PlayersOrder() {
		Integer rand;
		int count=0;
		while(numberOfPlayers > count) {
			rand = randomOrder.nextInt(4);
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
	
}