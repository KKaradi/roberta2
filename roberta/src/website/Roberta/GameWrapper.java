package website.Roberta;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import Game.Game;

public class GameWrapper {
	Model m;
	ArrayList<Player> players;
	Game g;
	Command c;
	Pattern pattern; 

	Matcher matcher;
	public GameWrapper(Model m, ArrayList<Long> id, Command c) {
		this.m = m;
		this.c = c;
		players = new ArrayList<Player>();
		makePlayer(id);
		m.inGame = true;
		g = new Game(players.size(),c);


		pattern = Pattern.compile("/d+");
	}

	public void makePlayer(ArrayList<Long> id) {
		for(int i = 0; i < id.size(); i++) {
			players.add(new Player(id.get(i)));
		}
	}

	public void parseInput(String string, long l) {
		// TODO Auto-generated method stub
		System.out.println(l+"says "+string);
		
		pattern.matcher(string);
		
		System.out.println(matcher.find());
		
		/*
		if(Character.isDigit(string.charAt(0)) ) {
			g.acceptInput(Integer.parseInt(string.charAt(0))));
		}else if(string.contains("draw") || string.contains("Draw")) {
			g.acceptInput(-1);
		}
		*/
	}
}
