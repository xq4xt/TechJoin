package ba5ed.techJoin.util;

import ba5ed.techJoin.TechJoin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class MessageUtil {
    private final TechJoin plugin;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public MessageUtil(TechJoin plugin) {
        this.plugin = plugin;
    }

    public void sendColoredMessage(Player player, String message) {
        Component component = miniMessage.deserialize(message);
        player.sendMessage(component);
    }

    public void broadcastColoredMessage(String message) {
        Component component = miniMessage.deserialize(message);
        plugin.getServer().sendMessage(component);
    }
}
