package me.luckyffa.system.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.luckyffa.Main;

public class InventoryKits implements CommandExecutor{

    Inventory Inv = Bukkit.createInventory(null, 45, Main.color("&eLuckyFFA &cKits"));

    private boolean titlechanged = false;
    private Main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        int ping = (((CraftPlayer)p).getHandle().ping);
        float xp = (((CraftPlayer)p).getHandle().expLevel);

        if(sender instanceof Player) {

            if(args.length == 0) {

                p.openInventory(Inv);
                Inv.clear();

                ItemStack MemberKit = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta meta = MemberKit.getItemMeta();
                meta.setDisplayName(Main.color("&9Member Kit"));
                ArrayList<String> LoreMember = new ArrayList<String>();
                LoreMember.add("");
                LoreMember.add(Main.color("&f&m&l-&9&m&l----------------------------------&f&m&l-"));
                LoreMember.add("");
                LoreMember.add(Main.color("             &9Click Here to get a Memebr Kit    "));
                LoreMember.add("");
                LoreMember.add(Main.color("              &9all persion can use this Kit    "));
                LoreMember.add("");
                LoreMember.add(Main.color("&f&m&l-&9&m&l----------------------------------&f&m&l-"));
                meta.setLore(LoreMember);
                MemberKit.setItemMeta(meta);



                ItemStack Vipkit = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta meta2 = Vipkit.getItemMeta();
                meta2.setDisplayName(Main.color("&aVip Kit"));
                ArrayList<String> LoreVipKit = new ArrayList<String>();
                LoreVipKit.add("");
                LoreVipKit.add(Main.color("&f&m&l-&a&m&l----------------------------------&f&m&l-"));
                LoreVipKit.add("");
                LoreVipKit.add(Main.color("               &aClick Here to get a Vip Kit    "));
                LoreVipKit.add("");
                LoreVipKit.add(Main.color("            &aOnly Vip persion can use this Kit    "));
                LoreVipKit.add("");
                LoreVipKit.add(Main.color("&f&m&l-&a&m&l----------------------------------&f&m&l-"));
                meta2.setLore(LoreVipKit);
                Vipkit.setItemMeta(meta2);

                ItemStack Vip2kit = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta meta6 = Vip2kit.getItemMeta();
                meta6.setDisplayName(Main.color("&aVip&6+ &aKit"));
                ArrayList<String> LoreVip2Kit = new ArrayList<String>();
                LoreVip2Kit.add("");
                LoreVip2Kit.add(Main.color("&f&m&l-&a&m&l----------------------------------&f&m&l-"));
                LoreVip2Kit.add("");
                LoreVip2Kit.add(Main.color("               &aClick Here to get a Vip&6+ &aKit    "));
                LoreVip2Kit.add("");
                LoreVip2Kit.add(Main.color("            &aOnly Vip&6+ &apersion can use this Kit    "));
                LoreVip2Kit.add("");
                LoreVip2Kit.add(Main.color("&f&m&l-&a&m&l----------------------------------&f&m&l-"));
                meta6.setLore(LoreVip2Kit);
                Vip2kit.setItemMeta(meta6);

                ItemStack GoldKit = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta meta4 = GoldKit.getItemMeta();
                meta4.setDisplayName(Main.color("&6Gold Kit"));
                ArrayList<String> LoreGoldKit = new ArrayList<String>();
                LoreGoldKit.add("");
                LoreGoldKit.add(Main.color("&f&m&l-&6&m&l----------------------------------&f&m&l-"));
                LoreGoldKit.add("");
                LoreGoldKit.add(Main.color("               &6Click Here to get a Gold Kit    "));
                LoreGoldKit.add("");
                LoreGoldKit.add(Main.color("            &6Only Gold persion can use this Kit    "));
                LoreGoldKit.add("");
                LoreGoldKit.add(Main.color("&f&m&l-&6&m&l----------------------------------&f&m&l-"));
                meta4.setLore(LoreGoldKit);
                GoldKit.setItemMeta(meta4);

                ItemStack DiamondKit = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta meta5 = DiamondKit.getItemMeta();
                meta5.setDisplayName(Main.color("&bDiamond Kit"));
                ArrayList<String> LoreDiamondKit = new ArrayList<String>();
                LoreDiamondKit.add("");
                LoreDiamondKit.add(Main.color("&f&m&l-&b&m&l----------------------------------&f&m&l-"));
                LoreDiamondKit.add("");
                LoreDiamondKit.add(Main.color("             &bClick Here to get a &bDiamond Kit    "));
                LoreDiamondKit.add("");
                LoreDiamondKit.add(Main.color("          &bOnly &bDiamond persion can use this Kit    "));
                LoreDiamondKit.add("");
                LoreDiamondKit.add(Main.color("&f&m&l-&b&m&l----------------------------------&f&m&l-"));
                meta5.setLore(LoreDiamondKit);
                DiamondKit.setItemMeta(meta5);


                ItemStack Close = new ItemStack(Material.BARRIER);
                ItemMeta meta3 = Close.getItemMeta();
                meta3.setDisplayName(Main.color("&cClose"));
                Close.setItemMeta(meta3);


                ItemStack Desgin = new ItemStack(Material.STAINED_GLASS_PANE,1 , (short) 3);
                ItemMeta meta51 = Desgin.getItemMeta();
                meta51.setDisplayName(Main.color("&bLuckyFFA"));
                Desgin.setItemMeta(meta51);

                ItemStack info = new ItemStack(Material.SIGN);
                ItemMeta metainfo = info.getItemMeta();
                metainfo.setDisplayName(Main.color("&bInfo"));
                ArrayList<String> LoreInfo = new ArrayList<String>();
                LoreInfo.add("");
                LoreInfo.add(Main.color("&f&m&l-&c&m&l---------------------------&f&m&l-"));
                LoreInfo.add("");
                LoreInfo.add(Main.color("                        &cinfo kit    "));
                LoreInfo.add("");
                LoreInfo.add(Main.color("                        &aVip Kit"));
                LoreInfo.add("");
                LoreInfo.add(Main.color("                       &aVip&6+ &aKit"));
                LoreInfo.add("");
                LoreInfo.add(Main.color("                        &6Gold Kit"));
                LoreInfo.add("");
                LoreInfo.add(Main.color("                     &bDiamond Kit"));
                LoreInfo.add("");
                LoreInfo.add(Main.color("&f&m&l-&c&m&l---------------------------&f&m&l-"));
                metainfo.setLore(LoreInfo);
                info.setItemMeta(metainfo);

                ItemStack You = new ItemStack(Material.SIGN);
                ItemMeta metaYou = You.getItemMeta();
                metaYou.setDisplayName(Main.color("&bYou Informations"));
                ArrayList<String> LoreYou = new ArrayList<String>();
                LoreYou.add("");
                LoreYou.add(Main.color("&f&m&l-&b&m&l------------&f&m&l-"));
                LoreYou.add("");
                LoreYou.add(Main.color("&bName ➸ &e" + p.getName()));
                LoreYou.add("");
                LoreYou.add(Main.color("&byour ping ➸ &e" + " " + ping ));
                LoreYou.add("");
                LoreYou.add(Main.color("&byour Xp ➸ &e" + " " + xp ));
                LoreYou.add("");
                LoreYou.add(Main.color("&byour Kills ➸ &e" + " " + p.getStatistic(Statistic.PLAYER_KILLS) ));
                LoreYou.add("");
                LoreYou.add(Main.color("&byour Death ➸ &e" + " " + p.getStatistic(Statistic.DEATHS) ));
                LoreYou.add("");
                LoreYou.add(Main.color("&f&m&l-&b&m&l------------&f&m&l-"));
                metaYou.setLore(LoreYou);
                You.setItemMeta(metaYou);

                ItemStack shop = new ItemStack(Material.ENDER_PORTAL_FRAME);
                ItemMeta metashop = shop.getItemMeta();
                metashop.setDisplayName(Main.color("&bShop"));
                ArrayList<String> LoreShop = new ArrayList<String>();
                LoreShop.add("");
                LoreShop.add(Main.color("&f&m&l-&b&m&l----------------------------------&f&m&l-"));
                LoreShop.add("");
                LoreShop.add(Main.color("             &bClick Here to open a menu shop    "));
                LoreShop.add("");
                LoreShop.add(Main.color("        &cAttention : &bYou must have coins to Buy    "));
                LoreShop.add("");
                LoreShop.add(Main.color("&f&m&l-&b&m&l----------------------------------&f&m&l-"));
                metashop.setLore(LoreShop);
                shop.setItemMeta(metashop);

                ItemStack comment = new ItemStack(Material.PAPER);
                ItemMeta metacomment = comment.getItemMeta();
                metacomment.setDisplayName(Main.color("&bComments"));
                comment.setItemMeta(metacomment);

                ItemStack ClearKit = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                ItemMeta metaClearKit = ClearKit.getItemMeta();
                metaClearKit.setDisplayName(Main.color("&cClear Kit"));
                ClearKit.setItemMeta(metaClearKit);


                Inv.setItem(10, new ItemStack(MemberKit));
                Inv.setItem(12, new ItemStack(Vipkit));
                Inv.setItem(14, new ItemStack(Vip2kit));

                Inv.setItem(29, new ItemStack(GoldKit));
                Inv.setItem(31, new ItemStack(DiamondKit));

                Inv.setItem(17, new ItemStack(comment));
                Inv.setItem(26, new ItemStack(shop));
                Inv.setItem(8, new ItemStack(info));
                Inv.setItem(35, new ItemStack(You));
                Inv.setItem(39, new ItemStack(ClearKit));
                Inv.setItem(44, new ItemStack(Close));

                Inv.setItem(7, new ItemStack(Desgin));
                Inv.setItem(16, new ItemStack(Desgin));
                Inv.setItem(25, new ItemStack(Desgin));
                Inv.setItem(34, new ItemStack(Desgin));
                Inv.setItem(43, new ItemStack(Desgin));

                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 10);

                return true;
            }else {
                p.closeInventory();
                p.sendMessage(Main.premission);
                p.playSound(p.getLocation(), Sound.BAT_DEATH, 6, 3);

                org.bukkit.Location loc = p.getLocation();
                p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
            }
        }else {
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.BAT_DEATH, 6, 3);
            org.bukkit.Location loc = p.getLocation();
            p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
        }
        return false;
    }

}

