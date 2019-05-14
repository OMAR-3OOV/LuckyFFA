package me.luckyffa.ServerEvent;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        final ItemStack ItemKits = new ItemStack(Material.NETHER_STAR);
        final ItemMeta metaKits = ItemKits.getItemMeta();
        metaKits.setDisplayName(Main.color("&bKits"));
        ItemKits.setItemMeta(metaKits);

        final ItemStack StaffItemJoin = new ItemStack(Material.PAPER);
        final ItemMeta metaStaffItemJoin = StaffItemJoin.getItemMeta();
        metaStaffItemJoin.setDisplayName(Main.color("&cPrivateKits"));
        StaffItemJoin.setItemMeta(metaStaffItemJoin);

            e.setJoinMessage(null);
            p.sendMessage(Main.color("&9&lDiscord :&f https://discord.gg/zFMm8Wj"));
            p.getInventory().clear();
            if (p.hasPermission("staff.join")) {
                e.setJoinMessage(Main.color("&c>&a> &e" + p.getName() + " &6has join to server &a<&c<"));
                p.getInventory().setItem(2, StaffItemJoin);
                for (Player online : Bukkit.getOnlinePlayers()) {
                    p.playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 4);
                    online.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 5, 3);
                }
        }else {
            e.setJoinMessage(Main.color(Main.Join + "&c" + p.getName() + " " + "&ehas been join to FFA..!"));
            p.playSound(((Player) p).getLocation(), Sound.CAT_MEOW, 1, 1);
        }
            displayTitleBar(p, Main.color("&eLucky&6FFA"), Main.color("&fhave fine"), 5);
            p.getInventory().setItem(4, ItemKits);
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

    @EventHandler
    public void onClickItemHand(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem().getItemMeta() != null) {
                if(e.getItem().getItemMeta().getDisplayName() != null) {
                    if(e.getItem().getItemMeta().getDisplayName().equals(Main.color("&bKits"))) {
                        p.performCommand("kits");
                        p.playSound(p.getLocation(), Sound.CAT_MEOW ,1 , 1);
                        e.setCancelled(true);
                    }
                }
            }
        }
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem().getItemMeta() != null) {
                if(e.getItem().getItemMeta().getDisplayName() != null) {
                    if(e.getItem().getItemMeta().getDisplayName().equals(Main.color("&cPrivateKits"))) {
                        p.performCommand("pk");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
