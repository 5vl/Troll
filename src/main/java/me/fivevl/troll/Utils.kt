package me.fivevl.troll

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

object Utils {
    lateinit var instance: Main
    fun color(s: String): Component {
        return MiniMessage.miniMessage().deserialize(s)
    }
    fun loreBuilder(vararg arr: String): ArrayList<Component> {
        val lore = ArrayList<Component>()
        for (s in arr) {
            lore.add(color("<color:#40fff9>$s</color>"))
        }
        return lore
    }
}