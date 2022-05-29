package me.fivevl.troll

import me.fivevl.troll.commands.TrollCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Utils.instance = this
        getCommand("troll")!!.setExecutor(TrollCommand())
        logger.info("Troll plugin enabled successfully!")
    }
}