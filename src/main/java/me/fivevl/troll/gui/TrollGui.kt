package me.fivevl.troll.gui

import me.fivevl.troll.Utils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object TrollGui {
    fun getGui(target: Player): Inventory {
        val gui = Bukkit.createInventory(null, 54, Utils.color("<color:#ff9e36>Troll Menu - ${target.name}</color>"))
        gui.setItem(0, getYeetItem())
        return gui
    }

    private fun getYeetItem(): ItemStack {
        val item = ItemStack(Material.ELYTRA)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#ffd6cf>Yeet</color>"))
        meta.lore(Utils.loreBuilder("This will yeet the player", "in a random direction."))
        item.itemMeta = meta
        return item
    }
}