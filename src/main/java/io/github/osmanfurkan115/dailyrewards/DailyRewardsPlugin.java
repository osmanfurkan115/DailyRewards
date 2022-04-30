package io.github.osmanfurkan115.dailyrewards;

import io.github.osmanfurkan115.dailyrewards.configuration.Yaml;
import io.github.osmanfurkan115.dailyrewards.hook.vault.VaultHook;
import io.github.osmanfurkan115.dailyrewards.hook.placeholderapi.PlaceholderAPIHook;
import io.github.osmanfurkan115.dailyrewards.menu.listener.MenuListener;
import io.github.osmanfurkan115.dailyrewards.reward.RewardManager;
import io.github.osmanfurkan115.dailyrewards.storage.DataSource;
import io.github.osmanfurkan115.dailyrewards.storage.StorageManager;
import io.github.osmanfurkan115.dailyrewards.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DailyRewardsPlugin extends JavaPlugin {
    private final RewardManager rewardManager = new RewardManager(this);
    private StorageManager storageManager;
    private final UserManager userManager = new UserManager(this);

    private VaultHook vaultHook;
    private final PlaceholderAPIHook placeholderAPIHook = new PlaceholderAPIHook(this);

    private final Yaml menu = new Yaml(this, "menu.yml");
    private final Yaml rewards = new Yaml(this, "rewards.yml");

    @Override
    public void onEnable() {
        storageManager = new StorageManager(this, DataSource.getDataSourceByName(getConfig().getString("storage.type")));

        vaultHook = new VaultHook();
        placeholderAPIHook.initialize();

        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    public RewardManager getRewardManager() {
        return rewardManager;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public VaultHook getVaultHook() {
        return vaultHook;
    }

    public PlaceholderAPIHook getPlaceholderAPIHook() {
        return placeholderAPIHook;
    }

    public Yaml getMenu() {
        return menu;
    }

    public Yaml getRewards() {
        return rewards;
    }
}
