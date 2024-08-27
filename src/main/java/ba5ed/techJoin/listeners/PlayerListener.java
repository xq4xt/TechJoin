package ba5ed.techJoin.listeners;

import ba5ed.techJoin.TechJoin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;

public class PlayerListener implements Listener {
    private final TechJoin plugin;

    public PlayerListener(TechJoin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String welcomeMessage = plugin.getConfigManager().getWelcomeMessage()
                .replace("{player}", player.getName());

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', welcomeMessage));

        // event.setJoinMessage(null);
        // event.setJoinMessage(ChatColor.translateAlternateColorCodes() + player.getName() + " joined the game");
    }
}