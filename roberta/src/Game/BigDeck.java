package Game;
import java.util.ArrayList;
//gib desmos shirt
public class BigDeck {
	public  ArrayList<Cards> deck;
	private Cards centerCard;
	
	public BigDeck() {
		centerCard = new Cards();
		deck = new ArrayList<Cards>();
		generateDeck();
	}
	
	public void generateDeck() {
		for(int i = 0; i < 52; i++) {
			//deck.add(new Cards((int)(Math.random())*10));
						
			deck.add(new Cards());
			
			
		}
	}
	
	
	//
	public Cards draw() {
		Cards topCard = deck.get(1);
		deck.remove(topCard);
		deck.add(topCard);
		return topCard;
//		return null;
	}
}
