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

		// register wuuuuurds

		registerWord("there", "der");

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

	public void registerWord(String regularWord, String gibberishWord) {
		words.put("(?i)" + regularWord, gibberishWord);

	}

}
