package Game;
import java.awt.Color;
import java.util.ArrayList;
import website.Roberta.*;
public class Game {
	private ArrayList<Player> players;
//	private int numOfPlayers = 0;
	private BigDeck bd;
	int currentPlayer;
	private Cards centerCard;
	private boolean inputRequest = false;
	private boolean unoRequest = false;
	private int input;
	private boolean uno;
	private int errorCode;
	private Command command;
	
	public Game(int numPlayers, Command command) {
		this.command = command;
		command.print("hey discord");
		centerCard = new Cards();
		bd = new BigDeck();
		makePlayers(numPlayers);
		
		gameLoop();
	}
	
	public void gameLoop() {
		
		while(true) {
			round();
			
			
			
		}
	}
	
	public void stepPlayer() {
		currentPlayer++;
		if(currentPlayer == players.size()) {
			currentPlayer = 0;
		}
	}
	
	public void waitForInput() {
		while(!inputRequest){System.out.println("hesf");};
		
	}
	
	public void waitForUno() {
		while(!unoRequest);
	}
	
	public void round() {
		
		waitForInput();
		while(errorCode < 0) {
			inputRequest = false;
			waitForInput();
		}
		if(findUno()) {
			waitForUno();
			while(!uno) {
				waitForInput();
			}
		}
		if(findZero()) {
			
		}
		
		
//		//while(inputAccepted == false) {
//			
//		//}
//		System.out.println("CurrentPlayer: " + (currentPlayer+1));
//		System.out.println(get());
//		System.out.println("CenterCard: " + centerCard);
//		
//		int accepted = acceptInput(TextIO.getlnInt());
//		while(accepted < 0) {
//			accepted = acceptInput(TextIO.getlnInt());
//		}
//		stepPlayer();
//		
//		if(findUno()) {
//			System.out.println("uno!");
//			//while(unoAccepted == false){
//			
//			//
//		}
//		if(findZero()) {
//			System.out.println("you win");
//		}
//		findZero();
//		inputAccepted = false;
//		System.out.println(this);
	}
	
	public boolean isMatch(Cards card) {
		
		if(card.getCardNumber() == centerCard.getCardNumber()) {
			return true;
		}
		if(card.getColor() == centerCard.getColor()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean match(Cards a, Cards b) {
		if(a.getCardNumber() == b.getCardNumber()) {
			return true;
		}
		if(a.getColor() == b.getColor()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int acceptInput(int index) {
		if(index < -1 || index >= getPlayerDeck(currentPlayer).size()) {
			return -1;
		}
		if(index == -1) {
			draw();
			inputRequest = true;
			return 1;
		}
		Cards select = get().get(index);
		if(isMatch(select)) {
			taking(select);
			inputRequest = true;
			return 1;
		}else {
			return -2;
		}
		
	
	}
	
	public void taking(Cards c) {
		players.get(currentPlayer).pd.playCard(c);
		centerCard = c;
	}
	
	public ArrayList<Cards> getPlayerDeck(int i) {
		return(players.get(i).pd.playerDeck);
		
	}
	
	public ArrayList<Cards> get(){
		return getPlayerDeck(currentPlayer);
	}
	
	private void makePlayers(int numPlayers) {
		players = new ArrayList<Player>();
		for(int i = 0 ; i < numPlayers; i++) {
			players.add(new Player(bd));
			players.get(i).pd.make();
		}
	}
	
	public void draw() {
		get().add(bd.draw());
//		for(int i = 0; i < get().size(); i++) {
//			if(isMatch(get().get(i))){
//				return true;
//			}
//		}
//		return false;
//		
			
	}
	
	public void callUno() {
		
	}
	
	private boolean findUno() {
		for(int i = 0 ; i < players.size(); i++) {
			if(players.get(i).pd.playerDeck.size() == 1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean findZero() {
		for(int i = 0 ; i < players.size(); i++) {
			if(players.get(i).pd.playerDeck.size() == 0) {
				return true;
				//System.out.println("you win!");
			}
		}
		return false;
	}
	
	public String toString() {
		String ret = "";
		for(int i = 0 ; i < players.size(); i++) {
			for(int ii = 0; ii < players.get(i).pd.playerDeck.size();ii++) {
				ret += players.get(i).pd.playerDeck.get(ii).toString()+","; //eyeyey captain
			}
			ret+='\n';
		}
		return ret;
	}
	/*
	 * 
	 * 
	 * check for unos
	 * check for winners (0 cards)
	 	* print winners
	 * tell person to pick + place, draw, resign?
	 * check if the card can actually be placed
	 * 
	 */
	
}
