package me.shadowdev.crazyitems;

import me.shadowdev.crazyitems.commands.ItemEditor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrazyItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Successfully loaded CrazyItems.");

        // Registering commands
        this.getCommand("itemedit").setExecutor(new ItemEditor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
