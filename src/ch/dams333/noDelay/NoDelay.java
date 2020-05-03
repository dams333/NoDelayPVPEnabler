package ch.dams333.noDelay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoDelay extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        for(Player p : Bukkit.getOnlinePlayers()){
            p.getAttribute(org.bukkit.attribute.Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){
        for(Player p : Bukkit.getOnlinePlayers()){
            p.getAttribute(org.bukkit.attribute.Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4.0D);
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().getAttribute(org.bukkit.attribute.Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        e.getPlayer().getAttribute(org.bukkit.attribute.Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4.0D);
    }


}
