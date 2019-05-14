package me.luckyffa.system;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {

    private ArrayList<Player> Vanish = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.color("&cOnly player can use this commands"));
        }
        if (p.hasPermission("luckyffa.vanish.use")) {
            if (Vanish.contains(p)) {
                this.Vanish.remove(p);
                displayTitleBar(p, Main.color("&aVanish"), Main.color("&chas Disable"), 4);
                p.sendMessage(Main.color("&5Vanish has &7[ &aEnable &7]"));
                for (Player online : Bukkit.getOnlinePlayers()) {
                    online.showPlayer(p);
                    if (p.hasPermission("staff.vanish")){
                        online.sendMessage(Main.color("&d&l" + p.getName() + " &5has &7[ &dDisable &7]&5 the Vanish"));
                    }
                }
            } else {
                this.Vanish.add(p);
                for (Player online : Bukkit.getOnlinePlayers()) {
                    if (online.hasPermission("luckyffa.vanish.see")) {
                        online.showPlayer(p);
                    } else {
                        online.hidePlayer(p);
                    }
                }
                p.sendMessage(Main.color("&5Vanish has &7[ &dEnable &7]"));
                displayTitleBar(p, Main.color("&aVanish"), Main.color("&ehas Enable"), 4);
            }
        }
        return false;
    }
    public void displayTitleBar(Player player, String title, String subtitle, int seconds) {
        IChatBaseComponent title_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\",\"color\": \"dark_red\"}");
        IChatBaseComponent subtitle_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");

        PacketPlayOutTitle title_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title_component, 20, seconds*20, 20);
        PacketPlayOutTitle subtitle_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitle_component, 50, seconds*100, 50);

        CraftPlayer cPlayer = (CraftPlayer) player;
        cPlayer.getHandle().playerConnection.sendPacket(title_packet);
        cPlayer.getHandle().playerConnection.sendPacket(subtitle_packet);
    }
}
