package me.luckyffa.system;

import me.luckyffa.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    public static int onPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;

                    if (onPing(p) <= 10) {
                        p.sendMessage(Main.color(Main.prefix + "&ePing >> &e" + onPing(p) + "&ems"));
                    } else if (onPing(p) <= 30) {
                        p.sendMessage(Main.color(Main.prefix + "&ePing >> &2" + onPing(p) + "&ems"));
                    } else if (onPing(p) >= 100) {
                        p.sendMessage(Main.color(Main.prefix + "&ePing >> &a" + onPing(p) + "&ems"));
                    } else if (onPing(p) >= 150) {
                        p.sendMessage(Main.color(Main.prefix + "&ePing >> &c" + onPing(p) + "&ems"));
                    } else if (onPing(p) >= 200) {
                        p.sendMessage(Main.color(Main.prefix + "&ePing >> &4" + onPing(p) + "&ems"));
                    }
                }
        return false;
    }
}
