package me.fivevl.troll.commands

import me.fivevl.troll.Utils
import me.fivevl.troll.gui.TrollGui
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TrollCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.color("<red>You must be a player to use this command!</red>"))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("troll.use")) {
            p.sendMessage(Utils.color("<red>You don't have permission to use this command!</red>"))
            return true
        }
        if (args == null || args.size != 1) {
            p.sendMessage(Utils.color("<red>Usage: /troll <player></red>"))
            return true
        }
        val target = Bukkit.getPlayer(args[0])
        if (target == null) {
            p.sendMessage(Utils.color("<red>Player not found!</red>"))
            return true
        }
        p.openInventory(TrollGui.getGui(target, p))
        return true
    }
}