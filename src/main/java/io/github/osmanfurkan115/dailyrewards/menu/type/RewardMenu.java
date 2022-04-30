package io.github.osmanfurkan115.dailyrewards.menu.type;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import io.github.osmanfurkan115.dailyrewards.menu.Menu;
import io.github.osmanfurkan115.dailyrewards.util.ColorUtils;
import org.bukkit.configuration.ConfigurationSection;

public class RewardMenu extends Menu {
    private final DailyRewardsPlugin plugin;

    public RewardMenu(DailyRewardsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getTitle() {
        return ColorUtils.colored(getMenuSection().getString("title"));
    }

    @Override
    public int getSize() {
        return getMenuSection().getInt("size");
    }

    @Override
    public boolean isCloseable() {
        return true;
    }

    @Override
    public ConfigurationSection getMenuSection() {
        return plugin.getMenu().getConfigurationSection("dailyreward");
    }

    @Override
    protected void setupMenu() {

    }
}
