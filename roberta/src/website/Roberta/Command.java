package website.Roberta;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;

public class Command extends ListenerAdapter {
	
	private Model m;
	
	public Command(Model m) {
		this.m = m;
	}
	
	public static String tag = "uno";
	
	
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e) {
		
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String message = e.getMessage().getContentRaw();
		//System.out.println(message.length() >= tag.length());
		System.out.println(unoCommand(message, e));
		if(unoCommand(message, e)) {
			message = message.substring(3);
			//nothing
			if(!m.inSession && !m.inGame &&message.contains("setup") ) {
				m.inSession = true;
				e.getChannel().sendMessage("Game setup: type uno join to join").queue(channel -> {m.tc = channel.getTextChannel();});
				return;
			}
			//insesh
			if(m.inSession) {
				if(message.contains("quit")) {
					print("game has been cancelled",e);
					return;
				}
				
			}
			System.out.println("1here");
			if(m.inSession && !m.inGame) {
				if(message.contains("join")) {
					m.addPlayer(e.getMember().getUser().getIdLong());
					e.getChannel().sendMessage(e.getMember().getUser().getName()+" Joined").queue();
					return;
				}
				if(message.contains("start")) {
					if(m.createGame()) {
						print("game started", e);
					}else {
						print("game failed, need 2 or more players", e);
					}
					return;
				}
			}
			//ingame
			System.out.println("2here");
			if(m.inSession && m.inGame ) {
				System.out.println("hi");
				m.g.parseInput(message, getUser(e));
				return;
			}
			//in sesh or game
			

		}
	}
	
	public boolean inUserList(GuildMessageReceivedEvent e) {
		for(int i = 0; i < m.players.size(); i++) {
			if(e.getMember().getUser().getIdLong() == m.players.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean unoCommand(String message, GuildMessageReceivedEvent e) {
		return(message.length() >= tag.length() && message.substring(0,tag.length()).equals(tag) && !e.getMember().getUser().equals(e.getJDA().getSelfUser()));
	
	}
	public String getMessage(GuildMessageReceivedEvent e) {
		return(e.getMessage().getContentRaw());
	}
	public long getUser(GuildMessageReceivedEvent e) {
		return(e.getMember().getUser().getIdLong());
	}
	
	public void print(String message, GuildMessageReceivedEvent e) {
		e.getChannel().sendMessage(message).queue();
	}
	
	public void print(String message) {
		m.tc.sendMessage(message).queue();
	}
	
}
