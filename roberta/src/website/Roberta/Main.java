package website.Roberta;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	public static String prefix = "cmer";
	//detect self
	//jda.getSelfUser()
	//event.getChannel().getMessageById(event.getMessageId());	
	public static void main(String[] args) throws LoginException{
		jda = JDABuilder.createDefault("PRIVATE TOKEN NEED TO ENTER VALID TOKEN: THIS CODE WON"T WORK WITHOUT IT").build(); 
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing("you are being watched,be afraid"));
		Model m = new Model(jda);
		//Command c = new Command(m);
		//jda.addEventListener(c);

		//jda.getSelfUser()	
		//jda.getPresence().setStatus(OnlineStatus.ONLINE);
		//jda.getPresence().setActivity(Activity.listening("commands"));
		//jda.addEventListener(new Commands());
	}
}
