package com.communitysurvivalgames.thesurvivalgames.command.sg;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class SGCommand implements Listener {

	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sg")) {
			if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("remove")) {
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.RED + "Bungeecord mode does not currently support in-game arena creation/editing/deletion"));
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.RED + "Please see the" + ChatColor.LIGHT_PURPLE + " Wiki" + ChatColor.RED + " under the" + ChatColor.BLUE + " Setup" + ChatColor.RED + " section to learn how to set up your SG network"));
				return true;
			}
		}
		
		
		return false;
	}

}
