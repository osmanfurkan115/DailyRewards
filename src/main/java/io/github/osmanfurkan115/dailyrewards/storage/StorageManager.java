package io.github.osmanfurkan115.dailyrewards.storage;

import io.github.osmanfurkan115.dailyrewards.storage.credentials.SQLCredentials;
import io.github.osmanfurkan115.dailyrewards.storage.user.MySQLUserRepository;
import io.github.osmanfurkan115.dailyrewards.storage.user.UserRepository;

public class StorageManager {
    private final UserRepository userRepository;

    public StorageManager(DataSource dataSource) {
        switch (dataSource) {
            case MySQL:
                SQLCredentials credentials = new SQLCredentials.Builder() //TODO get credentials from config
                        .userName("root")
                        .password("root")
                        .database("dailyrewards")
                        .host("localhost")
                        .port("3306")
                        .build();
                userRepository = new MySQLUserRepository(credentials);

                break;
            default:
                throw new IllegalArgumentException("Invalid data source");
        }
    }

    private void initializeRepositories() {
        userRepository.initialize();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}