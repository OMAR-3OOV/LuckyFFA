package me.luckyffa.system;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class HealTag implements Listener {
    private Scoreboard s;
    public void onnata(){
    s = Bukkit.getScoreboardManager().getMainScoreboard();
    }
    @EventHandler
    public void onhealtag(){
        if (s.getObjective("health") != null){
            s.getObjective("health").unregister();
        }
       Objective o = s.registerNewObjective("health", "health");
        o.setDisplayName(Main.color("&c❤"));
    }
    public void Playerp(PlayerJoinEvent e){
        s.getTeam("blue").addPlayer(e.getPlayer());
    }
    public void NameTag(){
        if (s.getTeam("blue") != null){
            s.getTeam("blue").unregister();
        }
        Team t = s.registerNewTeam("blue");
        t.setPrefix(Main.color("&9"));
    }

}
