package me.luckyffa;

import me.luckyffa.ServerEvent.*;
import me.luckyffa.commands.Gamemode;
import me.luckyffa.commands.gmold;
import me.luckyffa.staffpack.ScreenShare;
import me.luckyffa.system.LS.LuckyBlock;
import me.luckyffa.system.LS.LuckyBlockSystem;
import me.luckyffa.system.LS.StatsSystem;
import me.luckyffa.system.kits.InventoryKits;
import me.luckyffa.system.kits.InventoryKitsEvent;
import me.luckyffa.system.*;
import me.luckyffa.system.kits.PrivateKit;
import me.luckyffa.system.kits.kits;
import me.luckyffa.system_duel.duelsystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public class Main extends JavaPlugin {

    public static String prefix = color("&7&l| &eLucky&6FFA &7&l| ");
    public static String premission = color(prefix + "&eYou dont have access to do that..!");
    public static String Error = color(prefix + "&eThis commands is not existent");
    public static String Quit = color("&8Quit >> ");
    public static String Join = color("&8Join >> ");
    public static String duel = color("&6Duel &7| &r");

    public static HashMap<Player, ItemStack> screensharee = new HashMap<>();

    public void onEnable() {
        this.onregister();
        System.out.print(color("&eLucky&6FFA &ahas Enable"));

        for (Player Reload : Bukkit.getOnlinePlayers()) {

            Reload.sendMessage(color(prefix + " &aFFA has been reload!"));

        }
    }

    public void onDisable() {
        System.out.print(color("&eLucky&6FFA &chas Error..!"));
    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void onregister() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinEvent(), (Plugin) this);
        pm.registerEvents(new QuitEvent(), (Plugin) this);
        pm.registerEvents(new InventoryKitsEvent(), (Plugin) this);
        pm.registerEvents(new LuckyBlock(this), (Plugin) this);
        pm.registerEvents(new DeidEvent(), (Plugin) this);
        pm.registerEvents(new Respawn(this), (Plugin)this);
        pm.registerEvents(new AnimetedExplosice(), this);
        pm.registerEvents(new PrivateKit(this), this);
        pm.registerEvents(new HealTag(), this);
        pm.registerEvents(new ChatSystem(), this);
        pm.registerEvents(new ScreenShare(), this);
        pm.registerEvents(new duelsystem(this), this);
        getCommand("pk").setExecutor(new PrivateKit(this));
        getCommand("pc").setExecutor(new ChatSystem());
        getCommand("Vanish").setExecutor(new Vanish());
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("gamemode").setExecutor(new gmold());
        getCommand("kit").setExecutor(new kits());
        getCommand("ping").setExecutor(new Ping());
        getCommand("duel").setExecutor(new duelsystem(this));
        getCommand("kits").setExecutor(new InventoryKits());
        getCommand("LB").setExecutor(new LuckyBlockSystem());
        getCommand("sethologram").setExecutor(new HologramLuckyFFA(this));
        getCommand("ss").setExecutor(new ScreenShare());
        getCommand("stats").setExecutor(new StatsSystem());
    }

}