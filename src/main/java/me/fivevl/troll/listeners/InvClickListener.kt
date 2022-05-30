package me.fivevl.troll.listeners

import me.fivevl.troll.Trolls
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
            when (e.rawSlot) {
                0 -> Trolls.yeet(p, ps)
                1 -> Trolls.pigBomb(p, ps)
                2 -> Trolls.fakeOp(p, ps)
                3 -> Trolls.spin(p, ps)
                4 -> Trolls.ignite(p, ps)
                5 -> Trolls.scare(p, ps)
                6 -> Trolls.explode(p, ps)
            }
            TrollGui.inTrollGui.remove(p)
            p.closeInventory()
        }
    }
}