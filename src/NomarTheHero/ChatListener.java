package NomarTheHero;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	private HashMap<String, String> words;
	private HashMap<String, String> phrases;

	public ChatListener(HashMap<String, String> words, HashMap<String, String> phrases) {
		this.words = words;
		this.phrases = phrases;

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onChat(AsyncPlayerChatEvent event) {

		if (!Gibberish.hasEnabled.isEmpty()) {

			Player player = event.getPlayer();

			if (Gibberish.hasEnabled.contains(player.getName())) {

				String message = event.getMessage();

				String[] split = message.split(" ");

				String regularWord;

				for (int i = 0; i < split.length; i++) {

					regularWord = split[i];

					if (words.containsKey(regularWord.toLowerCase())) {

						split[i] = words.get(regularWord);

					}

				}

				message = "";

				for (String word : split) {
					message += word + " ";

				}

				for (String word : phrases.keySet()) {

					message.replace(word, phrases.get(word));

				}

				event.setMessage(message);

			}
		}
	}
}
