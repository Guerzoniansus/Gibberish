package NomarTheHero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Gibberish extends JavaPlugin {

	public static Set<String> hasEnabled = new HashSet<String>();

	public static HashMap<String, String> words = new HashMap<String, String>();

	public static HashMap<String, String> phrases = new HashMap<String, String>();

	public void onEnable() {

		// REGISTER WORDS

		registerWord("you", "u");
		registerWord("oh", "o");
		registerWord("see", "c");
		registerWord("why", "y");
		registerWord("ok", "k");
		registerWord("are", "r");
		
		//Part of words
		registerWord("er", "ah"); //Watah, ovah, racah
		registerWord("ly", "leh"); //Extremeleh, goodleh, deepleh, onleh
		registerWord("on", "un"); //I am un top of it, he is my sun, comparisun, dragun skeletun
		registerWord("ine", "ein"); //Fine - fein, mines - meins
		registerWord("ast", "est"); //Frostcest, cast - cest, blast - blest, last - lest, past - pest
		//Doesnt work, there should also be ow -> ao (how - hao, wow - waow, now - nao)
		
		
		registerWord("there", "der");
		registerWord("can", "ken");
		registerWord("not", "nawt");
		registerWord("no", "nu");
		registerWord("yes", "yus");
		registerWord("okay", "oke");
		registerWord("right", "rite");
		registerWord("good", "gud");
		registerWord("stop", "stahp");
		registerWord("please", "pls");
		registerWord("to", "tu");
		registerWord("more", "moar");
		registerWord("probably", "probs");
		registerWord("like", "leik");
		registerWord("why", "whai");
		registerWord("much", "mch");
		registerWord("cry", "cri");
		registerWord("me", "meh");
		registerWord("that", "dat");
		registerWord("they", "dey");
		registerWord("how", "hao");
		registerWord("the", "dah");
		registerWord("noob", "nub");
		registerWord("what", "wat");
		registerWord("mate", "m8");
		registerWord("would", "wud");
		registerWord("should", "shud");
		registerWord("have", "hav");
		registerWord("this", "dis");
		registerWord("your", "ur");
		registerWord("and", "n");
		registerWord("also", "alsu");
		registerWord("with", "wiv");
		registerWord("love", "luv");
		registerWord("someone", "someun");
		registerWord("impossible", "impossibru");
		registerWord("possibble", "possibru");
		registerWord("lol", "lel");
		registerWord("though", "doe");
		
		registerWord(" one ", " un ");
		registerWord(" it ", " eet "); //See dah clever spaces der? It's to make sure it's not part of a word o;; DOESNT WORK
		
		
		// register phrases, phrases are two or more words separated by A SPACE
		registerPhrase("i am", "i iz");
		registerPhrase("thank you", "ty");
		registerPhrase("lot of", "lawta");

		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(words, phrases), this);

		for (String word : words.keySet()) {
			Bukkit.getLogger().info(word);

		}

	}

	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("gibberish")) {
			if (sender instanceof Player) {

				Player player = (Player) sender;

				if (args.length != 0) {
					player.sendMessage(ChatColor.RED + "Usage: /gibberish");

				} else {

					if (hasEnabled.contains(player.getName())) {
						hasEnabled.remove(player.getName());
						player.sendMessage(ChatColor.BLUE + "Gibberish disabled!");

					} else {
						hasEnabled.add(player.getName());
						player.sendMessage(ChatColor.BLUE + "Gibberish enabled!");

					}

				}
			}
		}

		return true;
	}

	private void registerWord(String regularWord, String gibberishWord) {
		words.put(regularWord, gibberishWord);

	}

	private void registerPhrase(String regularPhrase, String gibberishPhrase) {
		phrases.put("(?i)" + regularPhrase, gibberishPhrase);

	}

}
