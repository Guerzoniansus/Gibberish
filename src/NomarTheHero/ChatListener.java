package NomarTheHero;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
	
	public void onChat(AsyncPlayerChatEvent event){
		
		Player player = event.getPlayer();
		String message = event.getMessage();
		
		
		if (!Gibberish.hasEnabled.isEmpty()){
			if (Gibberish.hasEnabled.contains(player.getName())){
				
				message.replaceAll("(?i)there", "der");
				message.replaceAll("(?i)i am", "i iz");
								
				
				
				
				event.setMessage(message);
			}
		}
					
	}


}
