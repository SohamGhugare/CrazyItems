package me.shadowdev.crazyitems.items;

import me.shadowdev.crazyitems.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TeleportBow {

    private static ItemStack teleportBow;

    public static ItemStack getTeleportBow(){

        teleportBow = Utils.createItem(Material.BOW, "&aTeleport Bow", 1, true,
                "&7&o\"They say some mythical archer dropped this...\"", "&7",
                "&6Ability: &eTeleports you wherever the arrow lands.");

        return teleportBow;
    }

}
