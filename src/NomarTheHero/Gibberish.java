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

	public static HashMap<String, String[]> xwords = new HashMap<String, String[]>();

	public static HashMap<String, String> phrases = new HashMap<String, String>();

	public static HashMap<String, String> parts = new HashMap<String, String>();

	public void onEnable() {

		// TODO: partial words
		// agohjaisoegjiowsdjigojwaiogjiokw

		// REGISTER WORDS

		registerWord("you", "u");
		registerWord("oh", "o");
		registerWord("see", "c");
		registerWord("why", "y");
		registerWord("ok", "k");
		registerWord("are", "r");
		registerWord("be", "b");
		

		// Part of words
		registerPart("er", "ah"); // Watah, ovah, racah
		registerPart("ly", "leh"); // Extremeleh, goodleh, deepleh, onleh
		registerPart("on", "un"); // I am un top of it, he is my sun,
									// comparisun, dragun skeletun
		registerPart("ine", "ein"); // Fine - fein, mines - meins
		registerPart("ast", "est"); // Frostcest, cast - cest, blast - blest,
									// last - lest, past - pest
		registerPart("some", "sum");
		registerPart("ing", "in"); //doin, goin
		registerPart("ang", "eng"); //beng, geng, deng
		

		registerWord("there", "der");
		registerWord("can", "ken");
		registerWord("not", "nawt");
		registerWord("no", "nu");
		registerWord("yes", "yus");
		registerWord("okay", "oke", "k");
		registerWord("ok", "oke", "k");
		registerWord("right", "rite");
		registerWord("how", "hao");
		registerWord("wow", "wao");
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
		registerWord("the", "da", "teh", "le", "dah");
		registerWord("noob", "nub", "newb");
		registerWord("what", "wat", "wot", "wut");
		registerWord("mate", "m8");
		registerWord("would", "wud");
		registerWord("should", "shud");
		registerWord("on", "awn");
		registerWord("have", "hav");
		registerWord("this", "dis");
		registerWord("your", "ur");
		registerWord("and", "n");
		registerWord("also", "alsu");
		registerWord("hack", "hax");
		registerWord("hacks", "hax");
		registerWord("with", "wiv");
		registerWord("love", "luv", "wuv");
		registerWord("someone", "sum1", "sumbuddeh", "sumwun");
		registerWord("impossible", "impossibru");
		registerWord("possibble", "possibru");
		registerWord("lol", "lel", "leedle", "lel");
		registerWord("gg", "gg", "gee gee");
		registerWord("diamond", "daimund");
		registerWord("my", "mai", "my", "mah");
		registerWord("though", "doe");
		registerWord("fine", "fein");
		registerWord("cool", "kewl");
		registerWord("one", "un");
		registerWord("it", "eet");
		registerWord("i'm", "i iz");
		registerWord("im", "i iz");
		registerWord("omg", "omg", "oh em gee", "omgawsh", "gawd", "erhmagerd");
		registerWord("swag", "sweg");
		registerWord("hello", "hellow", "helloh", "ellow der");
		registerWord("then", "den");
		registerWord("was", "wus");
		registerWord("damn", "dayum");
		registerWord("damnit", "dayum eet");
		registerWord("pc", "pee cee");
		registerWord("doesnt", "dusnt");
		registerWord("doesn't", "dusn't");
		registerWord("plugin", "ploogin");
		
		
		// Easter eggs
		registerWord("fawkes", "le swag master");
		registerWord("seawee", "le swag master");
		registerWord("seawee65", "le swag master");
		registerWord("gibberish", "Gibberish [By Seawee & Nomar]");
		registerWord("notch", "King of Minecraft");
		registerWord("herobrine", "Slender");
		registerWord("skydoesmc", "Butter King");
		registerWord("skydoesminecraft", "Butter King");
		registerWord("mc", "Dah coolest game evah");
		registerWord("minecraft", "Dah coolest game evah");
		registerWord("admin", "Mr. Admin");
		registerWord("mod", "Mr. Mod");
		registerWord("owner", "Mr. Owner");
		

		// register phrases, phrases are two or more words separated by A SPACE
		registerPhrase("what are you", "wutchu");
		registerPhrase("i am", "i iz");
		registerPhrase("thank you", "ty");
		registerPhrase("no problem", "np");
		registerPhrase("lot of", "lawta");
		registerPhrase("don't know", "dunno");
		registerPhrase("dont know", "dunno");
		registerPhrase("shut up", "shuddup");
		registerPhrase("damn it", "dayum eet");

		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(words, xwords, phrases, parts), this);

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

	public static void registerWord(String regularWord, String... gibberishWords) {

		if (gibberishWords.length == 1) {
			words.put(regularWord, gibberishWords[0]);
			return;

		}

		xwords.put(regularWord, gibberishWords);

	}

	public void registerPart(String regularPart, String gibberishPart) {
		parts.put(regularPart, gibberishPart);

	}

	private void registerPhrase(String regularPhrase, String gibberishPhrase) {
		phrases.put(regularPhrase, gibberishPhrase);

	}

}
