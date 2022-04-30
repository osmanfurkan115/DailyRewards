package io.github.osmanfurkan115.dailyrewards.reward.type;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import io.github.osmanfurkan115.dailyrewards.parser.RewardParser;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class MoneyReward extends Reward implements RewardParser<MoneyReward> {
    private final DailyRewardsPlugin plugin;
    private final double amount;

    public MoneyReward(DailyRewardsPlugin plugin, ConfigurationSection section) {
        this.plugin = plugin;
        MoneyReward reward = parse(section);
        this.amount = reward.amount;
    }

    public MoneyReward(DailyRewardsPlugin plugin, double amount) {
        this.plugin = plugin;
        this.amount = amount;
    }

    @Override
    public void give(Player player) {
        if (plugin.getVaultHook().isEnabled()) return;
        plugin.getVaultHook().getEconomy().depositPlayer(player, amount);
    }

    @Override
    public MoneyReward parse(ConfigurationSection section) {
        double money = section.getDouble("money", 0);
        return new MoneyReward(plugin, money);
    }
}
