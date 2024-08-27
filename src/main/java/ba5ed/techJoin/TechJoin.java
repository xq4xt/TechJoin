package ba5ed.techJoin;

import ba5ed.techJoin.commands.CommandManager;
import ba5ed.techJoin.config.ConfigManager;
import ba5ed.techJoin.listeners.PlayerJoinListener;
import ba5ed.techJoin.listeners.PlayerQuitListener;
import ba5ed.techJoin.listeners.PlayerMovementListener;
import ba5ed.techJoin.listeners.PlayerDeathListener;
import ba5ed.techJoin.util.MessageUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class TechJoin extends JavaPlugin {

    private ConfigManager configManager;
    private MessageUtil messageUtil;

    @Override
    public void onEnable() {
        // Initialize managers
        this.configManager = new ConfigManager(this);
        this.messageUtil = new MessageUtil(this);

        // Register event listeners
        registerEvents();

        // Register commands
        new CommandManager(this);

        getLogger().info("TechJoin has been enabled!");
    }

    private void registerEvents() {
        // Register event listeners
        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
        new PlayerMovementListener(this);
        new PlayerDeathListener(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("TechJoin has been disabled!");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }
}
