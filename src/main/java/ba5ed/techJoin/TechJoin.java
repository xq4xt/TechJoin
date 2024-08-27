package ba5ed.techJoin;

import ba5ed.techJoin.commands.CommandManager;
import ba5ed.techJoin.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;
import ba5ed.techJoin.listeners.PlayerListener;
import ba5ed.techJoin.util.MessageUtil;

public class TechJoin extends JavaPlugin {

    private ConfigManager configManager;
    private MessageUtil messageUtil;

    @Override
    public void onEnable() {
        // Initialize managers
        this.configManager = new ConfigManager(this);
        this.messageUtil = new MessageUtil(this);

        // Register event listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        // Register commands
        new CommandManager(this);

        getLogger().info("TechJoin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TechJoin has been disabled!");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

}
