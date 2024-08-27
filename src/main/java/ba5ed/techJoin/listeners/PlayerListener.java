package ba5ed.techJoin.listeners;

import ba5ed.techJoin.TechJoin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import static ba5ed.techJoin.util.Utils.registerPlayer;

public class PlayerListeners implements Listener {
    private final TechJoin plugin;

    public PlayerListeners(TechJoin plugin) {
        this.plugin = plugin;
        
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        registerPlayer(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        // Handle player quit event
        plugin.getLogger().info(player.getName() + " has left the server.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // Handle player movement event
        // Example: track player movement or apply certain effects
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        // Handle player death event
        plugin.getLogger().info(player.getName() + " has died.");
    }
}
