package cardgames;

import java.util.*;

public class PlayerCards {

	ArrayList<Cards> cardsForEachPlayer;
	HashMap<String,Integer> suitDisplayForEachPlayer = new HashMap<String,Integer>();
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
    
    public ArrayList<Cards> getCards() {
    	return this.cardsForEachPlayer;
    }
    /**
     * @method suitsCardsForEach contains code to verify how many different types of cards each player received
     * it uses HahMap collection to count suits
     * @return suitDisplayForEachPlayer
     */
    public HashMap<String,Integer> suitsCardsForEach(){
    	Iterator itr = cardsForEachPlayer.iterator();
    	while(itr.hasNext()) {
    		String onlySuits = ((Cards) itr.next()).getSuit();		// filter the object to receive suits of type string
    		if(suitDisplayForEachPlayer.containsKey(onlySuits)) {
    			suitDisplayForEachPlayer.put(onlySuits,suitDisplayForEachPlayer.get(onlySuits)+1);
    		}else {
    			suitDisplayForEachPlayer.put(onlySuits, 1);
    		}
    		
    	}
    	return this.suitDisplayForEachPlayer;
    }
}