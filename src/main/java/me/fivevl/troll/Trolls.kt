package me.fivevl.troll

import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import kotlin.random.Random

object Trolls {
    fun yeet(p: Player, ps: Player) {
        val loc = ps.location
        loc.yaw = Random.nextInt(360).toFloat()
        loc.pitch = Random.nextInt(-50, -20).toFloat()
        ps.velocity = loc.direction.multiply(3)
        p.sendMessage(Utils.color("<color:#4747ff>${ps.name} has been yeeted!</color>"))
    }

    fun pigBomb(p: Player, ps: Player) {
        val loc = ps.location
        loc.add(0.0, 2.0, 0.0)
        for (i in 0..10) {
            loc.world.spawnEntity(loc, EntityType.PIG)
        }
        p.sendMessage(Utils.color("<color:#4747ff>A pig bomb has been thrown on ${ps.name}!</color>"))
    }

    fun fakeOp(p: Player, ps: Player) {
        ps.sendMessage(Utils.color("<i><gray>[Server: Made ${ps.name} a server operator]</gray></i>"))
        p.sendMessage(Utils.color("<color:#4747ff>${ps.name} has been fake opped!</color>"))
    }

    fun spin(p: Player, ps: Player) {
        val loc = ps.location
        loc.yaw = loc.yaw + 180.0f
        ps.teleport(loc)
        p.sendMessage(Utils.color("<color:#4747ff>${ps.name} has been spun!</color>"))
    }

    fun ignite(p: Player, ps: Player) {
        ps.fireTicks = 200
        p.sendMessage(Utils.color("<color:#4747ff>${ps.name} has been ignited!</color>"))
    }
}