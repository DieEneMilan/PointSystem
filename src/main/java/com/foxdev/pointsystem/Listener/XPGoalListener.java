package com.foxdev.pointsystem.Listener;

import com.foxdev.pointsystem.PointSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class XPGoalListener implements Listener {

    private PointSystem plugin;

    public XPGoalListener(PointSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        //Voeg iets toe!
    }

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        int previousTotalXp = getTotalExperience(player);
        int newTotalXp = previousTotalXp + event.getAmount();
        int goal = plugin.getConfig().getInt("goal");
        int xpToCompleteGoal = plugin.getConfig().getInt("xpToCompleteGoal");

        if(previousTotalXp < goal && newTotalXp >= goal) {
            player.giveExp(xpToCompleteGoal);
            player.sendMessage("Gefeliciteerd! Je hebt het doel van " + goal + " XP bereikt en " + xpToCompleteGoal + " bonus XP ontvangen!");
        }
    }

    private int getTotalExperience(Player player) {
        int level = player.getLevel();
        int progress = (int) (player.getExp() * player.getExpToLevel());
        return levelToXp(level) + progress;
    }

    private int levelToXp(int level) {
        if (level <= 15) {
            return 7 * level * level;
        } else if (level <= 30) {
            return (int) (3.5 * level * level - 151.5 * level + 2220);
        } else {
            return (int) (4.5 * level * level - 162.5 * level + 2220);
        }
    }
}