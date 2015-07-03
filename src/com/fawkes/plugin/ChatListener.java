package com.fawkes.plugin;

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
	private HashMap<String, String> parts;
	private HashMap<String, String> endings;

	Random rand;

	public ChatListener(HashMap<String, String> words, HashMap<String, String[]> xwords, HashMap<String, String> phrases, HashMap<String, String> parts, HashMap<String, String> endings) {
		this.words = words;
		this.xwords = xwords;
		this.phrases = phrases;
		this.parts = parts;
		this.endings = endings;

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

					regularWord = split[i].toLowerCase();

					// basic word checking
					if (words.containsKey(regularWord)) {

						split[i] = words.get(regularWord);

						continue;

					}

					// words with two or more possible outcomes
					if (xwords.containsKey(regularWord)) {

						String[] wordArray = xwords.get(regularWord);

						split[i] = wordArray[rand.nextInt(wordArray.length)];

						continue;

					}

					for (String ending : endings.keySet()) {
						if (regularWord.endsWith(ending)) {

							int lastInd = regularWord.lastIndexOf(ending);

							split[i] = new StringBuilder(regularWord).replace(lastInd, regularWord.length(), endings.get(ending)).toString();

							// no word is gonna end with two endings, that
							// doesn't make sense.
							break;

						}
					}

					// parts of words
					for (String part : parts.keySet()) {

						if (regularWord.contains(part)) {

							split[i] = regularWord.replace(part, parts.get(part));

						}

					}

				}

				message = "";

				for (String word : split) {
					message += word + " ";

				}

				if (rand.nextInt(10) < 2) {
					message += "o;";

				}

				event.setMessage(message);

			}
		}
	}
}
