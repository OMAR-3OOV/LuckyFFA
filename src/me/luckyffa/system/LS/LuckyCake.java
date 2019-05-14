package me.luckyffa.system.LS;

import me.luckyffa.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class LuckyCake implements Listener {

    public static ArrayList<String> cooldown = new ArrayList<>();

    private Main plugin;
    public LuckyCake(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if (event.getBlock().getType() != Material.CAKE_BLOCK)return;
        Location location = event.getBlock().getLocation().add(0.5, 0 , 0.5);
        event.setCancelled(true);
        int randomtype = new Random().nextInt(2); //0 1 2
            switch (randomtype){
                case 1:{
                    new BukkitRunnable(){
                        int i = 0;
                        @Override
                        public void run(){
                            p.setHealth(i);
                            p.sendTitle(Main.color("&7Health"),Main.color( "&9Congralulations"));
                            if(i<=10)this.cancel();
                        }
                    }.runTaskTimer(plugin, 20, 20);

                    break;
                }
                case 2:{

                    p.sendMessage(Main.color(Main.prefix + "&cbruh!"));
                    p.playSound(location, Sound.VILLAGER_NO, 1, 1);

                    break;
                }
            }
    }
}
