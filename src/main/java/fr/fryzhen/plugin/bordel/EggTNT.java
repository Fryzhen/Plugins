package fr.fryzhen.plugin.bordel;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class EggTNT implements Listener {

    @EventHandler
    public boolean onSummonTntEgg(PlayerEggThrowEvent event){
        Player player = event.getPlayer();
        player.getWorld().spawnEntity(player.getLocation().add(0,0,0), EntityType.MINECART_TNT);
        return false;
    }
}
