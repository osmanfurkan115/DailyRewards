package io.github.osmanfurkan115.dailyrewards;

import io.github.osmanfurkan115.dailyrewards.reward.RewardManager;
import io.github.osmanfurkan115.dailyrewards.storage.DataSource;
import io.github.osmanfurkan115.dailyrewards.storage.StorageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DailyRewardsPlugin extends JavaPlugin {
    private final RewardManager rewardManager = new RewardManager(this);
    private StorageManager storageManager;

    @Override
    public void onEnable() {
        storageManager = new StorageManager(DataSource.getDataSourceByName(getConfig().getString("storage.type")));
    }
}
