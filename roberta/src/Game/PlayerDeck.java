package Game;
import java.util.ArrayList;

public class PlayerDeck {
	
	public ArrayList<Cards> playerDeck;
	private BigDeck bd;
	
	public PlayerDeck(BigDeck bd) {
		this.bd = bd;
		playerDeck = new ArrayList<Cards>();
	}
	
	public void make() {
		for(int i = 0; i < 1; i++) {
			drawCard();
		}
	}
	
	public void drawCard() { 
		
		playerDeck.add(bd.draw());
	}
	
	public void playCard(Cards deleteCard) {
		playerDeck.remove(deleteCard);
	}
	
	public int getSize() {
		return playerDeck.size();
	}
	
	
	
	//something about Bot printing out the cards that you have
}
