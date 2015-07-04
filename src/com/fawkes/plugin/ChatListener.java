package com.fawkes.plugin;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
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

	private HashMap<String, String> suprise;

	Random rand;

	public ChatListener() {

		words = new HashMap<String, String>();
		xwords = new HashMap<String, String[]>();
		phrases = new HashMap<String, String>();
		parts = new HashMap<String, String>();
		endings = new HashMap<String, String>();
		suprise = new HashMap<String, String>();

		rand = new Random();

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onChat(AsyncPlayerChatEvent event) {

		// for performance
		if (Gibberish.hasEnabled.isEmpty()) {
			return;

		}

		if (!Gibberish.hasEnabled.contains(event.getPlayer().getName())) {

			// also performance ;'(
			if (Bukkit.getOnlinePlayers().length > 50) {
				return;

			}

			// pfft time 4 awesomeness

			String lowerCase = event.getMessage().toLowerCase();

			if (lowerCase.contains("#nodolphins")) {
				event.setMessage(event.getMessage().replace("(?i)#nodolphins", ""));
				return;

			}

			for (String phrase : lowerCase.split(" ")) {
				if (lowerCase.equals(phrase)) {
					event.setMessage(suprise.get(phrase));
					return;

				}
			}

			return;

		}

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

				split[i] = xwords.get(regularWord)[rand.nextInt(xwords.get(regularWord).length)];

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

	public void registerWord(String regularWord, String... gibberishWords) {

		if (gibberishWords.length == 1) {
			words.put(regularWord, gibberishWords[0]);
			return;

		}

		xwords.put(regularWord, gibberishWords);

	}

	public void registerPart(String regularPart, String gibberishPart) {
		parts.put(regularPart, gibberishPart);

	}

	public void registerPhrase(String regularPhrase, String gibberishPhrase) {
		phrases.put(regularPhrase, gibberishPhrase);

	}

	public void registerEnding(String regularEnding, String gibberishEnding) {
		endings.put(regularEnding, gibberishEnding);

	}

	public void registerSuprise(String phrase, String suprisePhrase) {
		suprise.put(phrase, suprisePhrase);

	}

}
