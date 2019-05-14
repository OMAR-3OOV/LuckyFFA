package me.luckyffa.system_duel;

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
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class duelsystem implements CommandExecutor, Listener {

    private Map<Player, Player> players = new HashMap<>();

    private Main plugin;
    public duelsystem(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            sender.sendMessage(Main.color(Main.duel + "&c/duel <user>"));

            if (args.length >= 0) {
                if (args[0].equals("setspawn1")) {
                    if (!(sender instanceof Player)) {
                        System.out.println(Main.color("&6Are you retarded or something ???"));

                        return true;
                    }
                    Player p = (Player) sender;

                    if (!p.hasPermission("lucky.systemspawn.set")) {
                        p.sendMessage(Main.premission);
                        return true;
                    }

                    File ordner = new File("plugins//LuckyFFAduel");
                    File file = new File("plugins//LuckyFFAduel//spawnduel1.yml");

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
                    p.sendMessage(Main.color(Main.prefix + "&bduel spawn 1 has been set"));
                }
                if (args[0].equals("spawn1")) {
                    if (!(sender instanceof Player)) {
                        System.out.println("Bist du behindert oder so ???");
                        return true;
                    }
                    Player p = (Player) sender;

                    if (!p.hasPermission("yt.spawn")) {
                        p.sendMessage("§4[Youtube]§cKeine Permission");
                        return true;
                    }

                    File file = new File("plugins//LuckyFFAduel//spawnduel1.yml");
                    if (!file.exists()) {
                        p.sendMessage(Main.color(Main.prefix + "&cError : Spawn is not set.."));
                        return true;
                    }
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    Location loc1 = p.getLocation();

                    double x = cfg.getDouble("X");
                    double y = cfg.getDouble("Y");
                    double z = cfg.getDouble("Z");
                    double yaw = cfg.getDouble("Yaw");
                    double pitch = cfg.getDouble("Pitch");
                    String worldname = cfg.getString("Worldname");

                    World welt = Bukkit.getWorld(worldname);

                    loc1.setX(x);
                    loc1.setY(y);
                    loc1.setZ(z);
                    loc1.setYaw((float) yaw);
                    loc1.setPitch((float) pitch);
                    loc1.setWorld(welt);

                    p.teleport(loc1);
                    p.sendMessage(Main.color(" "));
                }
                if (args[0].equals("setspawn2")) {
                    if (!(sender instanceof Player)) {
                        System.out.println(Main.color("&6Are you retarded or something ???"));

                        return true;
                    }
                    Player p = (Player) sender;

                    if (!p.hasPermission("lucky.systemspawn2.set")) {
                        p.sendMessage(Main.premission);
                        return true;
                    }

                    File ordner = new File("plugins//LuckyFFAduel2");
                    File file = new File("plugins//LuckyFFAduel2//spawnduel2.yml");

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
                    p.sendMessage(Main.color(Main.prefix + "&bduel spawn 2 has been set"));
                }
                if (args[0].equals("spawn2")) {
                    if (!(sender instanceof Player)) {
                        System.out.println("Bist du behindert oder so ???");
                        return true;
                    }
                    Player p = (Player) sender;

                    if (!p.hasPermission("yt.spawn")) {
                        p.sendMessage("§4[Youtube]§cKeine Permission");
                        return true;
                    }

                    File file = new File("plugins//LuckyFFAduel2//spawnduel2.yml");
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
                    p.sendMessage(Main.color(""));
                }
            }

            if (args[0].equals("setspawnlobby")) {
                if (!(sender instanceof Player)) {
                    System.out.println(Main.color("&6Are you retarded or something ???"));

                    return true;
                }
                Player p = (Player) sender;

                if (!p.hasPermission("lucky.systemspawn2.set")) {
                    p.sendMessage(Main.premission);
                    return true;
                }

                File ordner = new File("plugins//LuckyFFAduellobby");
                File file = new File("plugins//LuckyFFAduellobby//spawnduellobby.yml");

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
                p.sendMessage(Main.color(Main.prefix + "&bduel spawn 2 has been set"));
            }
            if (args[0].equals("spawnlobby")) {
                if (!(sender instanceof Player)) {
                    System.out.println("Bist du behindert oder so ???");
                    return true;
                }
                Player p = (Player) sender;

                if (!p.hasPermission("yt.spawn")) {
                    p.sendMessage("§4[Youtube]§cKeine Permission");
                    return true;
                }

                File file = new File("plugins//LuckyFFAduellobby//spawnduellobby.yml");
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
                p.sendMessage(Main.color(""));
            }
        }

        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//
        //------------------//

        // -> /duel infos
        // -> /duel <player>
        // --> /duel <accept/deny>

        Player player = (Player) sender;

        // -> /duel
        if (args.length == 0) {
            player.sendMessage(Main.color(Main.duel + "&e/&cduel &e< &cplayer &e>"));
            player.sendMessage(Main.color(Main.duel + "&e/&cduel &e< &caccept&e/&cdeny &e>"));
            return true;
        }

        //-> /duel <player>
        if (args.length == 1) {

            if (args[0].equals("accept")) {
                if (players.containsKey(player)) {

                    Player firstPlayerTarget = players.get(player);
                    firstPlayerTarget.sendMessage(Main.color(Main.duel + "&cFight...!"));
                    File file2 = new File("plugins//LuckyFFAduellobby//spawnduellobby.yml");
                    if (!file2.exists()) {
                        player.sendMessage(Main.color(Main.prefix + "&cError : Spawn is not set.."));
                        return true;
                    }
                    YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
                    Location loc2 = player.getLocation();

                    double x2 = cfg2.getDouble("X");
                    double y2 = cfg2.getDouble("Y");
                    double z2 = cfg2.getDouble("Z");
                    double yaw2 = cfg2.getDouble("Yaw");
                    double pitch2 = cfg2.getDouble("Pitch");
                    String worldname2 = cfg2.getString("Worldname");

                    World welt2 = Bukkit.getWorld(worldname2);

                    loc2.setX(x2);
                    loc2.setY(y2);
                    loc2.setZ(z2);
                    loc2.setYaw((float) yaw2);
                    loc2.setPitch((float) pitch2);
                    loc2.setWorld(welt2);

                    File file = new File("plugins//LuckyFFAduel//spawnduel1.yml");
                    if (!file.exists()) {
                        player.sendMessage(Main.color(Main.prefix + "&cError : Spawn is not set.."));
                        return true;
                    }
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    Location loc = player.getLocation();

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

                    File file1 = new File("plugins//LuckyFFAduel2//spawnduel2.yml");
                    if (!file1.exists()) {
                        player.sendMessage(Main.color(Main.prefix + "&cError : Spawn is not set.."));
                        return true;
                    }
                    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
                    Location loc1 = player.getLocation();

                    double x1 = cfg1.getDouble("X");
                    double y1 = cfg1.getDouble("Y");
                    double z1 = cfg1.getDouble("Z");
                    double yaw1 = cfg1.getDouble("Yaw");
                    double pitch1 = cfg1.getDouble("Pitch");
                    String worldname1 = cfg1.getString("Worldname");

                    World welt1 = Bukkit.getWorld(worldname1);

                    loc1.setX(x1);
                    loc1.setY(y1);
                    loc1.setZ(z1);
                    loc1.setYaw((float) yaw1);
                    loc1.setPitch((float) pitch1);
                    loc1.setWorld(welt1);

                    /*/ telport /*/

                    player.getInventory().clear();
                    firstPlayerTarget.getInventory().clear();
                    player.teleport(loc2);
                    firstPlayerTarget.teleport(loc2);

                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        player.sendMessage(Main.color(Main.duel + "&cFight...!"));
                        player.getInventory().clear();
                        firstPlayerTarget.getInventory().clear();
                        player.teleport(loc1);
                        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        player.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
                        player.getInventory().setItem(1, new ItemStack(Material.FISHING_ROD));
                        player.getInventory().setItem(4, new ItemStack(Material.getMaterial(364), 64));
                        firstPlayerTarget.sendMessage(Main.color(Main.duel + "&cFight...!"));
                        firstPlayerTarget.teleport(loc);
                        firstPlayerTarget.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        firstPlayerTarget.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                        firstPlayerTarget.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                        firstPlayerTarget.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        firstPlayerTarget.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
                        firstPlayerTarget.getInventory().setItem(1, new ItemStack(Material.FISHING_ROD));
                        firstPlayerTarget.getInventory().setItem(4, new ItemStack(Material.getMaterial(364), 64));
                        players.remove(player);
                    }, 120);
                }
            } else if (args[0].equals("deny")) {
                if (players.containsKey(player)) {
                    player.sendMessage(Main.color(Main.duel + "&eYou deny this duel"));

                    Player firstPlayerTarget = players.get(player);
                    firstPlayerTarget.sendMessage(Main.color(Main.duel + "duel has deny"));

                    players.remove(player);
                }
            }

            String targetName = args[0];
            Player t = Bukkit.getPlayer(args[0]);

            if (t != null) {
                if (player.getName() != t.getName()) {
                    Player target = Bukkit.getPlayer(targetName);
                    if (players.containsKey(target)) {
                        player.sendMessage(Main.color(Main.duel + "&eYou already duel " + target.getName()));
                        return true;
                    }

                    players.put(target, player);
                    player.sendMessage(Main.color(Main.duel + "&eYou duel has successfuly send to" + targetName));
                    target.sendMessage(Main.color(Main.duel + "&c" + player.getName() + " &esend to you a duel"));
                } else {
                    sender.sendMessage(Main.color(Main.duel + "&eYou can duel yourself"));
                }
            } else {
                player.sendMessage(Main.color("this player is not online in the server"));
            }
        }
        return false;
    }
}
