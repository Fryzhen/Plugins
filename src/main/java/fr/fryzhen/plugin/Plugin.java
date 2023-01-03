package fr.fryzhen.plugin;

import fr.fryzhen.plugin.bordel.EggTNT;
import fr.fryzhen.plugin.bordel.WitherPork;
import fr.fryzhen.plugin.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;

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

    }

    @Override
    public void onDisable() {
        System.out.println("Plugins : test      : off");
    }
}
