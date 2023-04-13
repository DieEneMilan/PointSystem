package com.foxdev.pointsystem;

import com.foxdev.pointsystem.Commands.XPADD;
import com.foxdev.pointsystem.Listener.XPGoalListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PointSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("xpadd").setExecutor(new XPADD(this));
        getServer().getPluginManager().registerEvents(new XPGoalListener(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
