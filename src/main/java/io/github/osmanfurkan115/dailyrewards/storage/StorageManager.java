package io.github.osmanfurkan115.dailyrewards.storage;

import io.github.osmanfurkan115.dailyrewards.DailyRewardsPlugin;
import io.github.osmanfurkan115.dailyrewards.storage.credentials.SQLCredentials;
import io.github.osmanfurkan115.dailyrewards.storage.user.MySQLUserRepository;
import io.github.osmanfurkan115.dailyrewards.storage.user.SQLiteUserRepository;
import io.github.osmanfurkan115.dailyrewards.storage.user.UserRepository;
import org.bukkit.configuration.ConfigurationSection;

public class StorageManager {
    private final DailyRewardsPlugin plugin;
    private final UserRepository userRepository;

    public StorageManager(DailyRewardsPlugin plugin, DataSource dataSource) {
        this.plugin = plugin;
        switch (dataSource) {
            case MySQL:
                ConfigurationSection storageSection = plugin.getConfig().getConfigurationSection("storage");
                SQLCredentials credentials = new SQLCredentials.Builder() //TODO get credentials from config
                        .userName(storageSection.getString("username"))
                        .password(storageSection.getString("password"))
                        .database(storageSection.getString("database"))
                        .host(storageSection.getString("host"))
                        .port(storageSection.getString("port"))
                        .build();
                userRepository = new MySQLUserRepository(credentials);
                break;
            case SQLite:
                userRepository = new SQLiteUserRepository(plugin.getDataFolder() + "/users.db");
                break;
            default:
                throw new IllegalArgumentException("Invalid data source");
        }
        initializeRepositories();
    }

    private void initializeRepositories() {
        userRepository.initialize();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}