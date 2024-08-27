package ba5ed.techJoin.config;

import org.bukkit.configuration.file.FileConfiguration;
import ba5ed.techJoin.TechJoin;

public class ConfigManager {
    private final TechJoin plugin;
    private FileConfiguration config;
    private static final String WELCOME_MESSAGE_KEY = "welcome-message";
    private static final String DEFAULT_WELCOME_MESSAGE = "Welcome to the server, {player}!";

    public ConfigManager(TechJoin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        this.config = plugin.getConfig();

        // Ensure the welcome message exists in the config
        if (!config.contains(WELCOME_MESSAGE_KEY)) {
            config.set(WELCOME_MESSAGE_KEY, DEFAULT_WELCOME_MESSAGE);
            plugin.saveConfig();
        }
    }

    public void setWelcomeMessage(String message) {
        config.set(WELCOME_MESSAGE_KEY, message);
        plugin.saveConfig();
    }

    public String getWelcomeMessage() {
        return config.getString(WELCOME_MESSAGE_KEY, DEFAULT_WELCOME_MESSAGE);
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }
}