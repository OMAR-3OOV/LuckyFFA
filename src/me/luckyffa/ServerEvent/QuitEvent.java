package me.luckyffa.ServerEvent;

import me.luckyffa.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(null);

        e.setQuitMessage(null);
        e.setQuitMessage(Main.color(Main.Quit + p.getName() + " " + "&ehas been Quit to FFA..!" ));
    }
}
