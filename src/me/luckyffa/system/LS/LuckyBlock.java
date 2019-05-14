package me.luckyffa.system.LS;

import me.luckyffa.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class LuckyBlock implements Listener {

    public static ArrayList<String> cooldown = new ArrayList<>();

    public static String Legenderylucky = Main.color("&eYou have Legendery Luck");
    public static String Epiclucky = Main.color("&eYou have Epic Luck");
    public static String nonlucky = Main.color("&eYou have non Luck");
    public static String badlucky = Main.color("&eYou have bad Luck");

    private Main plugin;
    public LuckyBlock(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){

        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)14);
        SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
        skullmeta.setOwner("luck");
        skullmeta.setDisplayName(Main.color("&e&lLuck&6&lBlock &c&l[ &6&lFFA &c&l]"));
        skull.setItemMeta(skullmeta);

        if(e.getBlock().getState() != skull)return;
        Location location = e.getBlock().getLocation().add(0.5,0,0.5);
        e.setCancelled(true);
        e.getBlock().setType(Material.AIR);
        int randomnumber = new Random().nextInt(15); //0 1 2
        switch (randomnumber){
            case 0:{
                Witch witch = location.getWorld().spawn(location, Witch.class);
                Bat bat = location.getWorld().spawn(location, Bat.class);
                location.getWorld().spawn(location, Bat.class);
                location.getWorld().spawn(location, Bat.class);
                location.getWorld().spawn(location, Bat.class);
                location.getWorld().spawn(location, Bat.class);
                bat.setPassenger(witch);
                break;
            }
            case 1:{

                location.getWorld().spawnFallingBlock(location,Material.CAKE_BLOCK, (byte) 0);
                location.getWorld().playEffect(location, Effect.CLOUD, 3);
                break;
            }
            case 2:{
                location.getWorld().spawn(location, Wolf.class);
                location.getWorld().dropItemNaturally(location, new ItemStack(Material.BONE, 7));
                break;
            }
            case 3:{
                ItemStack GoldenApple = new ItemStack(Material.GOLDEN_APPLE, 2);
                ItemMeta GoldenAppleMeta = GoldenApple.getItemMeta();
                GoldenAppleMeta.setDisplayName(Main.color("&b&lGoldenApple"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&5Epic : &7GoldenApple"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                GoldenAppleMeta.setLore(lore);
                GoldenApple.setItemMeta(GoldenAppleMeta);

                location.getWorld().dropItemNaturally(location, GoldenApple);
                break;
            }
            case 4:{
                ItemStack PowerBow = new ItemStack(Material.BOW, 1);
                ItemMeta PowerBowMeta = PowerBow.getItemMeta();
                PowerBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
                PowerBowMeta.setDisplayName(Main.color("&6&lPower Bow"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Legendery : &7Power Bow"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                PowerBowMeta.setLore(lore);
                PowerBow.setItemMeta(PowerBowMeta);

                location.getWorld().playEffect(location, Effect.SMOKE , 10);
                location.getWorld().dropItemNaturally(location, PowerBow);
                e.getPlayer().playSound(location, Sound.valueOf("WOLF_GROWL"),5,1);
                break;
            }
            case 5:{
                Skeleton player = location.getWorld().spawn(location, Skeleton.class);
                Blaze Blaze = location.getWorld().spawn(location, Blaze.class);
                location.getWorld().spawn(location, Blaze.class);
                Blaze.setPassenger(player);

                break;
            }
            case 6:{
                ItemStack EnderPearl = new ItemStack(Material.ENDER_PEARL, 1);
                ItemMeta EnderPearlMeta = EnderPearl.getItemMeta();
                EnderPearlMeta.setDisplayName(Main.color("&5&lEnder Pearl"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Legendery : &7Ender Pearl"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                EnderPearlMeta.setLore(lore);
                EnderPearl.setItemMeta(EnderPearlMeta);

                location.getWorld().dropItemNaturally(location, EnderPearl);
                location.getWorld().playEffect(location, Effect.ENDER_SIGNAL , 10);

                Player player = e.getPlayer();
                EnderPearl pearl = location.getWorld().spawn(location, EnderPearl.class);
                location.getWorld().spawn(location, EnderPearl.class);
                pearl.setPassenger(player);
                break;
            }
            case 7:{

                ItemStack PowerSword = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta PowerSwordMeta = PowerSword.getItemMeta();
                PowerSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
                PowerSwordMeta.setDisplayName(Main.color("&e&lPower Sword"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Legendery : &7Power Sword"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                PowerSwordMeta.setLore(lore);
                PowerSword.setItemMeta(PowerSwordMeta);

                location.getWorld().playEffect(location, Effect.SMOKE , 10);
                location.getWorld().dropItemNaturally(location, PowerSword);
                e.getPlayer().playSound(location, Sound.valueOf("WOLF_GROWL"),5,1);
                break;
            }
            case 8:{

                ItemStack SnowBall = new ItemStack(Material.SNOW_BALL, 32);
                ItemMeta SnowBallMeta = SnowBall.getItemMeta();
                SnowBallMeta.setDisplayName(Main.color("&9&lSnow Balls"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Legendery : &7SnowBall"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                SnowBallMeta.setLore(lore);
                SnowBall.setItemMeta(SnowBallMeta);

                location.getWorld().playEffect(location, Effect.SMOKE , 10);
                location.getWorld().dropItemNaturally(location, SnowBall);
                e.getPlayer().playSound(location, Sound.valueOf("WOLF_GROWL"),5,1);
                break;
            }
            case 9:{
                /*/ Skeleton Boss/*/
                Skeleton sk = location.getWorld().spawn(location, Skeleton.class);
                Bat bat = location.getWorld().spawn(location, Bat.class);
                Player p = e.getPlayer();

                p.setMaxHealth(40);
                sk.setCustomName(Main.color("&e&lSkeleton boss"));
                sk.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000000, 4));
                sk.getWorld().playEffect(location, Effect.CLOUD, 2);
                sk.setMaxHealth(40);
            break;
            }
            case 10:{
                Player p = e.getPlayer();
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS , 10*10 , 1));
                break;
            }
            case 11:{
                Player jwp = e.getPlayer();

                jwp.sendMessage(Main.color(Main.prefix + "&bYou have received a water bucket, think fast"));
                jwp.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
                jwp.setVelocity(new Vector(0 , 5, 0));
                break;
            }
            case 12:{
                Player Effectp = e.getPlayer();

                Effectp.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*35, 3));
                Effectp.sendMessage(Main.color(Main.prefix + "&bYou have been Speed 10s"));

                Bukkit.getScheduler().runTaskLater(plugin,()->{
                    Effectp.sendMessage(Main.color(Main.prefix + "&b Speed Effect has done"));
                    Effectp.removePotionEffect(PotionEffectType.SPEED);
                }, 200);
                break;
            }
            case 13:{
                Player LP = e.getPlayer();

                ItemStack LuckyBlock = new ItemStack(Material.SPONGE, 3);
                ItemMeta MetaLucky = LuckyBlock.getItemMeta();
                MetaLucky.setDisplayName(Main.color("&eLucly&6Block"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Legendery : &7LuckyBlock"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                MetaLucky.setLore(lore);
                LuckyBlock.setItemMeta(MetaLucky);

                LP.getInventory().addItem(LuckyBlock);
                LP.sendMessage(Main.color(Main.prefix + "&bYou get a 3 &eLucky6Block.."));
                break;
            }
            case 14:{
                Player p = e.getPlayer();

                ItemStack SnowBall = new ItemStack(Material.SNOW_BALL, 32);
                ItemMeta meta = SnowBall.getItemMeta();
                meta.setDisplayName(Main.color("&eSnow Ball"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                lore.add(Main.color(""));
                lore.add(Main.color("&6Epic : &7SnowBall"));
                lore.add(Main.color(""));
                lore.add(Main.color("&e&m=&6&m==================&e&m="));
                meta.setLore(lore);
                SnowBall.setItemMeta(meta);
                break;
            }
            case 15:{
                final Player p = e.getPlayer();
                p.getInventory().addItem(new ItemStack(Material.STICK));
                if ((Action.RIGHT_CLICK_BLOCK != null) && (p.getItemInHand().getType() == Material.STICK)) {
                    if (!cooldown.contains(p.getName()))
                    {
                        p.sendMessage(Main.color(Main.prefix + "&eYou jumping to" + p.getLocation()));

                        final FallingBlock tapete = p.getWorld().spawnFallingBlock(p.getLocation().clone().add(0.0D, 1.0D, 0.0D), Material.CARPET.getId(), (byte)0);
                        tapete.setDropItem(false);
                        tapete.setVelocity(new Vector(0, 0, 0));
                        tapete.setPassenger(p);
                        Location loc = p.getLocation().clone();
                        loc.setPitch(0.0F);
                        cooldown.add(p.getName());
                        Vector vec = p.getVelocity().clone();
                        int forca = 7;
                        Vector pular = vec.multiply(0.1D).setY(0.17D * forca);
                        Vector olhar = loc.getDirection().normalize().multiply(1.5D);
                        tapete.setVelocity(pular.add(olhar));

                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run()
                            {
                                tapete.remove();
                                p.sendMessage(Main.color(Main.prefix + "&aNow you can jumping again!"));
                            }
                        }, 100L);

                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run()
                            {
                                LuckyBlock.cooldown.remove(p.getName());
                            }
                        }, 400L);
                    }else
                    {
                        p.sendMessage(Main.color(Main.prefix + "&cYou can jump again after &a10s"));
                    }
                }
                break;
            }
            case 16:

                location.getWorld().spawnFallingBlock(location, Material.SPONGE, (byte) 0);
                location.getWorld().playEffect(location, Effect.SMOKE, 3);
                break;
        }
    }
}
