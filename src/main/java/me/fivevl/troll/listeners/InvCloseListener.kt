package me.fivevl.troll.listeners

import me.fivevl.troll.gui.TrollGui
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class InvCloseListener : Listener {
    @EventHandler
    fun onInvClose(e: InventoryCloseEvent) {
        TrollGui.inTrollGui.remove(e.player)
    }
}