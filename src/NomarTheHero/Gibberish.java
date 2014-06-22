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

	public static HashMap<String, String> endings = new HashMap<String, String>();

	public void onEnable() {

		// TODO: partial words
		// agohjaisoegjiowsdjigojwaiogjiokw

		// word ednings
		registerEnding("ow", "ao");
		registerEnding("ast", "est"); // Frostcest, cast - cest, blast - blest,
		registerEnding("ing", "in"); // doin, goin
		registerEnding("er", "ah"); //watah, ovah, racah
		registerEnding("ly", "leh");
		registerEnding("ate", "8");
		registerPart("on", "un"); //he is my sun
		registerPart("some", "sum");
		registerPart("ang", "eng"); // beng, geng, deng
		registerPart("rr", "ww"); // Huwway, sowwy
		registerPart("ine", "ein"); // Fine - fein, mines - meins
		registerPart("ould", "ud"); // shud, wud
		
		// REGISTER WORDS

		registerWord("you", "u");
		registerWord("oh", "o");
		registerWord("see", "c");
		registerWord("why", "y");
		registerWord("ok", "k");
		registerWord("are", "r");
		registerWord("be", "b");

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
		registerWord("on", "awn");
		registerWord("have", "hav");
		registerWord("this", "dis", "dees", "dish");
		registerWord("your", "ur", "yewr");
		registerWord("and", "n", "an");
		registerWord("also", "alsu");
		registerWord("hack", "hak");
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
		registerWord("cool", "kewl", "kool");
		registerWord("one", "un");
		registerWord("it", "eet");
		registerWord("i'm", "i iz");
		registerWord("im", "i iz");
		registerWord("omg", "omg", "oh em gee", "omgawsh", "uh meh gawsh", "erhmagerd");
		registerWord("swag", "sweg");
		registerWord("hello", "hellow", "helloh", "ellow der");
		registerWord("then", "den");
		registerWord("was", "wus");
		registerWord("damn", "dayum");
		registerWord("damnit", "dammit");
		registerWord("pc", "pee cee");
		registerWord("doesnt", "dusnt");
		registerWord("doesn't", "dusn't");
		registerWord("plugin", "ploogin", "pluhgin");
		registerWord("those", "dose");
		registerWord("cant", "kent");
		registerWord("thats", "dats");
		registerWord("that's", "dat's");
		registerWord("wanna", "wunna");
		registerWord("than", "dan");
		registerWord("is", "is", "iz");
		registerWord("babe", "bae", "bb");
		registerWord("today", "todai");
		registerWord("said", "sed");
		registerWord("now", "nao");
		registerWord("wrecked", "rekt");
		registerWord("sexy", "sxc");
		registerWord("jealous", "jelleh");
		registerWord("night", "nite");
		registerWord("fight", "fite");
		registerWord("bro", "brah");
		registerWord("terrible", "terribru");
		registerWord("of", "awf");
		registerWord("help", "halp");

		// Easter eggs
		registerPart("duke", "nub");
		registerWord("fawkes", "le swag master");
		registerWord("seawee", "le swag master");
		registerWord("seawee65", "le swag master");
		registerWord("fawk", "I am a nub");
		registerWord("gibberish", "Gibberish [By Seawee & Nomar]", "Gibberish");
		registerWord("notch", "King of Minecraft");
		registerWord("herobrine", "Slender");
		registerWord("skydoesmc", "Butter King");
		registerWord("skydoesminecraft", "Butter King");
		registerWord("mc", "Dah coolest game evah");
		registerWord("minecraft", "Dah coolest game evah");
		registerWord("admin", "Mr. Admin");
		registerWord("mod", "Mr. Mod");
		registerWord("owner", "Mr. Owner");
		registerWord("butter", "gold");
		registerWord(":o", "o;");

		// register phrases, phrases are two or more words separated by A SPACE
		registerPhrase("what are you", "wutchu");
		registerPhrase("i am", "i iz");
		registerPhrase("thank you", "ty");
		registerPhrase("no problem", "np");
		registerPhrase("lot of", "lawta");
		registerPhrase("don't know", "dunno");
		registerPhrase("dont know", "dunno");
		registerPhrase("shut up", "shuddup");
		registerPhrase("damn it", "dammit");

		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(words, xwords, phrases, parts, endings), this);

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
				
				if (!player.hasPermission("gibberish.use")){
					return false;
				}

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

	private void registerEnding(String regularEnding, String gibberishEnding) {
		endings.put(regularEnding, gibberishEnding);

	}

}
