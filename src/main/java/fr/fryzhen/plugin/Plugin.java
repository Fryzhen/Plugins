package fr.fryzhen.plugin;

import fr.fryzhen.plugin.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugins : test      : on");
        getCommand("test").setExecutor(new CommandTest());
        getCommand("alert").setExecutor(new CommandTest());
        getServer().getPluginManager().registerEvents(new MonPluginListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Plugins : test      : off");
    }
}
