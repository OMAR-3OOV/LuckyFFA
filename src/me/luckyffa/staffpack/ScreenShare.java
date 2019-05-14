package me.luckyffa.staffpack;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ScreenShare implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        ItemStack freezenHelmat = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta metaFreezen = freezenHelmat.getItemMeta();
        metaFreezen.setDisplayName(Main.color(Main.prefix + "&eYou are freezen"));
        freezenHelmat.setItemMeta(metaFreezen);

        ItemStack Warning = new ItemStack(Material.PAPER);
        ItemMeta metaWarning = Warning.getItemMeta();
        metaWarning.setDisplayName(Main.color(Main.prefix + "&eWarning"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(Main.color("&F&m&l-&c&m&l-----------------------------&f&m&L-"));
        lore.add("");
        lore.add(Main.color(Main.prefix + "&c TeamSpeak : &eServer.ip"));
        lore.add("");
        lore.add(Main.color("&F&m&l-&c&m&l-----------------------------&f&m&L-"));
        lore.add("");
        metaWarning.setLore(lore);
        Warning.setItemMeta(metaWarning);

        if(player.hasPermission("temple.screenshare.command")) {
            if(args.length == 0) {
                player.sendMessage(Main.color(Main.prefix + "&e/ss <player>..!"));
            }
        }
        if(player.hasPermission("temple.screenshare.freezen")) {
            Player p = Bukkit.getPlayer(args[0]);
            if(args.length == 1) {
                if(p != null) {

                    if(Main.screensharee.containsKey(p)) {
                        sender.sendMessage(Main.color(Main.prefix + "&eSuccessfuly UnFreeze &e" + p.getName()));

                        p.sendMessage("");
                        p.sendMessage("");
                        p.sendMessage(Main.color(Main.prefix + "&eThanks for co-operanting, you can continue player..!"));
                        p.sendMessage("");
                        p.sendMessage("");

                        Main.screensharee.remove(p);

                        p.getInventory().clear();
                        p.getInventory().setHelmet(null);
                        p.playSound(p.getLocation(), Sound.WOLF_DEATH, 6, 9);

                    }else {
                        sender.sendMessage("");
                        sender.sendMessage("");
                        sender.sendMessage(Main.color(Main.prefix + "&eSuccessfuly freezen &c" + p.getName()));
                        sender.sendMessage("");
                        sender.sendMessage("");

                        p.sendMessage("");
                        p.sendMessage("");
                        p.sendMessage(Main.color(Main.prefix + "&eYou are freezen"));
                        p.sendMessage(Main.color(Main.prefix + "&edont leave, if you leave you will get bannad"));
                        p.sendMessage("");
                        p.sendMessage("");

                        p.getInventory().clear();
                        p.getInventory().setHelmet(freezenHelmat);
                        p.getInventory().setItem(4, Warning);
                        p.getInventory().setLeggings(null);
                        p.getInventory().setChestplate(null);
                        p.getInventory().setBoots(null);

                        Main.screensharee.put(p, p.getInventory().getHelmet());

                        p.playSound(p.getLocation(), Sound.WOLF_DEATH, 6, 9);
                    }

                }else {
                    sender.sendMessage(Main.color(Main.prefix + "&ethis player is not online"));
                }
                return true;
            }
        }else {
            player.sendMessage(Main.premission);
        }
        return false;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (Main.screensharee.containsKey(p)){
            e.setTo(e.getFrom());
            p.sendMessage(Main.color("███████████"));
            p.sendMessage(Main.color("█████&c█&f█████"));
            p.sendMessage(Main.color("████&c█&0█&c█&f████"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███") + Main.color("&cYou are Freeze"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("██&c█&6█████&c█&f██") + Main.color("&7You have 5min to join Discord : https://discord.gg/zFMm8Wj"));
            p.sendMessage(Main.color("██&c█&6██&0█&6██&c█&f██"));
            p.sendMessage(Main.color("█&c█████████&f█"));
            p.sendMessage(Main.color("███████████"));
            p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (Main.screensharee.containsKey(p)){
            e.setCancelled(true);
            p.sendMessage(Main.color("███████████"));
            p.sendMessage(Main.color("█████&c█&f█████"));
            p.sendMessage(Main.color("████&c█&0█&c█&f████"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███") + Main.color("&cYou are Freeze"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("██&c█&6█████&c█&f██") + Main.color("&7You have 5min to join Discord : https://discord.gg/zFMm8Wj"));
            p.sendMessage(Main.color("██&c█&6██&0█&6██&c█&f██"));
            p.sendMessage(Main.color("█&c█████████&f█"));
            p.sendMessage(Main.color("███████████"));
            p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
        }
    }
    @EventHandler
    public void onPlane(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if (Main.screensharee.containsKey(p)){
            e.setCancelled(true);
            p.sendMessage(Main.color("███████████"));
            p.sendMessage(Main.color("█████&c█&f█████"));
            p.sendMessage(Main.color("████&c█&0█&c█&f████"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███") + Main.color("&cYou are Freeze"));
            p.sendMessage(Main.color("███&c█&6█&0█&6█&c█&f███"));
            p.sendMessage(Main.color("██&c█&6█████&c█&f██") + Main.color("&7You have 5min to join Discord : https://discord.gg/zFMm8Wj"));
            p.sendMessage(Main.color("██&c█&6██&0█&6██&c█&f██"));
            p.sendMessage(Main.color("█&c█████████&f█"));
            p.sendMessage(Main.color("███████████"));
            p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
        }
    }
    @EventHandler
    public void onhits(EntityDamageByEntityEvent e){
        if ((e.getEntity() instanceof Player)){
        Player player = (Player) e.getEntity();
            if (Main.screensharee.containsKey(player)) {
                e.setCancelled(true);
            }
        }
        if ((e.getDamager() instanceof Player)){
            Player attack = (Player) e.getDamager();
            if (Main.screensharee.containsKey(attack)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onDrops(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if (Main.screensharee.containsKey(p)){
            e.setCancelled(true);
            p.closeInventory();
        }
    }
    @EventHandler
    public void onClickInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (Main.screensharee.containsKey(p)){
            e.setCancelled(true);
        }
    }
}
