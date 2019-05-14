package me.luckyffa.ServerEvent;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

public class AnimetedExplosice implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        for(Block b : e.blockList()){

            final BlockState state = b.getState();

            b.setType(Material.AIR);

            int delay = 20;
            if((b.getType() == Material.SAND || (b.getType() == Material.GRAVEL))){
                delay +=1;
            }
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
                @Override
                public void run() {
                    state.update(true, false);
                }
            }, delay);
        }
    }
}
