package me.luckyffa.commands;

import javafx.print.PageLayout;
import me.luckyffa.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmold implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if (commandSender instanceof Player) {
            if (p.hasPermission("luckyffa.gamemode.commands")) {
                if (args.length == 0) {
                    p.sendMessage(Main.color("&cUsage : /gm <mod>"));
                }
            }
        }
        return false;
    }
}
