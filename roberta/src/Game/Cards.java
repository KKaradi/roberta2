package Game;
import java.awt.Color;

public class Cards {

	private int color;
	private int number;


	public Cards(int color, int number) {
		this.color = color;
		this.number = number;
	}
	public Cards() {
		this.randomStartColor();
		this.randomStartNumber();
	}
	public int getColor() { //gets color of the card
		return color;
	}

	public int getCardNumber() {
		return number;
	}

	public void setCardColor(int color) { //called in game
		this.color = color;
	}
	public void setCardNumber(int number) { //called in game
		this.number = number;
	}

	private void randomStartNumber() {
		number = (int)((Math.random())*10);

		//System.out.println(random);
	}

	private void randomStartColor() {
		color = (int)((Math.random())*4);

	}

	public String toString() {
		return("(C:"+color+", #:"+number+")");

	}


}
