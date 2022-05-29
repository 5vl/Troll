package me.fivevl.troll.listeners

import me.fivevl.troll.gui.TrollGui
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InvClickListener : Listener {
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val p = e.whoClicked as Player
        if (TrollGui.inTrollGui.containsKey(p)) {
            e.isCancelled = true
            val ps = TrollGui.inTrollGui[p]!!
            if (e.rawSlot == 0) {
                ps.velocity = ps.location.toVector().multiply(6)
                TrollGui.inTrollGui.remove(p)
                p.closeInventory()
            }
        }
    }
}