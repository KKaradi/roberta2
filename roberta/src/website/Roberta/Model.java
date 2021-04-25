package website.Roberta;

import java.util.ArrayList;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class Model {
	GameWrapper g;
	Command c;
	JDA j;
	TextChannel tc;
	
	boolean inSession = false;
	boolean inGame = false;
	ArrayList<Long> players;
	
	
	public Model(JDA j) {
		//this.c = c;
		this.j = j;
		c = new Command(this);
		j.addEventListener(c);
		
		players = new ArrayList<Long>();
	}
	public boolean createGame() {
		/*
		if(players.size() < 2) {
			return false;
		}
		*/
		g = new GameWrapper(this, players, c);
		inGame = true;	
		return true;
	}
	
	public void killGame() {
		g = null;
		players.clear();
	}
	
	public void addPlayer(long id) {
		for(int i = 0; i < players.size(); i++) {
			if(id == players.get(i)) {
				return;
			}
			
		}
		players.add(id);
	}
	

}
