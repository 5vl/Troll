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
        gui.setItem(3, getSpinItem())
        gui.setItem(4, getIgniteItem())
        gui.setItem(5, getScareItem())
        gui.setItem(6, getExplodeItem())
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

    private fun getSpinItem(): ItemStack {
        val item = ItemStack(Material.SPRUCE_BOAT)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#e8ff52>Spin</color>"))
        meta.lore(Utils.loreBuilder("This will spin the player 180°."))
        item.itemMeta = meta
        return item
    }

    private fun getIgniteItem(): ItemStack {
        val item = ItemStack(Material.FLINT_AND_STEEL)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#ff8000>Ignite</color>"))
        meta.lore(Utils.loreBuilder("This will ignite the player", "for 10 seconds."))
        item.itemMeta = meta
        return item
    }

    private fun getScareItem(): ItemStack {
        val item = ItemStack(Material.CREEPER_HEAD)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#35ff0d>Scare</color>"))
        meta.lore(Utils.loreBuilder("Scare the player by playing", "a creeper ignition sound."))
        item.itemMeta = meta
        return item
    }

    private fun getExplodeItem(): ItemStack {
        val item = ItemStack(Material.TNT)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<color:#780600>Explode</color>"))
        meta.lore(Utils.loreBuilder("This will explode the player.", "Will do damage but won't break blocks!"))
        item.itemMeta = meta
        return item
    }

    /* ITEM DEFAULT SETUP
    private fun item(): ItemStack {
        val item = ItemStack(Material.)
        val meta = item.itemMeta
        meta.displayName(Utils.color(""))
        meta.lore(Utils.loreBuilder(""))
        item.itemMeta = meta
        return item
    }*/
}