package me.luckyffa.ServerEvent;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;


public class DeidEvent implements Listener {

    public HashMap<String, Integer> killstreak = new HashMap<String, Integer>();
    public int killamount = 0;

    @EventHandler
    public void ondeid(PlayerDeathEvent e){
        Player player = e.getEntity().getPlayer();
        Player killer = e.getEntity().getKiller();

        /*/ Player Tip /*/

        player.getInventory().clear();
        TitleBar(player, Main.color("&c-") , " ", 2);

        /*/ Killer Tip /*/

        killer.giveExp(500);

        killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*10, 5));
        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*10, 1));

        if (killamount == 0){
            killamount++;
            killamount++;
        }else{
        }

        e.setDeathMessage(Main.color(Main.prefix + "&c" + player.getName() + " &ewas killed by &c" + killer.getName()));
        e.getDrops().clear();

        TitleBar(killer, Main.color("&a+") , " ", 2);

        /*/ KillStreak System /*/

            if (e.getEntity().getKiller() instanceof Player) {

                if (!killstreak.containsKey(killer.getName())) killstreak.put(player.getKiller().getName(), 0);
                killstreak.put(player.getKiller().getName(), killstreak.get(player.getKiller().getName() + 1));

                if (killstreak.containsKey(killer.getName()))
                    killstreak.put(player.getKiller().getName(), killstreak.get(player.getKiller().getName() + 1));
                if (killstreak.containsKey(player.getName())) killstreak.remove(player.getName());

                if (killstreak.get(player.getKiller().getName()) == 3) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 3 killstreaks!"));
                        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 5 * 5));
                        all.playSound(killer.getLocation(), Sound.LEVEL_UP, 1, 1);
                    }
                } else {
                    if (killstreak.get(player.getKiller().getName()) == 5) {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 5 killstreaks!"));
                            killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 5 * 10));
                            all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                        }
                    } else {
                        if (killstreak.get(player.getKiller().getName()) == 10) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 10 killstreaks!"));
                                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 7 * 11));
                                item(Material.GOLDEN_APPLE, 1, Main.color("&5GOLDEN APPLE"));
                                all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                            }
                        } else {
                            if (killstreak.get(player.getKiller().getName()) == 15) {
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 15 killstreaks!"));
                                    killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2, 10 * 17));
                                    killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1, 5 * 5));
                                    item(Material.GOLDEN_APPLE, 1, Main.color("&5GOLDEN APPLE"));
                                    all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                }
                            } else {
                                if (killstreak.get(player.getKiller().getName()) == 20) {
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 20 killstreaks!"));
                                        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2, 10 * 20));
                                        killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1, 5 * 8));
                                        item(Material.GOLDEN_APPLE, 2, Main.color("&5GOLDEN APPLE"));
                                        all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                    }
                                } else {
                                    if (killstreak.get(player.getKiller().getName()) == 25) {
                                        for (Player all : Bukkit.getOnlinePlayers()) {
                                            all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 25 killstreaks!"));
                                            killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2, 16 * 20));
                                            killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2, 5 * 10));
                                            item(Material.GOLDEN_APPLE, 2, Main.color("&5GOLDEN APPLE"));
                                            all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                        }
                                    } else {
                                        if (killstreak.get(player.getKiller().getName()) == 30) {
                                            for (Player all : Bukkit.getOnlinePlayers()) {
                                                all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 30 killstreaks!"));
                                                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, 19 * 20));
                                                killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2, 5 * 15));
                                                item(Material.GOLDEN_APPLE, 3, Main.color("&5GOLDEN APPLE"));
                                                all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                            }
                                        } else {
                                            if (killstreak.get(player.getKiller().getName()) == 35) {
                                                for (Player all : Bukkit.getOnlinePlayers()) {
                                                    all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 35 killstreaks!"));
                                                    killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, 20 * 25));
                                                    killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 10 * 15));
                                                    item(Material.GOLDEN_APPLE, 3, Main.color("&5GOLDEN APPLE"));
                                                    all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                }
                                            } else {
                                                if (killstreak.get(player.getKiller().getName()) == 40) {
                                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 40 killstreaks!"));
                                                        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 4, 25 * 25));
                                                        killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 15 * 15));
                                                        item(Material.GOLDEN_APPLE, 4, Main.color("&5GOLDEN APPLE"));
                                                        all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                    }
                                                } else {
                                                    if (killstreak.get(player.getKiller().getName()) == 45) {
                                                        for (Player all : Bukkit.getOnlinePlayers()) {
                                                            all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 45 killstreaks!"));
                                                            killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 4, 25 * 25));
                                                            killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 15 * 15));
                                                            item(Material.GOLDEN_APPLE, 4, Main.color("&5GOLDEN APPLE"));
                                                            all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                        }
                                                    } else {
                                                        if (killstreak.get(player.getKiller().getName()) == 50) {
                                                            for (Player all : Bukkit.getOnlinePlayers()) {
                                                                all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 50 killstreaks!"));
                                                                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 25 * 25));
                                                                killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 4, 15 * 15));
                                                                item(Material.GOLDEN_APPLE, 5, Main.color("&5GOLDEN APPLE"));
                                                                all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                            }
                                                        } else {
                                                            if (killstreak.get(player.getKiller().getName()) == 55) {
                                                                for (Player all : Bukkit.getOnlinePlayers()) {
                                                                    all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 55 killstreaks!"));
                                                                    all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                }
                                                            } else {
                                                                if (killstreak.get(player.getKiller().getName()) == 60) {
                                                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                                                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 60 killstreaks!"));
                                                                        all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                    }
                                                                } else {
                                                                    if (killstreak.get(player.getKiller().getName()) == 65) {
                                                                        for (Player all : Bukkit.getOnlinePlayers()) {
                                                                            all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 65 killstreaks!"));
                                                                            all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                        }
                                                                    } else {
                                                                        if (killstreak.get(player.getKiller().getName()) == 70) {
                                                                            for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 70 killstreaks!"));
                                                                                all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                            }
                                                                        } else {
                                                                            if (killstreak.get(player.getKiller().getName()) == 75) {
                                                                                for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                    all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 75 killstreaks!"));
                                                                                    all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                                }
                                                                            } else {
                                                                                if (killstreak.get(player.getKiller().getName()) == 80) {
                                                                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 80 killstreaks!"));
                                                                                        all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                                    }
                                                                                } else {
                                                                                    if (killstreak.get(player.getKiller().getName()) == 85) {
                                                                                        for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                            all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 85 killstreaks!"));
                                                                                            all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                                        }
                                                                                    } else {
                                                                                        if (killstreak.get(player.getKiller().getName()) == 90) {
                                                                                            for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                                all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 90 killstreaks!"));
                                                                                                all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                                            }
                                                                                        } else {
                                                                                            if (killstreak.get(player.getKiller().getName()) == 95) {
                                                                                                for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                                    all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 95 killstreaks!"));
                                                                                                    all.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                                                                                                }
                                                                                            } else {
                                                                                                if (killstreak.get(player.getKiller().getName()) == 100) {
                                                                                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                                                                                        all.sendMessage(Main.color("&c" + killer.getName() + " &ehave 100 killstreaks!"));
                                                                                                        killer.kickPlayer(Main.color("&6&lO P &eLuckyFFA\n \n&eYou have &6100 KillStreak\n \n&eYou get a King to server Rank &7+ &e100KillStreak &c[tag]"));
                                                                                                        all.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 5);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
    }
        private ItemStack item (Material ItemMaterial, int amount, String itemname){

            ItemStack item = new ItemStack(ItemMaterial, amount);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(itemname);

            return item;
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
