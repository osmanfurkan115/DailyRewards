package io.github.osmanfurkan115.dailyrewards.storage.user;

import com.zaxxer.hikari.HikariDataSource;
import io.github.osmanfurkan115.dailyrewards.storage.credentials.SQLCredentials;
import io.github.osmanfurkan115.dailyrewards.user.User;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SQLiteUserRepository implements UserRepository {
    private static final String TABLE_NAME = "users";

    private final HikariDataSource dataSource = new HikariDataSource();
    private final String path;

    public SQLiteUserRepository(String path) {
        this.path = path;
        initialize();
    }

    @Override
    public void initialize() {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        dataSource.setJdbcUrl(String.format("jdbc:sqlite:%s", path));

        runAsync(() -> {
            try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
                String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s" +
                        "(uuid VARCHAR(255) NOT NULL PRIMARY KEY," +
                        "day INT NOT NULL," +
                        "nextReward BIGINT NOT NULL", TABLE_NAME);
                statement.execute(sqlQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public CompletableFuture<List<User>> findAll() {
        return supplyAsync(() -> {
            try (Statement statement = getConnection().createStatement()) {
                List<User> users = new ArrayList<>();

                ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", TABLE_NAME));
                while (resultSet.next()) {
                    User user = new User(UUID.fromString(resultSet.getString("uuid")),
                            resultSet.getInt("day"),
                            resultSet.getLong("nextReward"));
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    @Override
    public CompletableFuture<Optional<User>> findById(UUID id) {
        return supplyAsync(() -> {
            try (Statement statement = getConnection().createStatement()) {
                ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s WHERE uuid = '%s'",
                        TABLE_NAME, id.toString()));
                if (resultSet.next()) {
                    User user = new User(UUID.fromString(resultSet.getString("uuid")),
                            resultSet.getInt("day"),
                            resultSet.getLong("nextReward"));
                    return Optional.of(user);
                }
                return Optional.empty();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        });
    }

    @Override
    public void save(User data) {
        runAsync(() -> {
            try (Statement statement = getConnection().createStatement()) {
                String sqlQuery = String.format("INSERT INTO %s (uuid, day, nextReward) VALUES ('%s', %d, %d)"
                        ,TABLE_NAME, data.getUUID().toString(), data.getLastDay(), data.getNextReward());
                statement.execute(sqlQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void saveAll(List<User> data) {
        data.forEach(this::save);
    }

    @Override
    public void delete(UUID uuid) {
        runAsync(() -> {
            try (Statement statement = getConnection().createStatement()) {
                String sqlQuery = String.format("DELETE FROM %s WHERE uuid = '%s'", TABLE_NAME, uuid.toString());
                statement.execute(sqlQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<List<User>> findUserByDay(int day) {
        return supplyAsync(() -> {
            try (Statement statement = getConnection().createStatement()) {
                List<User> users = new ArrayList<>();

                String sqlQuery = String.format("SELECT * FROM %s WHERE day = %d", TABLE_NAME, day);
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    User user = new User(UUID.fromString(resultSet.getString("uuid")),
                            resultSet.getInt("day"),
                            resultSet.getLong("nextReward"));
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }
}
