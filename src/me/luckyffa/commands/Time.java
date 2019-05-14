package me.luckyffa.commands;

import me.luckyffa.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(args.length == 0){
                if(args[0].equals("day") || args[0].equals("DAY")){

                    
                    p.sendMessage(Main.color(Main.prefix + "&bTime has been change to &7[ &eMorning &7]"));

                }else{
                    if(args[0].equals("night") || args[0].equals("NIGHT")){

                        p.sendMessage(Main.color(Main.prefix + "&bTime has been change to &7[ &8Night &7]"));

                    }
                }
            }
        }
        return false;
    }
}
