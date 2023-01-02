package fr.fryzhen.plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MonPluginListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.BREAD, 64));
        player.updateInventory();

    }
}
