package me.luckyffa.system.kits;

import me.luckyffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class kits implements CommandExecutor {

    private List<Player> cooldownkit = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (!cooldownkit.contains(player)) {
            cooldownkit.add(player);
            if (!(sender instanceof Player)) {
                sender.sendMessage(Main.color(Main.prefix + "&eOnly player can use this commands"));
            }
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(Main.color(Main.prefix + "&eYou must need put the kit name!"));
            }
            if (p != null) {
                if (args.length == 1) {
                    if (args[0].equals("Member") || args[0].equals("member") || args[0].equals("MEMBER")) {

                        p.getInventory().clear();

                        final ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                        final ItemMeta meta = Sword.getItemMeta();
                        meta.setDisplayName(Main.color("&9Member Sword"));
                        Sword.setItemMeta(meta);

                        final ItemStack Rod = new ItemStack(Material.FISHING_ROD);
                        final ItemMeta metaRod = Rod.getItemMeta();
                        metaRod.setDisplayName(Main.color("&9Member Rod"));
                        Rod.setItemMeta(metaRod);

                        final ItemStack ChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        final ItemMeta metaChestPlate = ChestPlate.getItemMeta();
                        metaChestPlate.setDisplayName(Main.color("&9Member CHESTPLATE"));
                        ChestPlate.setItemMeta(metaChestPlate);

                        final ItemStack Helmet1 = new ItemStack(Material.LEATHER_HELMET);
                        final ItemMeta metaHelmet = Helmet1.getItemMeta();
                        metaHelmet.setDisplayName(Main.color("&9Member HelMet"));
                        Helmet1.setItemMeta(metaHelmet);

                        final ItemStack BOOTS = new ItemStack(Material.LEATHER_BOOTS);
                        final ItemMeta metaBOOTS = BOOTS.getItemMeta();
                        metaBOOTS.setDisplayName(Main.color("&9Member BOOTS"));
                        BOOTS.setItemMeta(metaBOOTS);

                        final ItemStack LEGGINGS = new ItemStack(Material.LEATHER_LEGGINGS);
                        final ItemMeta metaLEGGINGS = LEGGINGS.getItemMeta();
                        metaLEGGINGS.setDisplayName(Main.color("&9Member LEGGINGS"));
                        LEGGINGS.setItemMeta(metaLEGGINGS);

                        @SuppressWarnings("deprecation") final ItemStack SPEED = new ItemStack(Material.getMaterial(373), 1, (short) 8194);
                        final ItemMeta metaSPEED = SPEED.getItemMeta();
                        metaSPEED.setDisplayName(Main.color("&9Member SPEED"));
                        SPEED.setItemMeta(metaSPEED);

                        @SuppressWarnings("deprecation") final ItemStack FOOD = new ItemStack(Material.getMaterial(364), 64);
                        final ItemMeta metaFOOD = FOOD.getItemMeta();
                        metaFOOD.setDisplayName(Main.color("&9Member FOOD"));
                        FOOD.setItemMeta(metaFOOD);

                        p.getInventory().setItem(4, FOOD);
                        p.getInventory().setItem(0, Sword);
                        p.getInventory().setItem(1, Rod);
                        p.getInventory().setItem(8, SPEED);
                        p.getInventory().setHelmet(Helmet1);
                        p.getInventory().setChestplate(ChestPlate);
                        p.getInventory().setLeggings(LEGGINGS);
                        p.getInventory().setBoots(BOOTS);


                        p.sendMessage(Main.color(Main.prefix + "&eYou use the Member kit"));

                    } else {
                        if (args[0].equals("Vip") || args[0].equals("VIP") || args[0].equals("vip")) {
                            if (p.hasPermission("luckyffa.kits.vip.take")) {
                                p.getInventory().clear();

                                final ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                                final ItemMeta meta = Sword.getItemMeta();
                                meta.setDisplayName(Main.color("&aVip Sword"));
                                Sword.setItemMeta(meta);

                                final ItemStack Rod = new ItemStack(Material.FISHING_ROD);
                                final ItemMeta metaRod = Rod.getItemMeta();
                                metaRod.setDisplayName(Main.color("&aVip Rod"));
                                Rod.setItemMeta(metaRod);

                                final ItemStack ChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                                final ItemMeta metaChestPlate = ChestPlate.getItemMeta();
                                metaChestPlate.setDisplayName(Main.color("&aVip CHESTPLATE"));
                                ChestPlate.setItemMeta(metaChestPlate);

                                final ItemStack Helmet1 = new ItemStack(Material.CHAINMAIL_HELMET);
                                final ItemMeta metaHelmet = Helmet1.getItemMeta();
                                metaHelmet.setDisplayName(Main.color("&aVip HelMet"));
                                Helmet1.setItemMeta(metaHelmet);

                                final ItemStack BOOTS = new ItemStack(Material.CHAINMAIL_BOOTS);
                                final ItemMeta metaBOOTS = BOOTS.getItemMeta();
                                metaBOOTS.setDisplayName(Main.color("&aVip BOOTS"));
                                BOOTS.setItemMeta(metaBOOTS);

                                final ItemStack LEGGINGS = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                                final ItemMeta metaLEGGINGS = LEGGINGS.getItemMeta();
                                metaLEGGINGS.setDisplayName(Main.color("&aVip LEGGINGS"));
                                LEGGINGS.setItemMeta(metaLEGGINGS);

                                @SuppressWarnings("deprecation") final ItemStack SPEED = new ItemStack(Material.getMaterial(373), 2, (short) 8194);
                                final ItemMeta metaSPEED = SPEED.getItemMeta();
                                metaSPEED.setDisplayName(Main.color("&aVip SPEED"));
                                SPEED.setItemMeta(metaSPEED);

                                @SuppressWarnings("deprecation") final ItemStack FOOD = new ItemStack(Material.getMaterial(364), 64);
                                final ItemMeta metaFOOD = FOOD.getItemMeta();
                                metaFOOD.setDisplayName(Main.color("&aVip FOOD"));
                                FOOD.setItemMeta(metaFOOD);

                                p.getInventory().setItem(4, FOOD);
                                p.getInventory().setItem(0, Sword);
                                p.getInventory().setItem(1, Rod);
                                p.getInventory().setItem(8, SPEED);
                                p.getInventory().setHelmet(Helmet1);
                                p.getInventory().setChestplate(ChestPlate);
                                p.getInventory().setLeggings(LEGGINGS);
                                p.getInventory().setBoots(BOOTS);


                                p.sendMessage(Main.color(Main.prefix + "&eYou use the &aVip &ekit"));
                            } else {
                                p.sendMessage(Main.premission);
                            }
                        } else {
                            if (args[0].equals("Vip+") || args[0].equals("VIP+") || args[0].equals("vip+")) {
                                if (p.hasPermission("luckyffa.kits.vip2.take")) {
                                    p.getInventory().clear();

                                    final ItemStack Sword = new ItemStack(Material.IRON_SWORD);
                                    final ItemMeta meta = Sword.getItemMeta();
                                    meta.setDisplayName(Main.color("&aVIP&6+ Sword"));
                                    Sword.setItemMeta(meta);

                                    final ItemStack Rod = new ItemStack(Material.FISHING_ROD);
                                    final ItemMeta metaRod = Rod.getItemMeta();
                                    metaRod.setDisplayName(Main.color("&aVIP&6+ Rod"));
                                    Rod.setItemMeta(metaRod);

                                    final ItemStack ChestPlate = new ItemStack(Material.IRON_CHESTPLATE);
                                    final ItemMeta metaChestPlate = ChestPlate.getItemMeta();
                                    metaChestPlate.setDisplayName(Main.color("&aVIP&6+ CHESTPLATE"));
                                    ChestPlate.setItemMeta(metaChestPlate);

                                    final ItemStack Helmet1 = new ItemStack(Material.CHAINMAIL_HELMET);
                                    final ItemMeta metaHelmet = Helmet1.getItemMeta();
                                    metaHelmet.setDisplayName(Main.color("&aVIP&6+ HelMet"));
                                    Helmet1.setItemMeta(metaHelmet);

                                    final ItemStack BOOTS = new ItemStack(Material.CHAINMAIL_BOOTS);
                                    final ItemMeta metaBOOTS = BOOTS.getItemMeta();
                                    metaBOOTS.setDisplayName(Main.color("&aVIP&6+ BOOTS"));
                                    BOOTS.setItemMeta(metaBOOTS);

                                    final ItemStack LEGGINGS = new ItemStack(Material.IRON_LEGGINGS);
                                    final ItemMeta metaLEGGINGS = LEGGINGS.getItemMeta();
                                    metaLEGGINGS.setDisplayName(Main.color("&aVIP&6+ LEGGINGS"));
                                    LEGGINGS.setItemMeta(metaLEGGINGS);

                                    @SuppressWarnings("deprecation") final ItemStack SPEED = new ItemStack(Material.getMaterial(373), 3, (short) 8194);
                                    final ItemMeta metaSPEED = SPEED.getItemMeta();
                                    metaSPEED.setDisplayName(Main.color("&aVIP&6+ SPEED"));
                                    SPEED.setItemMeta(metaSPEED);

                                    @SuppressWarnings("deprecation") final ItemStack FOOD = new ItemStack(Material.getMaterial(364), 64);
                                    final ItemMeta metaFOOD = FOOD.getItemMeta();
                                    metaFOOD.setDisplayName(Main.color("&aVIP&6+ FOOD"));
                                    FOOD.setItemMeta(metaFOOD);

                                    p.getInventory().setItem(4, FOOD);
                                    p.getInventory().setItem(0, Sword);
                                    p.getInventory().setItem(1, Rod);
                                    p.getInventory().setItem(8, SPEED);
                                    p.getInventory().setHelmet(Helmet1);
                                    p.getInventory().setChestplate(ChestPlate);
                                    p.getInventory().setLeggings(LEGGINGS);
                                    p.getInventory().setBoots(BOOTS);


                                    p.sendMessage(Main.color(Main.prefix + "&eYou use the &aVip&6+ &ekit"));
                                } else {
                                    p.sendMessage(Main.premission);
                                }
                            } else {
                                if (args[0].equals("Gold") || args[0].equals("gold") || args[0].equals("GOLD")) {
                                    if (p.hasPermission("luckyffa.kits.gold.take")) {
                                        p.getInventory().clear();

                                        final ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
                                        final ItemMeta meta = Sword.getItemMeta();
                                        meta.setDisplayName(Main.color("&6Gold Sword"));
                                        Sword.setItemMeta(meta);

                                        final ItemStack Rod = new ItemStack(Material.FISHING_ROD);
                                        final ItemMeta metaRod = Rod.getItemMeta();
                                        metaRod.setDisplayName(Main.color("&6Gold Rod"));
                                        Rod.setItemMeta(metaRod);

                                        final ItemStack ChestPlate = new ItemStack(Material.IRON_CHESTPLATE);
                                        final ItemMeta metaChestPlate = ChestPlate.getItemMeta();
                                        metaChestPlate.setDisplayName(Main.color("&6Gold CHESTPLATE"));
                                        ChestPlate.setItemMeta(metaChestPlate);

                                        final ItemStack Helmet1 = new ItemStack(Material.DIAMOND_HELMET);
                                        final ItemMeta metaHelmet = Helmet1.getItemMeta();
                                        metaHelmet.setDisplayName(Main.color("&6Gold HelMet"));
                                        Helmet1.setItemMeta(metaHelmet);

                                        final ItemStack BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
                                        final ItemMeta metaBOOTS = BOOTS.getItemMeta();
                                        metaBOOTS.setDisplayName(Main.color("&6Gold BOOTS"));
                                        BOOTS.setItemMeta(metaBOOTS);

                                        final ItemStack LEGGINGS = new ItemStack(Material.IRON_LEGGINGS);
                                        final ItemMeta metaLEGGINGS = LEGGINGS.getItemMeta();
                                        metaLEGGINGS.setDisplayName(Main.color("&6Gold LEGGINGS"));
                                        LEGGINGS.setItemMeta(metaLEGGINGS);

                                        @SuppressWarnings("deprecation") final ItemStack SPEED = new ItemStack(Material.getMaterial(373), 2, (short) 8258);
                                        final ItemMeta metaSPEED = SPEED.getItemMeta();
                                        metaSPEED.setDisplayName(Main.color("&6Gold SPEED"));
                                        SPEED.setItemMeta(metaSPEED);

                                        @SuppressWarnings("deprecation") final ItemStack FOOD = new ItemStack(Material.getMaterial(364), 64);
                                        final ItemMeta metaFOOD = FOOD.getItemMeta();
                                        metaFOOD.setDisplayName(Main.color("&6Gold FOOD"));
                                        FOOD.setItemMeta(metaFOOD);

                                        p.getInventory().setItem(4, FOOD);
                                        p.getInventory().setItem(0, Sword);
                                        p.getInventory().setItem(1, Rod);
                                        p.getInventory().setItem(8, SPEED);
                                        p.getInventory().setHelmet(Helmet1);
                                        p.getInventory().setChestplate(ChestPlate);
                                        p.getInventory().setLeggings(LEGGINGS);
                                        p.getInventory().setBoots(BOOTS);


                                        p.sendMessage(Main.color(Main.prefix + "&eYou use the &6Gold &ekit"));
                                    } else {
                                        p.sendMessage(Main.premission);
                                    }
                                } else {
                                    if (args[0].equals("Diamond") || args[0].equals("diamond") || args[0].equals("DIAMOND")) {
                                        if (p.hasPermission("luckyffa.kits.diamond.take")) {
                                            p.getInventory().clear();

                                            final ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
                                            final ItemMeta meta = Sword.getItemMeta();
                                            meta.setDisplayName(Main.color("&bDiamond Sword"));
                                            Sword.setItemMeta(meta);

                                            final ItemStack Rod = new ItemStack(Material.FISHING_ROD);
                                            final ItemMeta metaRod = Rod.getItemMeta();
                                            metaRod.setDisplayName(Main.color("&bDiamond Rod"));
                                            Rod.setItemMeta(metaRod);

                                            final ItemStack ChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                                            final ItemMeta metaChestPlate = ChestPlate.getItemMeta();
                                            metaChestPlate.setDisplayName(Main.color("&bDiamond CHESTPLATE"));
                                            ChestPlate.setItemMeta(metaChestPlate);

                                            final ItemStack Helmet1 = new ItemStack(Material.DIAMOND_HELMET);
                                            final ItemMeta metaHelmet = Helmet1.getItemMeta();
                                            metaHelmet.setDisplayName(Main.color("&bDiamond HelMet"));
                                            Helmet1.setItemMeta(metaHelmet);

                                            final ItemStack BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
                                            final ItemMeta metaBOOTS = BOOTS.getItemMeta();
                                            metaBOOTS.setDisplayName(Main.color("&bDiamond BOOTS"));
                                            BOOTS.setItemMeta(metaBOOTS);

                                            final ItemStack LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS);
                                            final ItemMeta metaLEGGINGS = LEGGINGS.getItemMeta();
                                            metaLEGGINGS.setDisplayName(Main.color("&bDiamond LEGGINGS"));
                                            LEGGINGS.setItemMeta(metaLEGGINGS);

                                            @SuppressWarnings("deprecation") final ItemStack SPEED = new ItemStack(Material.getMaterial(373), 3, (short) 8258);
                                            final ItemMeta metaSPEED = SPEED.getItemMeta();
                                            metaSPEED.setDisplayName(Main.color("&bDiamond SPEED"));
                                            SPEED.setItemMeta(metaSPEED);

                                            @SuppressWarnings("deprecation") final ItemStack FOOD = new ItemStack(Material.getMaterial(364), 64);
                                            final ItemMeta metaFOOD = FOOD.getItemMeta();
                                            metaFOOD.setDisplayName(Main.color("&bDiamond FOOD"));
                                            FOOD.setItemMeta(metaFOOD);

                                            p.getInventory().setItem(4, FOOD);
                                            p.getInventory().setItem(0, Sword);
                                            p.getInventory().setItem(1, Rod);
                                            p.getInventory().setItem(8, SPEED);
                                            p.getInventory().setHelmet(Helmet1);
                                            p.getInventory().setChestplate(ChestPlate);
                                            p.getInventory().setLeggings(LEGGINGS);
                                            p.getInventory().setBoots(BOOTS);


                                            p.sendMessage(Main.color(Main.prefix + "&eYou use the &bDiamond &ekit"));
                                        } else {
                                            p.sendMessage(Main.premission);
                                        }
                                    } else {
                                        if (args[0].equals("Clear") || args[0].equals("CLEAR") || args[0].equals("clear")) {
                                            p.getInventory().clear();
                                            p.getInventory().setHelmet(null);
                                            p.getInventory().setChestplate(null);
                                            p.getInventory().setLeggings(null);
                                            p.getInventory().setBoots(null);
                                            p.sendMessage(Main.color(Main.prefix + "&eSuccessfuly cleared"));
                                        } else {
                                            if (args[0].equals("kitname")) {
                                                p.sendMessage(Main.color(Main.prefix + "&eKit Name"));
                                                p.sendMessage(Main.color("- " + "Member kit"));
                                                p.sendMessage(Main.color("- " + "Vip kit"));
                                                p.sendMessage(Main.color("- " + "Vip+ kit"));
                                                p.sendMessage(Main.color("- " + "Gold kit"));
                                                p.sendMessage(Main.color("- " + "Diamond kit"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                p.sendMessage(Main.Error);
            }
                cooldownkit.remove(player);
        }else{
            player.sendMessage(Main.color(Main.prefix + "&cyou can use this kit after 1 minute!"));
        }
        return false;
    }
}
