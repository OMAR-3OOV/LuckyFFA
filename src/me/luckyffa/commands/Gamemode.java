package me.luckyffa.commands;

import me.luckyffa.Main;
import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player){
            if (p.hasPermission("luckyffa.gamemode.commands")) {
                if (args.length == 0) {
                    p.sendMessage(Main.color("&cUsage : /gm <mod>"));
                }
                if (p.hasPermission("luckyffa.gamemode.*")) {
                    if (args.length == 1) {
                        if (args[0].equals("creative") || args[0].equals("1") || args[0].equals("Creative") || args[0].equals("CREATIVE")) {
                            p.sendMessage(Main.color("&5You mod has change to Creative !"));
                            p.setGameMode(GameMode.CREATIVE);
                            TitleBar(p, Main.color("&dCreative mod"), Main.color("&7Your mod has changed"), 4);
                            for (Player OWNER : Bukkit.getOnlinePlayers()) {
                                if (p.hasPermission("luckyffa.gamemode.1.owner")) {
                                    OWNER.sendMessage(Main.color("&d" + p.getName() + " &5has been use the gamemode &7( &aCreative &7)"));
                                }
                            }
                        } else {
                            if (args[0].equals("survival") || args[0].equals("0") || args[0].equals("Survival") || args[0].equals("SURVIVAL")) {
                                p.sendMessage(Main.color("&5You mod has change to Survival !"));
                                p.setGameMode(GameMode.SURVIVAL);
                                TitleBar(p, Main.color("&dSurvival mod"), Main.color("&7Your mod has changed"), 4);
                                for (Player OWNER : Bukkit.getOnlinePlayers()) {
                                    if (p.hasPermission("luckyffa.gamemode.0.owner")) {
                                        OWNER.sendMessage(Main.color("&d" + p.getName() + " &5has been use the gamemode &7( &aSurvival &7)"));
                                    }
                                }
                            } else {
                                if (args[0].equals("adventure") || args[0].equals("2") || args[0].equals("Adventure") || args[0].equals("ADVENTURE")) {
                                    p.sendMessage(Main.color("&5You mod has change to Adventure !"));
                                    p.setGameMode(GameMode.ADVENTURE);
                                    TitleBar(p, Main.color("&dAdventure mod"), Main.color("&7Your mod has changed"), 4);
                                    for (Player OWNER : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("luckyffa.gamemode.2.owner")) {
                                            OWNER.sendMessage(Main.color("&d" + p.getName() + " &5has been use the gamemode &7( &aAdventure &7)"));
                                        }
                                    }
                                } else {
                                    if (args[0].equals("spectator") || args[0].equals("3") || args[0].equals("Spectator") || args[1].equals("SPECTATOR")) {
                                        p.sendMessage(Main.color("&5You mod has change to Spectator !"));
                                        p.setGameMode(GameMode.SPECTATOR);
                                        TitleBar(p, Main.color("&dSpectator mod"), Main.color("&7Your mod has changed"), 4);
                                        for (Player OWNER : Bukkit.getOnlinePlayers()) {
                                            if (p.hasPermission("luckyffa.gamemode.3.owner")) {
                                                OWNER.sendMessage(Main.color("&d" + p.getName() + " &5has been use the gamemode &7( &aSpectator &7)"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                p.sendMessage(Main.premission);
                for (Player noperm : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("luckyffa.gamemode.permission")) {
                        noperm.sendMessage(Main.color("&c" + p.getName() + " &5has been use the gamemode &7( &ccommands &7) !"));
                    }
                }
            }
        }
        return false;
    }

    public void TitleBar(Player player, String title, String subtitle, int seconds) {
        IChatBaseComponent title_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\",\"color\": \"dark_red\"}");
        IChatBaseComponent subtitle_component = ChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");

        PacketPlayOutTitle title_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title_component, 20, seconds * 20, 20);
        PacketPlayOutTitle subtitle_packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitle_component, 50, seconds * 100, 50);

        CraftPlayer cPlayer = (CraftPlayer) player;
        cPlayer.getHandle().playerConnection.sendPacket(title_packet);
        cPlayer.getHandle().playerConnection.sendPacket(subtitle_packet);
    }

}
