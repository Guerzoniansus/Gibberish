package NomarTheHero;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	private HashMap<String, String> words;
	private HashMap<String, String[]> xwords;
	private HashMap<String, String> phrases;

	Random rand;

	public ChatListener(HashMap<String, String> words, HashMap<String, String[]> xwords, HashMap<String, String> phrases) {
		this.words = words;
		this.xwords = xwords;
		this.phrases = phrases;

		rand = new Random();

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onChat(AsyncPlayerChatEvent event) {

		if (!Gibberish.hasEnabled.isEmpty()) {

			Player player = event.getPlayer();

			if (Gibberish.hasEnabled.contains(player.getName())) {

				String message = event.getMessage();
				String lowerCase = message.toLowerCase();

				for (String phrase : phrases.keySet()) {
					if (lowerCase.contains(phrase)) {
						// only replaceAll works with regex, don't use it
						// otherwise. (use replace)
						message = message.replaceAll("(?i)" + phrase, phrases.get(phrase));

					}
				}

				String[] split = message.split(" ");

				String regularWord;

				for (int i = 0; i < split.length; i++) {

					regularWord = split[i];

					if (words.containsKey(regularWord.toLowerCase())) {

						split[i] = words.get(regularWord);

					}

					if (xwords.containsKey(regularWord.toLowerCase())) {

						String[] wordArray = xwords.get(regularWord);

						split[i] = wordArray[rand.nextInt(wordArray.length)];

					}

				}

				message = "";

				for (String word : split) {
					message += word + " ";

				}

				event.setMessage(message);

			}
		}
	}
}
