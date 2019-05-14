package me.luckyffa.system.LS;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;

public class LuckyBlockSystem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length >= 0) {
            Player p = (Player) sender;
            if (p.hasPermission("luckyffa.system.*")) {
                if (args[0].equals("give")) {
                    if (args.length != 1) {
                        if (args[1].equals("LuckyBlock")) {

                            ItemStack LuckyBlock = new ItemStack(Material.SPONGE);
                            ItemMeta MetaLuckyBlock = LuckyBlock.getItemMeta();
                            MetaLuckyBlock.setDisplayName(Main.color("&eLucky&6Block"));
                            LuckyBlock.setItemMeta(MetaLuckyBlock);

                            p.getInventory().addItem(LuckyBlock);
                        }
                    }
                }
            }
            if (args[0].equals("setspawn")) {
                if (!(sender instanceof Player)) {
                    System.out.println(Main.color("&6Are you retarded or something ???"));

                    return true;
                }

                if (!p.hasPermission("lucky.systemspawn.set")) {
                    p.sendMessage(Main.premission);
                    return true;
                }

                File ordner = new File("plugins//LuckyFFASpawn");
                File file = new File("plugins//LuckyFFASpawn//spawn.yml");

                if (!ordner.exists()) {
                    ordner.mkdir();
                }
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        p.sendMessage(Main.color(Main.prefix + "&eThe file could not be created on the path"));
                    }
                }

                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                Location loc = p.getLocation();

                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                double yaw = loc.getYaw();
                double pitch = loc.getPitch();
                String worldname = loc.getWorld().getName();

                cfg.set("X", x);
                cfg.set("Y", y);
                cfg.set("Z", z);
                cfg.set("Yaw", yaw);
                cfg.set("Pitch", pitch);
                cfg.set("Worldname", worldname);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(Main.color(Main.prefix + "&bSpawn has been set"));
            }
            if (args[0].equals("spawn")) {
                if (!(sender instanceof Player)) {
                    System.out.println("Bist du behindert oder so ???");
                    return true;
                }

                if (!p.hasPermission("yt.spawn")) {
                    p.sendMessage("§4[Youtube]§cKeine Permission");
                    return true;
                }

                File file = new File("plugins//LuckyFFASpawn//spawn.yml");
                if (!file.exists()) {
                    p.sendMessage(Main.color(Main.prefix + "&cError : Spawn is not set.."));
                    return true;
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

                p.teleport(loc);
                p.sendMessage(Main.color(Main.prefix + "&eYou move to spawn"));
            }
        }else{
            sender.sendMessage(Main.premission);
        }
        return false;
    }
}
