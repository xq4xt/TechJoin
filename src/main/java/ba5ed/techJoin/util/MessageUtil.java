package ba5ed.techJoin.util;

import ba5ed.techJoin.TechJoin;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class MessageUtil {
    private final TechJoin plugin;

    public MessageUtil(TechJoin plugin) {
        this.plugin = plugin;
    }

    public void sendColoredMessage(Player player, String message) {
        player.sendMessage(translateAlternateColorCodes('&', message));
    }

    public void broadcastColoredMessage(String message) {
        plugin.getServer().broadcastMessage(translateAlternateColorCodes('&', message));
    }

    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(
                translateAlternateColorCodes('&', title),
                translateAlternateColorCodes('&', subtitle),
                fadeIn, stay, fadeOut
        );
    }
}