package com.fawkes.plugin;

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
	ChatListener chat;

	public void onEnable() {

		// TODO: partial words
		// agohjaisoegjiowsdjigojwaiogjiokw

		chat = new ChatListener();

		// word ednings
		chat.registerEnding("ow", "ao");
		chat.registerEnding("ast", "est"); // Frostcest, cast - cest, blast -
											// blest,
		chat.registerEnding("ing", "in"); // doin, goin
		chat.registerEnding("er", "ah"); // watah, ovah, racah
		chat.registerEnding("ly", "leh");
		chat.registerEnding("ate", "8");
		chat.registerPart("on", "un"); // he is my sun
		chat.registerPart("some", "sum");
		chat.registerPart("ang", "eng"); // beng, geng, deng
		chat.registerPart("rr", "ww"); // Huwway, sowwy
		chat.registerPart("ine", "ein"); // Fine - fein, mines - meins
		chat.registerPart("ould", "ud"); // shud, wud

		// REGISTER WORDS

		chat.registerWord("you", "u");
		chat.registerWord("oh", "o");
		chat.registerWord("see", "c");
		chat.registerWord("why", "y");
		chat.registerWord("ok", "k");
		chat.registerWord("are", "r");
		chat.registerWord("be", "b");

		chat.registerWord("there", "der");
		chat.registerWord("can", "ken");
		chat.registerWord("not", "nawt");
		chat.registerWord("no", "nu");
		chat.registerWord("yes", "yus");
		chat.registerWord("okay", "oke", "k");
		chat.registerWord("ok", "oke", "k");
		chat.registerWord("right", "rite");
		chat.registerWord("how", "hao");
		chat.registerWord("wow", "wao");
		chat.registerWord("good", "gud");
		chat.registerWord("stop", "stahp");
		chat.registerWord("please", "pls");
		chat.registerWord("to", "tu");
		chat.registerWord("more", "moar");
		chat.registerWord("probably", "probs");
		chat.registerWord("like", "leik");
		chat.registerWord("why", "whai");
		chat.registerWord("much", "mch");
		chat.registerWord("cry", "cri");
		chat.registerWord("me", "meh");
		chat.registerWord("that", "dat");
		chat.registerWord("they", "dey");
		chat.registerWord("how", "hao");
		chat.registerWord("the", "da", "teh", "le", "dah");
		chat.registerWord("noob", "nub", "newb");
		chat.registerWord("what", "wat", "wot", "wut");
		chat.registerWord("mate", "m8");
		chat.registerWord("on", "awn");
		chat.registerWord("have", "hav");
		chat.registerWord("this", "dis", "dees", "dish");
		chat.registerWord("your", "ur", "yewr");
		chat.registerWord("and", "n", "an");
		chat.registerWord("also", "alsu");
		chat.registerWord("hack", "hak");
		chat.registerWord("hacks", "hax");
		chat.registerWord("with", "wiv");
		chat.registerWord("love", "luv", "wuv");
		chat.registerWord("someone", "sum1", "sumbuddeh", "sumwun", "someboday");
		chat.registerWord("impossible", "impossibru");
		chat.registerWord("possible", "possibru");
		chat.registerWord("lol", "lel", "leedle", "lmao");
		chat.registerWord("gg", "gg", "gee gee", "ggggg");
		chat.registerWord("diamond", "daimund");
		chat.registerWord("my", "mai", "my", "mah");
		chat.registerWord("though", "doe", "tho");
		chat.registerWord("fine", "fein");
		chat.registerWord("cool", "kewl", "kool");
		chat.registerWord("one", "un");
		chat.registerWord("it", "eet");
		chat.registerWord("i'm", "i iz", "im");
		chat.registerWord("im", "i iz");
		chat.registerWord("omg", "omg", "oh em gee", "omgawsh", "uh meh gawsh", "erhmagerd");
		chat.registerWord("swag", "sweg");
		chat.registerWord("hello", "hellow", "helloh", "ellow der");
		chat.registerWord("then", "den");
		chat.registerWord("was", "wus");
		chat.registerWord("damn", "dayum");
		chat.registerWord("damnit", "dammit");
		chat.registerWord("pc", "pee cee");
		chat.registerWord("doesnt", "dusnt");
		chat.registerWord("doesn't", "dusn't");
		chat.registerWord("plugin", "ploogin", "pluhgin");
		chat.registerWord("those", "dose");
		chat.registerWord("cant", "kent");
		chat.registerWord("thats", "dats");
		chat.registerWord("that's", "dat's");
		chat.registerWord("wanna", "wunna");
		chat.registerWord("than", "dan");
		chat.registerWord("is", "is", "iz");
		chat.registerWord("babe", "bae", "bb");
		chat.registerWord("today", "todai");
		chat.registerWord("said", "sed");
		chat.registerWord("now", "nao");
		chat.registerWord("wrecked", "rekt");
		chat.registerWord("sexy", "sxc");
		chat.registerWord("jealous", "jelleh");
		chat.registerWord("night", "nite");
		chat.registerWord("fight", "fite");
		chat.registerWord("bro", "brah");
		chat.registerWord("terrible", "terribru");
		chat.registerWord("of", "awf");
		chat.registerWord("help", "halp");

		// Easter eggs
		chat.registerPart("duke", "nub");
		chat.registerWord("nomar", "normar");
		chat.registerWord("fawkes", "le swag master");
		chat.registerWord("seawee", "le swag master");
		chat.registerWord("seawee65", "le swag master");
		chat.registerWord("fawk", "I am a nub");
		chat.registerWord("gibberish", "Gibberish [By Seawee & Nomar]", "Gibberish");
		chat.registerWord("notch", "King of Minecraft");
		chat.registerWord("herobrine", "Slender");
		chat.registerWord("skydoesmc", "Butter King");
		chat.registerWord("skydoesminecraft", "Butter King");
		chat.registerWord("mc", "Dah coolest game evah");
		chat.registerWord("minecraft", "Dah coolest game evah");
		chat.registerWord("admin", "Mr. Admin");
		chat.registerWord("mod", "Mr. Mod");
		chat.registerWord("owner", "Mr. Owner");
		chat.registerWord("butter", "gold");
		chat.registerWord(":o", "o;");

		// register phrases, phrases are two or more words separated by A SPACE
		chat.registerPhrase("what are you", "wutchu");
		chat.registerPhrase("i am", "i iz");
		chat.registerPhrase("thank you", "ty");
		chat.registerPhrase("no problem", "np");
		chat.registerPhrase("lot of", "lawta");
		chat.registerPhrase("don't know", "dunno");
		chat.registerPhrase("dont know", "dunno");
		chat.registerPhrase("shut up", "shuddup");
		chat.registerPhrase("damn it", "dammit");

		// register suprise phrases that replace whole message.
		// now supports SINGLE WORDS. (i.e. man not found in "i am a woman")
		chat.registerSuprise("dolphin", "╯°□°）╯︵ ┻━┻ FLIP dat TABLE. ┻━┻ ︵ ヽ(°□°ヽ) FLIP dees TABLE. ┻━┻ ︵ ＼('0')／ ︵ ┻━┻ FLIP ALL le TABLE o;");
		chat.registerSuprise("shat", "( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)T̵̛̺̫̦͙̍ͮ̃̈́̑̊̆́H͕̺̞͍̜̎ͭͤͨ̀̿ͦ́͠E̤̘̘̯ͪ́͆̂ͮ̓̋ͭ̚ ̩͈̪̙̮͖̖̞̆͌͒ͧ͗͗̍Ḓ͖͓͙̊ͤ͗̾̔ͬ̊̀Ǎ͎͙̙̼ͭͩ̄̂̓ͥ͠͠Ȓ̳́̅ͯͤͮ͋̏͊̀K̢̛͓̺̳̉͗ͣ̿̿̀͋̚͝ ̷̛̤̞̳͇͚̦̞ͣ͂ͤ̆̏ͭ̽͞ͅĻ̛̜͔͉̘̆ͦ̍Ȏ̵̮̣̗̟̞̜͔̩ͧ́̈ͧ͐̈́ͫŖ̠ͣͪ̃̏̂ͮ̎͆D̷͓̯̦͓̟̭̓̓ͧͤ̋̚ ̭͙͉̯̣̀ͩ͑͛͒̎͊Į̼̹ͯ̏̿̃ͣ̈́̉S̿ͤ̌ͣͪ̄͆̈ͯ́͏͖̼̩̳̩̦ ̳̦͔͍̱̩̰̔̽̏H͙̖̙̥̥͔̦̃ͨ̋ͣ̿ͅȄ̜̥̝̥͚̙̻ͦ̂̍̀̓͟R̨̢̛̘̪͖̜͚͂̊̾̑͆E̮͕͇̖̾̊̌͐̽̌ͨ̏͠( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)( ͡° ͜ʖ ͡°)");

		Bukkit.getServer().getPluginManager().registerEvents(chat, this);

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
					return true;

				}

				if (hasEnabled.contains(player.getName())) {
					hasEnabled.remove(player.getName());
					player.sendMessage(ChatColor.BLUE + "Gibberish disabled!");

				} else {
					hasEnabled.add(player.getName());
					player.sendMessage(ChatColor.BLUE + "Gibberish enabled!");

				}

			}

			return true;

		}

		return false;
	}

}
