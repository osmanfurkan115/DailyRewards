package io.github.osmanfurkan115.dailyrewards.hook.placeholderapi;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PAPIPlaceholders extends PlaceholderExpansion {
    private final DailyRewardsPlugin plugin;

    public PAPIPlaceholders(DailyRewardsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "dailyrewards";
    }

    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public @NotNull String onPlaceholderRequest(Player player, String identifier) {
        return null;
    }
}
