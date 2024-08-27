package ba5ed.techJoin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ba5ed.techJoin.TechJoin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandManager implements CommandExecutor {

    private final TechJoin plugin;

    public CommandManager(TechJoin plugin) {
        this.plugin = Objects.requireNonNull(plugin, "Plugin instance cannot be null");
        registerCommands();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tj")) {
            if (args.length == 0) {
                sender.sendMessage("§cUsage: /tj setwelcome <message> or /tj reload");
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "setwelcome" -> handleSetWelcome(sender, args);
                case "reload" -> handleReload(sender);
                default -> sender.sendMessage("§cUnknown subcommand. Use /tj setwelcome <message> or /tj reload");
            }
            return true;
        }

        return false;
    }

    private void handleSetWelcome(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("§cUsage: /tj setwelcome <message>");
            return;
        }

        if (!sender.hasPermission("techjoin.setwelcome")) {
            sender.sendMessage("§cYou don't have permission to set the welcome message.");
            return;
        }

        String welcomeMessage = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
        plugin.getConfigManager().setWelcomeMessage(welcomeMessage);

        sender.sendMessage("§aWelcome message set successfully to: §f" + welcomeMessage);
        sender.sendMessage("§7Use {player} to include the player's name in the message.");
    }

    private void handleReload(CommandSender sender) {
        if (!sender.hasPermission("techjoin.reload")) {
            sender.sendMessage("§cYou don't have permission to reload the configuration.");
            return;
        }

        plugin.getConfigManager().reloadConfig();
        sender.sendMessage("§aConfiguration reloaded successfully.");
        sender.sendMessage("§7Current welcome message: §f" + plugin.getConfigManager().getWelcomeMessage());
    }

    private void registerCommands() {
        Objects.requireNonNull(plugin.getCommand("tj"), "Command 'tj' is not defined in plugin.yml").setExecutor(this);
    }
}
