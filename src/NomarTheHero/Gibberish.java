package NomarTheHero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Gibberish extends JavaPlugin {

	public static Set<String> hasEnabled = new HashSet<String>();

	public static HashMap<String, String> words = new HashMap<String, String>();

	public void onEnable() {

		//REGISTER WORDS
				
		registerWord("you", "u");
		registerWord("oh", "o");
		registerWord("see", "c");
		registerWord("why", "y");
		registerWord("ok", "k");
		
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
		registerWord("the", "le");
		registerWord("what", "wat");
		registerWord("mate", "m8");
		
		registerWord("i am", "i iz");
		registerWord("thank you", "ty");
		registerWord("lot of", "lawta");

		getServer().getPluginManager().registerEvents(new ChatListener(words), this);
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
				}

				else {

					if (hasEnabled.contains(player.getName())) {
						hasEnabled.remove(player.getName());
						player.sendMessage(ChatColor.BLUE + "Gibberish disabled!");
					}

					else {
						hasEnabled.add(player.getName());
						player.sendMessage(ChatColor.BLUE + "Gibberish enabled!");
					}

				}

			}
		}

		return true;
	}

	private void registerWord(String regularWord, String gibberishWord) {
		words.put("(?i)" + regularWord, gibberishWord);

	}

}
