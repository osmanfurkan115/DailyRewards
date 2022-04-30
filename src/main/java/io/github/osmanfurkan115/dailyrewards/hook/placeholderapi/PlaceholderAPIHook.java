package io.github.osmanfurkan115.dailyrewards.hook.placeholderapi;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import io.github.osmanfurkan115.dailyrewards.hook.Hook;

public class PlaceholderAPIHook extends Hook {
    private final DailyRewardsPlugin plugin;

    public PlaceholderAPIHook(DailyRewardsPlugin plugin) {
        super("PlaceholderAPI", false);
        this.plugin = plugin;
    }

    public void initialize() {
        if (isEnabled()) new PAPIPlaceholders(this.plugin);
    }
}
