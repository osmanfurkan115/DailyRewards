package io.github.osmanfurkan115.dailyrewards.reward;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import io.github.osmanfurkan115.dailyrewards.reward.type.Reward;

public class RewardManager {
    private final DailyRewardsPlugin plugin;

    public RewardManager(DailyRewardsPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCustomReward(DailyReward dailyReward, Reward reward) {
        dailyReward.addReward(reward);
    }
}
