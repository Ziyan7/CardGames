package cardgames;

import java.util.*;

//player class
public class Players {
	int noOfPlayers;
	Random rand = new Random();

	Players(int n) {
		System.out.println(n + " players get ready to play");
		noOfPlayers = n;
	}

	public void PlayersOrder() {
		int order;
		int count = 0;
		ArrayList<Integer> sequence = new ArrayList<Integer>(noOfPlayers);
		
		while (noOfPlayers > count) {
			order = rand.nextInt(4);
			if (sequence.contains(order)) {
				continue;
			} else {
				sequence.add(order);
				count++;
			}
		}
	}

}
