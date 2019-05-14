package me.luckyffa.system.kits;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PrivateKit implements CommandExecutor, Listener {

    private Main plugin;
    public PrivateKit(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    Inventory PrivateKits = Bukkit.createInventory(null, 54, Main.color("&ePrivate &6Kits"));
    private List<Player> Cooldownvip = new ArrayList<>();
    private List<Player> Cooldownvip2 = new ArrayList<>();
    private List<Player> Cooldowngold = new ArrayList<>();
    private List<Player> Cooldowndiamond = new ArrayList<>();
    private List<Player> Cooldownsuper = new ArrayList<>();
    private List<Player> Cooldownking = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)){
            ConsoleCommandSender c = (ConsoleCommandSender) sender;
            c.sendMessage(Main.color(Main.prefix + "&cOnly Player can use this command"));
        }
        if (args.length == 0){
            if (p.hasPermission("rank.privatekit.inventory")){
                    p.openInventory(PrivateKits);
                    PrivateKits.clear();

                    ItemStack desgin1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                    ItemMeta meta1 = desgin1.getItemMeta();
                    meta1.setDisplayName(Main.color("&ePrivateKit"));
                    desgin1.setItemMeta(meta1);

                    ItemStack desgin2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                    ItemMeta meta2 = desgin2.getItemMeta();
                    meta2.setDisplayName(Main.color("&cYou dont have this kit"));
                    desgin2.setItemMeta(meta2);

                    ItemStack desgin3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
                    ItemMeta meta3 = desgin3.getItemMeta();
                    meta3.setDisplayName(Main.color("&ePrivateKit"));
                    desgin3.setItemMeta(meta3);

                    ItemStack vip = new ItemStack(Material.IRON_BLOCK, 1);
                    ItemMeta metavip = vip.getItemMeta();
                    metavip.setDisplayName(Main.color("&aVIP"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("&cYou can use it &a1 &ctime in the day!");
                    lore.add("");
                    lore.add("&bClick to use kit");
                    vip.setItemMeta(metavip);

                    ItemStack vip2 = new ItemStack(Material.REDSTONE_BLOCK, 1);
                    ItemMeta metavip2 = vip2.getItemMeta();
                    metavip2.setDisplayName(Main.color("&aVIP&6+"));
                    ArrayList<String> lore1 = new ArrayList<>();
                    lore1.add("");
                    lore1.add("&cYou can use it &a1 &ctime in the day!");
                    lore1.add("");
                    lore1.add("&bClick to use kit");
                    vip2.setItemMeta(metavip2);

                    ItemStack gold = new ItemStack(Material.GOLD_BLOCK, 1);
                    ItemMeta metagold = desgin1.getItemMeta();
                    metagold.setDisplayName(Main.color("&6GOLD"));
                    ArrayList<String> lore2 = new ArrayList<>();
                    lore2.add("");
                    lore2.add("&cYou can use it &a1 &ctime in the day!");
                    lore2.add("");
                    lore2.add("&bClick to use kit");
                    gold.setItemMeta(metagold);

                    ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
                    ItemMeta metadiamond = diamond.getItemMeta();
                    metadiamond.setDisplayName(Main.color("&bDIAMOND"));
                    ArrayList<String> lore3 = new ArrayList<>();
                    lore3.add("");
                    lore3.add("&cYou can use it &a1 &ctime in the day!");
                    lore3.add("");
                    lore3.add("&bClick to use kit");
                    diamond.setItemMeta(metadiamond);

                    ItemStack Super = new ItemStack(Material.LAPIS_BLOCK, 1);
                    ItemMeta metaSuper = Super.getItemMeta();
                    metaSuper.setDisplayName(Main.color("&9SUPER"));
                    ArrayList<String> lore4 = new ArrayList<>();
                    lore4.add("");
                    lore4.add("&cYou can use it &a1 &ctime in the day!");
                    lore4.add("");
                    lore4.add("&bClick to use kit");
                    Super.setItemMeta(metaSuper);

                    ItemStack king = new ItemStack(Material.EMERALD_BLOCK, 1);
                    ItemMeta metaking = king.getItemMeta();
                    metaking.setDisplayName(Main.color("&eKING"));
                    ArrayList<String> lore5 = new ArrayList<>();
                    lore5.add("");
                    lore5.add("&cYou can use it &a1 &ctime in the day!");
                    lore5.add("");
                    lore5.add("&bClick to use kit");
                    king.setItemMeta(metaking);

                    ItemStack close = new ItemStack(Material.BARRIER, 1);
                    ItemMeta metaclose = close.getItemMeta();
                    metaclose.setDisplayName(Main.color("&cClose"));
                    close.setItemMeta(metaclose);

                    /*/ Kits /*/
                    if (p.hasPermission("vip.viwes")) {
                        PrivateKits.setItem(10, vip);
                    }else{
                        PrivateKits.setItem(10, desgin2);
                    }
                    if (p.hasPermission("vip2.viwes")) {
                        PrivateKits.setItem(11, vip2);
                    }else{
                        PrivateKits.setItem(11, desgin2);
                    }
                    if (p.hasPermission("gold.viwes")) {
                        PrivateKits.setItem(12, gold);
                    }else{
                        PrivateKits.setItem(12, desgin2);
                    }
                    if (p.hasPermission("diamond.viwes")) {
                        PrivateKits.setItem(13, diamond);
                    }else{
                        PrivateKits.setItem(13, desgin2);
                    }
                    if (p.hasPermission("super.viwes")) {
                        PrivateKits.setItem(14, Super);
                    }else{
                        PrivateKits.setItem(14, desgin2);
                    }
                    if (p.hasPermission("king.viwes")) {
                        PrivateKits.setItem(15, king);
                    }else{
                        PrivateKits.setItem(15, desgin2);
                    }

                    /*/ Addons /*/
                    PrivateKits.setItem(49, close);

                    /*/ Desgin /*/
                    PrivateKits.setItem(16, desgin2);
                    PrivateKits.setItem(17, desgin2);
                    PrivateKits.setItem(19, desgin2);
                    PrivateKits.setItem(20, desgin2);
                    PrivateKits.setItem(21, desgin2);
                    PrivateKits.setItem(22, desgin2);
                    PrivateKits.setItem(23, desgin2);
                    PrivateKits.setItem(24, desgin2);
                    PrivateKits.setItem(25, desgin2);
                    PrivateKits.setItem(28, desgin2);
                    PrivateKits.setItem(29, desgin2);
                    PrivateKits.setItem(30, desgin2);
                    PrivateKits.setItem(31, desgin2);
                    PrivateKits.setItem(32, desgin2);
                    PrivateKits.setItem(33, desgin2);
                    PrivateKits.setItem(34, desgin2);
                    PrivateKits.setItem(37, desgin2);
                    PrivateKits.setItem(38, desgin2);
                    PrivateKits.setItem(39, desgin2);
                    PrivateKits.setItem(40, desgin2);
                    PrivateKits.setItem(41, desgin2);
                    PrivateKits.setItem(42, desgin2);
                    PrivateKits.setItem(43, desgin2);

                    PrivateKits.setItem(2, desgin3);
                    PrivateKits.setItem(3, desgin3);
                    PrivateKits.setItem(4, desgin3);
                    PrivateKits.setItem(5, desgin3);
                    PrivateKits.setItem(6, desgin3);
                    PrivateKits.setItem(47, desgin3);
                    PrivateKits.setItem(48, desgin3);
                    PrivateKits.setItem(50, desgin3);
                    PrivateKits.setItem(51, desgin3);

                    PrivateKits.setItem(0, desgin1);
                    PrivateKits.setItem(1, desgin1);
                    PrivateKits.setItem(7, desgin1);
                    PrivateKits.setItem(8, desgin1);
                    PrivateKits.setItem(9, desgin1);
                    PrivateKits.setItem(17, desgin1);
                    PrivateKits.setItem(18, desgin1);
                    PrivateKits.setItem(26, desgin1);
                    PrivateKits.setItem(27, desgin1);
                    PrivateKits.setItem(35, desgin1);
                    PrivateKits.setItem(36, desgin1);
                    PrivateKits.setItem(44, desgin1);
                    PrivateKits.setItem(45, desgin1);
                    PrivateKits.setItem(46, desgin1);
                    PrivateKits.setItem(52, desgin1);
                    PrivateKits.setItem(53, desgin1);
            }else {
                p.sendMessage(Main.premission);
            }
        }
        return false;
    }
    @EventHandler
    public void onClickInvenotory(InventoryClickEvent e){
        if(e.getInventory().getTitle().equals(Main.color("&ePrivate &6Kits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&aVIP"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldownvip.contains(p)) {

                            Cooldownvip.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldownvip.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&aVIP&6+"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldownvip2.contains(p)) {

                            Cooldownvip2.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldownvip2.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&6GOLD"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldowngold.contains(p)) {

                            Cooldowngold.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldowngold.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bDIAMOND"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldowndiamond.contains(p)) {

                            Cooldowndiamond.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldowndiamond.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&9SUPER"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldownsuper.contains(p)) {

                            Cooldownsuper.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldownsuper.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&eKING"))) {
                        Player p = (Player) e.getWhoClicked();
                        if (!Cooldownking.contains(p)) {

                            Cooldownking.add(p);
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                Cooldownking.remove(p);
                            }, 60*60);
                        }else{
                            p.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1hours"));
                        }
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&cClose"))) {
                        Player p = (Player) e.getWhoClicked();
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1 , 1);
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&ePrivateKit"))) {
                        Player p = (Player) e.getWhoClicked();
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
                        e.setCancelled(true);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&cYou dont have this kit"))) {
                        Player p = (Player) e.getWhoClicked();
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
                        e.setCancelled(true);
                    }
                }
            }
            e.setCancelled(true);
        }
    }
}
