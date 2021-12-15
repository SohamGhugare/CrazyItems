package me.shadowdev.crazyitems.commands;

import me.shadowdev.crazyitems.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemEditor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        // Checking if player has permission
        if (!(player.hasPermission("CrazyItems.itemedit"))){
            Utils.msgPlayer(player, "&cYou cannot use this command.");
            return false;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        // Player is holding nothing
        if (item.getType() == Material.AIR){
            Utils.msgPlayer(player, "&cYou must be holding an item to use this command.");
            return false;
        }

        // Player didnt provide args
        if (args.length == 0){
            // Send help
            return true;
        }

        ItemMeta meta = item.getItemMeta();

        // Command: /ie name
        if (args[0].equalsIgnoreCase("name")){

            // Player didnt provide enough args
            if (!(args.length > 1)){
                Utils.msgPlayer(player, "&cPlease provide a name.");
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; i++){
                sb.append(args[i]).append(" ");
            }

            meta.setDisplayName(Utils.color(sb.toString()));
            item.setItemMeta(meta);

            Utils.msgPlayer(player, "&eSuccessfully edited your item.");
            return true;
        } else if (args[0].equalsIgnoreCase("unbreakable")) {
            if (!(args.length > 1)){
                Utils.msgPlayer(player, "&cPlease provide true|false.");
                return false;
            }

            if (args[1].equalsIgnoreCase("true")) {
                meta.setUnbreakable(true);
                Utils.msgPlayer(player, "&eSuccessfully edited your item.");
            } else if (args[1].equalsIgnoreCase("false")) {
                meta.setUnbreakable(false);
                Utils.msgPlayer(player, "&eSuccessfully edited your item.");
            } else{
                Utils.msgPlayer(player, "&cPlease provide true|false.");
                return false;
            }
            item.setItemMeta(meta);

        } else if (args[0].equalsIgnoreCase("lore")) {
            if (!(args.length > 1)){
                Utils.msgPlayer(player, "&cInsufficient args.", "&cUsage: /ie lore [set|add]");
                return false;
            }

            if (args[1].equalsIgnoreCase("set")){
                // Setting the lore directly

                List<String> lore = new ArrayList<>();

                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < args.length; i++){
                    sb.append(args[i]).append(" ");
                }
                lore.add(Utils.color(sb.toString()));
                meta.setLore(lore);
                item.setItemMeta(meta);
                Utils.msgPlayer(player, "&eSuccessfully edited your item.");

            } else if (args[1].equalsIgnoreCase("add")) {
                // Adding to existing lore

                List<String> lore = meta.getLore();
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < args.length; i++){
                    sb.append(args[i]).append(" ");
                }
                lore.add(Utils.color(sb.toString()));
                meta.setLore(lore);
                item.setItemMeta(meta);
                Utils.msgPlayer(player, "&eSuccessfully edited your item.");

            } else{
                Utils.msgPlayer(player, "&cInvalid args.", "&cUsage: /ie lore [set|add]");
                return false;
            }


        }

        return false;
    }

}
