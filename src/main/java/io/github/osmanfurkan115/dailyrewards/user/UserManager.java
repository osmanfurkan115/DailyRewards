package io.github.osmanfurkan115.dailyrewards.user;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import org.bukkit.entity.Player;

import java.util.Optional;

public class UserManager {
    private final DailyRewardsPlugin plugin;

    public UserManager(DailyRewardsPlugin plugin) {
        this.plugin = plugin;
    }

    public User createUser(Player player) {
        User user = new User(player.getUniqueId());
        plugin.getStorageManager().getUserRepository().save(user);
        return user;
    }

    public boolean containsPlayer(Player player) {
        return plugin.getStorageManager().getUserRepository()
                .findById(player.getUniqueId())
                .getNow(Optional.empty())
                .isPresent();
    }
}
