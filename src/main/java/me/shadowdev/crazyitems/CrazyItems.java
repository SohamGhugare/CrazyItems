package me.shadowdev.crazyitems;

import org.bukkit.plugin.java.JavaPlugin;

public final class CrazyItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Successfully loaded CrazyItems.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
