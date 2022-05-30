package me.fivevl.troll.gui

import me.fivevl.troll.Utils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object TrollGui {
    val inTrollGui = HashMap<Player, Player>()
    fun getGui(target: Player, from: Player): Inventory {
        val gui = Bukkit.createInventory(null, 54, Utils.color("<color:#ff9e36>Troll Menu - ${target.name}</color>"))
        gui.setItem(0, getYeetItem())
        gui.setItem(1, getPigBombItem())
        gui.setItem(2, getFakeOpItem())
        inTrollGui[from] = target
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

    private fun getPigBombItem(): ItemStack {
        val item = ItemStack(Material.PIG_SPAWN_EGG)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#f563ff>Pig Bomb</color>"))
        meta.lore(Utils.loreBuilder("This will throw a pig bomb", "on the player."))
        item.itemMeta = meta
        return item
    }

    private fun getFakeOpItem(): ItemStack {
        val item = ItemStack(Material.BARRIER)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#ff462e>Fake Op</color>"))
        meta.lore(Utils.loreBuilder("This will fake op the player."))
        item.itemMeta = meta
        return item
    }
}