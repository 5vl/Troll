package me.fivevl.troll

import me.fivevl.troll.commands.TrollCommand
import me.fivevl.troll.listeners.InvClickListener
import me.fivevl.troll.listeners.InvCloseListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Utils.instance = this
        registerCommands()
        registerListeners()
        logger.info("Troll plugin enabled successfully!")
    }

    private fun registerCommands() {
        getCommand("troll")!!.setExecutor(TrollCommand())
    }

    private fun registerListeners() {
        val plm = Bukkit.getPluginManager()
        plm.registerEvents(InvClickListener(), this)
        plm.registerEvents(InvCloseListener(), this)
    }
}