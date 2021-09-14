package cardgames;

import java.util.*;
public class PlayerCards {

	ArrayList<Cards> cardsForEachPlayer;
	
	public PlayerCards() {
		cardsForEachPlayer = new ArrayList<Cards>(9);
	}
	
	/**
     * to add a value to the hand
     * @param a card value
     */
    public void setCard(Cards cardPerPlayer)
    {
        this.cardsForEachPlayer.add(cardPerPlayer);
    }
    
    public ArrayList<Cards> displayCards() {
    	return this.cardsForEachPlayer;
    }
}
