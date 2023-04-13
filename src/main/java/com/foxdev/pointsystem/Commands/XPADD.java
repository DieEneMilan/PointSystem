package com.foxdev.pointsystem.Commands;

import com.foxdev.pointsystem.PointSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XPADD implements CommandExecutor {

    private PointSystem plugin;

    public XPADD(PointSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            int xpToAdd = plugin.getConfig().getInt("xpToAdd");
            player.giveExp(xpToAdd);
            player.sendMessage("Je hebt " + xpToAdd + " ervaringspunten ontvangen!");
        }
        return true;
    }
}
