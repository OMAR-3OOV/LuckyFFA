package me.luckyffa.system;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import sun.plugin2.main.server.Plugin;

import java.util.ArrayList;


public class HologramLuckyFFA implements CommandExecutor {

    static ArrayList<String> num = new ArrayList<>();

    private Main plugin;
    public HologramLuckyFFA(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.color("&Only player can use this commands"));
        }

            num.clear();
            num.add("1");

            BukkitScheduler s = Bukkit.getServer().getScheduler();
            s.scheduleSyncRepeatingTask((org.bukkit.plugin.Plugin) this, new Runnable() {
                public void run()
                {
                    Player p = (Player) sender;

                    ArmorStand holograms = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARMOR_STAND);
                    ArmorStand holograms1 = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0, 0.5, 0), EntityType.ARMOR_STAND);


                    holograms.setVisible(false);
                    holograms.setCustomNameVisible(true);
                    holograms.setCustomName(Main.color("&7Welcome To &aZOTAX &7Server : " + p.getPlayer().isOnline()));
                    holograms.setGravity(false);
                    holograms.setArms(false);

                    holograms1.setVisible(false);
                    holograms1.setCustomNameVisible(true);
                    holograms1.setCustomName(Main.color("&7If you want join to discord [ &a/discord &7]"));
                    holograms1.setGravity(false);
                    holograms1.setArms(false);
                }
            }, 0L, 2L);

        return false;
    }
}
