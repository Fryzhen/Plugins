package fr.fryzhen.plugin.bordel;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WitherPork implements Listener {

    @EventHandler
    public boolean onPlayerEatPork(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        Material type = event.getItem().getType();
        if (type.equals(Material.PORKCHOP) || type.equals(Material.COOKED_PORKCHOP)) {
            player.sendMessage("Le cochon c'est pas HALAL");
            Entity wither = player.getWorld().spawnEntity(player.getLocation().add(0, 1, 0), EntityType.WITHER);
            LivingEntity livingwither = (LivingEntity) wither;
            livingwither.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 999999999, 255));
        }
        return false;
    }

    @EventHandler
    // ils ont cru qu'ils récupéreraient la nether star aussi
    public boolean onDeathWither(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Wither) {
            PotionEffectType potionEffect = ((Wither) entity).getPotionEffect(PotionEffectType.LUCK).getType();
            if (potionEffect.equals(PotionEffectType.LUCK)){
                event.getDrops().clear();
            }
        }
        return false;
    }
}
