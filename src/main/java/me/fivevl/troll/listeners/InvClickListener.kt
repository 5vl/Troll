package me.fivevl.troll.listeners

import me.fivevl.troll.Utils
import me.fivevl.troll.gui.TrollGui
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import kotlin.random.Random

class InvClickListener : Listener {
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val p = e.whoClicked as Player
        if (TrollGui.inTrollGui.containsKey(p)) {
            e.isCancelled = true
            val ps = TrollGui.inTrollGui[p]!!
            if (e.rawSlot == 0) yeetPlayer(p, ps)
            if (e.rawSlot == 1) pigBomb(p, ps)
            if (e.rawSlot == 2) fakeOp(p, ps)
        }
    }

    private fun yeetPlayer(p: Player, ps: Player) {
        val loc = ps.location
        loc.yaw = Random.nextInt(360).toFloat()
        loc.pitch = Random.nextInt(-50, -20).toFloat()
        ps.velocity = loc.direction.multiply(3)
        TrollGui.inTrollGui.remove(p)
        p.closeInventory()
    }

    private fun pigBomb(p: Player, ps: Player) {
        val loc = ps.location
        loc.add(0.0, 2.0, 0.0)
        for (i in 0..10) {
            loc.world.spawnEntity(loc, EntityType.PIG)
        }
        TrollGui.inTrollGui.remove(p)
        p.closeInventory()
    }

    private fun fakeOp(p: Player, ps: Player) {
        ps.sendMessage(Utils.color("<i><gray>[Server: Made ${ps.name} a server operator]</gray></i>"))
        TrollGui.inTrollGui.remove(p)
        p.closeInventory()
    }
}