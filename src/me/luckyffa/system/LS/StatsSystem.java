package me.luckyffa.system.LS;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class StatsSystem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("statsmember.show")) {

                if (args.length == 0) {
                    p.sendMessage(Main.color("&7&m&l-----&e&m&l[&7&m&l-&r &6Stats &7&m&l-&r&e&m&l]&7&m&l-----&r"));
                    p.sendMessage(Main.color(""));
                    p.sendMessage(Main.color("&e&lKills : &6" + p.getStatistic(Statistic.PLAYER_KILLS)));
                    p.sendMessage(Main.color(""));
                    p.sendMessage(Main.color("&eDeath : &6" + p.getStatistic(Statistic.DEATHS)));
                    p.sendMessage(Main.color(""));
                    p.sendMessage(Main.color("&7&m&l------------------"));
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);
                }
            /*/
                if (args.length == 0) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (p.getName() != target.getName()) {
                        if (target != null) {
                                p.sendMessage(Main.color("&7&n&l-----&e&n&l[&7&n&l-&r &6Stats " + target.getName() + " &7&n&l-&r&e&n&l]&7&n&l-----&r"));
                                p.sendMessage(Main.color(""));
                                p.sendMessage(Main.color("&e&lKills : &6" + target.getStatistic(Statistic.PLAYER_KILLS)));
                                p.sendMessage(Main.color(""));
                                p.sendMessage(Main.color("&eDeath : &6" + target.getStatistic(Statistic.DEATHS)));
                                p.sendMessage(Main.color(""));
                                p.sendMessage(Main.color("&7&n&l------------------------"));
                        } else {
                                p.sendMessage(Main.color(Main.prefix + "&cthis player is offline"));
                                p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
                        }
                    }else{
                        p.sendMessage(Main.color("&7&m&l-----&e&m&l[&7&m&l-&r &6Stats &7&m&l-&r&e&m&l]&7&m&l-----&r"));
                        p.sendMessage(Main.color(""));
                        p.sendMessage(Main.color("&e&lKills : &6" + p.getStatistic(Statistic.PLAYER_KILLS)));
                        p.sendMessage(Main.color(""));
                        p.sendMessage(Main.color("&eDeath : &6" + p.getStatistic(Statistic.DEATHS)));
                        p.sendMessage(Main.color(""));
                        p.sendMessage(Main.color("&7&m&l------------------"));
                        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);
                    }
                }
                /*/
            }else{
                p.sendMessage(Main.premission);
            }

            if (args.length == 1){

            }

        }
        return false;
    }
}
