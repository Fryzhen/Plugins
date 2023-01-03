package fr.fryzhen.plugin;

import fr.fryzhen.plugin.bordel.EggTNT;
import fr.fryzhen.plugin.bordel.WitherPork;
import fr.fryzhen.plugin.commands.CommandTest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugins : Bordel      : on");

        //Tutos
        getCommand("test").setExecutor(new CommandTest());
        getCommand("alert").setExecutor(new CommandTest());
        getServer().getPluginManager().registerEvents(new MonPluginListener(), this);

        //Perso
        getServer().getPluginManager().registerEvents(new EggTNT(), this);
        getServer().getPluginManager().registerEvents(new WitherPork(), this);


        //Tuto craft personalisé
        ItemStack item = new ItemStack(Material.BREAD);

        // On récup la Meta : Nom et Propriétés
        ItemMeta meta = item.getItemMeta();

        // On modifie le nom
        meta.setDisplayName("§6PAIN PAIN PAIN!!!!");

        // On ajoute un enchant Sharpness 5 et Kb 10
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);

        // On enregistre la meta
        item.setItemMeta(meta);


        // On crée un nom pour enregistrer le craft
        NamespacedKey key = new NamespacedKey(this, "ultime_pain");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        // On place les objets dans la table
        // Le format est comme cela
        // "ABC", "DEF", "GHI"

        //      ABC
        //      DEF
        //      GHI
        recipe.shape(" B ", " B ", " S ");

        // B = Blé
        // S = Stick
        recipe.setIngredient('B', Material.WHEAT);
        recipe.setIngredient('S', Material.STICK);

        // On ajoute la recette a bukit
        Bukkit.addRecipe(recipe);

    }

    @Override
    public void onDisable() {
        System.out.println("Plugins : test      : off");
    }
}
