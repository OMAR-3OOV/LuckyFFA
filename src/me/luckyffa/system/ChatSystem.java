package me.luckyffa.system;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatSystem implements CommandExecutor, Listener {

    public static boolean chat = true;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player){
            if (chat){
                chat = false;
                for (Player PO : Bukkit.getOnlinePlayers()){
                    PO.sendMessage(Main.color(Main.prefix + "&cPublic chat has been disable"));
                    TitleBar(PO, Main.color("&7Public chat"), Main.color("&chas been disable"), 2);
                    PO.playSound(PO.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                }
            }else{
                chat = true;
                for (Player PO : Bukkit.getOnlinePlayers()){
                    PO.sendMessage(Main.color(Main.prefix + "&aPublic chat has been enable"));
                    TitleBar(PO, Main.color("&7Public chat"), Main.color("&ahas been enable"), 2);
                }
            }
        }
        return false;
    }
    @EventHandler
    public void onChatSystem(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String m = e.getMessage();
        if (!ChatSystem.chat) {
            if (p.hasPermission("public.chat.system")) {
                for (Player OnlinePlayer : Bukkit.getOnlinePlayers()) {
                    OnlinePlayer.sendMessage(Main.color("&7[ &4&lZ O T A X &7] : &c&n" + m));
                    OnlinePlayer.playSound(OnlinePlayer.getLocation(), Sound.NOTE_BASS, 1, 1);
                }
                e.setCancelled(true);
                return;
            } else {
                p.sendMessage(Main.color(Main.prefix + "&cPublic chat has disable"));
                p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
                e.setCancelled(true);
            }
        }
    }
    public void TitleBar(Player player, String title, String subtitle, int seconds) {
        IChatBaseComponent title_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\",\"color\": \"dark_red\"}");
        IChatBaseComponent subtitle_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");

        PacketPlayOutTitle title_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title_component, 20, seconds * 20, 20);
        PacketPlayOutTitle subtitle_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitle_component, 50, seconds * 100, 50);

        CraftPlayer cPlayer = (CraftPlayer) player;
        cPlayer.getHandle().playerConnection.sendPacket(title_packet);
        cPlayer.getHandle().playerConnection.sendPacket(subtitle_packet);
    }
}
