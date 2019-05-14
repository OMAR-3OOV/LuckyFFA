package me.luckyffa.ServerEvent;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public class Respawn implements Listener {

    private Main plugin;
    public Respawn(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        Player k = p.getKiller();

        TitleBar(p, Main.color("&cYou deid"), Main.color("&3" + k.getName() +" &7has kill you"), 5);

             final ItemStack Kits = new ItemStack(Material.NETHER_STAR);
             final ItemMeta metaKits = Kits.getItemMeta();
             metaKits.setDisplayName(Main.color("&bKits"));
             Kits.setItemMeta(metaKits);

             final ItemStack StaffItemJoin = new ItemStack(Material.PAPER);
             final ItemMeta metaStaffItemJoin = StaffItemJoin.getItemMeta();
             metaStaffItemJoin.setDisplayName(Main.color("&cStaffMOD"));
             StaffItemJoin.setItemMeta(metaStaffItemJoin);

                File file = new File("plugins//LuckyFFASpawn//spawn.yml");
                if(!file.exists()){
                    return;
                }

                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                Location loc = p.getLocation();
                double x = cfg.getDouble("X");
                double y = cfg.getDouble("Y");
                double z = cfg.getDouble("Z");
                double yaw = cfg.getDouble("Yaw");
                double pitch = cfg.getDouble("Pitch");
                String worldname = cfg.getString("Worldname");

                World welt = Bukkit.getWorld(worldname);

                loc.setX(x);
                loc.setY(y);
                loc.setZ(z);
                loc.setYaw((float) yaw);
                loc.setPitch((float) pitch);
                loc.setWorld(welt);

                e.setRespawnLocation(loc);
                p.getInventory().setItem(4, Kits);
                if(p.hasPermission("luckyffa.staff.mod.item.join")) {
                    p.getInventory().setItem(1, StaffItemJoin);
                }
    }

    public void TitleBar(Player player, String title, String subtitle, int seconds) {
        IChatBaseComponent title_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\",\"color\": \"dark_red\"}");
        IChatBaseComponent subtitle_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");

        PacketPlayOutTitle title_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title_component, 20, seconds*20, 20);
        PacketPlayOutTitle subtitle_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitle_component, 50, seconds*100, 50);

        CraftPlayer cPlayer = (CraftPlayer) player;
        cPlayer.getHandle().playerConnection.sendPacket(title_packet);
        cPlayer.getHandle().playerConnection.sendPacket(subtitle_packet);
    }
}
