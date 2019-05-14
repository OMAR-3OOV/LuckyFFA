package me.luckyffa.system.kits;

import me.luckyffa.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryKitsEvent implements Listener {

    @EventHandler
    public void onPlayInvent(InventoryClickEvent e) {
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&cClose"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.FUSE, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bYou Informations"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bComments"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bShop"))) {
                        Player p = (Player) e.getWhoClicked();
                        p.closeInventory();
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bInfo"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&9Member Kit"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.performCommand("kit member");
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&aVip Kit"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.performCommand("kit vip");
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&aVip&6+ &aKit"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.performCommand("kit vip+");
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&6Gold Kit"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.performCommand("kit gold");
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&cClear Kit"))) {
                        Player p = (Player) e.getWhoClicked();

                        final ItemStack Kits = new ItemStack(Material.NETHER_STAR);
                        final ItemMeta metaKits = Kits.getItemMeta();
                        metaKits.setDisplayName(Main.color("&bKits"));
                        Kits.setItemMeta(metaKits);

                        p.performCommand("kit Clear");
                        p.getInventory().setItem(4, Kits);
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }

                }

            }

        }
        if(e.getInventory().getTitle().equals(Main.color("&eLuckyFFA &cKits"))){
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.color("&bDiamond Kit"))) {
                        Player p = (Player) e.getWhoClicked();

                        p.performCommand("kit Diamond");
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5, 5);
                        e.setCancelled(true);
                    }
                }
            }
            e.setCancelled(true);
        }
    }

}
