package io.github.osmanfurkan115.dailyrewards.reward.type;

import io.github.osmanfurkan115.dailyrewards.parser.RewardParser;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionReward extends Reward implements RewardParser<PermissionReward> {
    private final JavaPlugin plugin;
    private final String permission;

    public PermissionReward(JavaPlugin plugin, ConfigurationSection section) {
        this.plugin = plugin;
        PermissionReward reward = parse(section);
        this.permission = reward.permission;
    }

    public PermissionReward(JavaPlugin plugin, String permission) {
        this.plugin = plugin;
        this.permission = permission;
    }

    @Override
    public void give(Player player) {
        player.addAttachment(plugin, permission, true);
    }

    @Override
    public PermissionReward parse(ConfigurationSection section) {
        String permissionValue = section.getString("permission");
        if (permissionValue == null) throw new IllegalArgumentException("permission section is missing");
        return new PermissionReward(plugin, permissionValue);
    }
}
