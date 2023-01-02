package fr.fryzhen.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("test")) {
                player.sendMessage(ChatColor.RED + "Bravo");
                return true;
            }
            if (cmd.getName().equalsIgnoreCase("alert")) {
                if (args.length == 0) {
                    Bukkit.broadcastMessage("{" + player.getName() + "} fait une alerte");
                }
                if (args.length >= 1) {
                    StringBuilder bc = new StringBuilder();
                    for (String part : args){
                        bc.append(part + " ");
                    }
                    Bukkit.broadcastMessage("{" + player.getName() + "} " + bc.toString());

                }

                return true;
            }
        }

        return false;
    }
}
