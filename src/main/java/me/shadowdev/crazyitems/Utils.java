package me.shadowdev.crazyitems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Utils {
    public static String color(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String decolor(String string){
        return ChatColor.stripColor(string);
    }

    public static void msgPlayer(Player player, String... msgs){
        for (String msg : msgs) {
            player.sendMessage(color(msg));
        }
    }

    public static ItemStack createItem(Material itemType, String name, int amount, boolean unbreakable, String... lores){
        // Making new item
        ItemStack item = new ItemStack(itemType, amount);

        ItemMeta meta = item.getItemMeta(); // Item meta

        meta.setDisplayName(color(name)); // Custom name
        meta.setUnbreakable(unbreakable); // Unbreakable

        // Setting lore
        List<String> lore = meta.getLore();
        for (String loreLine : lores) {
            lore.add(loreLine);
        }
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item; // Returning item
    }

}
