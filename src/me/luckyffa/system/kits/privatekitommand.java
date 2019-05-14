package me.luckyffa.system.kits;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.EnchantmentWaterWorker;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class privatekitommand implements CommandExecutor {

    private List<Player> Cooldown = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player){
            sender.sendMessage(Main.color("&cOnly player can use this commands"));
        }
        if (args.length == 0){
            if (p.hasPermission("private.kit.commands.vip")){
                if (args[0].equals("vip") || args[0].equals("VIP")){
                    if (Cooldown.contains(p)){

                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta metasword = sword.getItemMeta();
                        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
                        sword.addEnchantment(Enchantment.DURABILITY, 3);
                        metasword.setDisplayName("&eUltimate Sword");
                        sword.setItemMeta(metasword);

                        ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
                        ItemMeta metarod = rod.getItemMeta();
                        rod.addEnchantment(Enchantment.DURABILITY, 3);
                        metarod.setDisplayName("&eUltimate Rod");
                        rod.setItemMeta(metarod);

                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta metabow = bow.getItemMeta();
                        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                        bow.addEnchantment(Enchantment.DURABILITY, 3);
                        metabow.setDisplayName("&eUltimate bow");
                        bow.setItemMeta(metabow);

                        ItemStack speed = new ItemStack(Material.getMaterial(373), 3, (short) 16418);
                        ItemMeta metaspeed = speed.getItemMeta();
                        metaspeed.setDisplayName("&eUltimate Speed");
                        speed.setItemMeta(metaspeed);

                        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
                        ItemMeta metahelmet = helmet.getItemMeta();
                        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        helmet.addEnchantment(Enchantment.DURABILITY, 3);
                        metahelmet.setDisplayName("&eUltimate Helmet");
                        helmet.setItemMeta(metahelmet);

                        ItemStack CHESTPLATE = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
                        ItemMeta metaCHESTPLATE = CHESTPLATE.getItemMeta();
                        CHESTPLATE.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        CHESTPLATE.addEnchantment(Enchantment.DURABILITY, 3);
                        metaCHESTPLATE.setDisplayName("&eUltimate Chestplate");
                        CHESTPLATE.setItemMeta(metaCHESTPLATE);

                        ItemStack Leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
                        ItemMeta metaLeggings = Leggings.getItemMeta();
                        Leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        Leggings.addEnchantment(Enchantment.DURABILITY, 3);
                        metaLeggings.setDisplayName("&eUltimate Leggings");
                        Leggings.setItemMeta(metaLeggings);

                        ItemStack Boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
                        ItemMeta metaBoots = Boots.getItemMeta();
                        Boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        Boots.addEnchantment(Enchantment.DURABILITY, 3);
                        metaBoots.setDisplayName("&eUltimate Boots");
                        Boots.setItemMeta(metaBoots);

                        ItemStack SuperGapple = new ItemStack(Material.getMaterial(322), 1, (short) 1);
                        ItemMeta metaSuperGapple = SuperGapple.getItemMeta();
                        SuperGapple.addEnchantment(Enchantment.DAMAGE_ALL, 2);
                        SuperGapple.setItemMeta(metaSuperGapple);

                        ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
                        ItemMeta metaGapple = Gapple.getItemMeta();
                        metaGapple.setDisplayName("&eUltimate Gapple");
                        Gapple.setItemMeta(metaGapple);

                        ItemStack Arrows = new ItemStack(Material.ARROW, 8);
                        ItemMeta metaArrows = Arrows.getItemMeta();
                        metaArrows.setDisplayName("&eUltimate Arrows");
                        Arrows.setItemMeta(metaArrows);

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
            if (p.hasPermission("private.kit.commands.vip2")){
                if (args[0].equals("vip+") || args[0].equals("VIP+")){
                    if (Cooldown.contains(p)){

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
            if (p.hasPermission("private.kit.commands.gold")){
                if (args[0].equals("gold") || args[0].equals("GOLD")){
                    if (Cooldown.contains(p)){

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
            if (p.hasPermission("private.kit.commands.diamond")){
                if (args[0].equals("diamond") || args[0].equals("DIAMOND")){
                    if (Cooldown.contains(p)){

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
            if (p.hasPermission("private.kit.commands.super")){
                if (args[0].equals("super") || args[0].equals("SUPER")){
                    if (Cooldown.contains(p)){

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
            if (p.hasPermission("private.kit.commands.king")){
                if (args[0].equals("king") || args[0].equals("KING")){
                    if (Cooldown.contains(p)){

                    }else{
                        p.sendMessage(Main.color(Main.prefix + "&cAfter 1 hour you can choose it again"));
                    }
                }
            }else{
                p.sendMessage(Main.premission);
            }
        }
        return false;
    }
}
