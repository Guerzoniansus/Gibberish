package NomarTheHero;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	private HashMap<String, String> words;

	public ChatListener(HashMap<String, String> words) {
		this.words = words;

	}

	public void onChat(AsyncPlayerChatEvent event) {

		Player player = event.getPlayer();
		String message = event.getMessage();

		if (!Gibberish.hasEnabled.isEmpty()) {
			if (Gibberish.hasEnabled.contains(player.getName())) {
				for (String word : words.keySet()) {

					message.replace(word, words.get(word));

				}

				event.setMessage(message);

			}
		}
	}
}
