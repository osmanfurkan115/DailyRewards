package io.github.osmanfurkan115.dailyrewards.storage;

public enum DataSource {
    MySQL,
    SQLite;

    public static DataSource getDataSourceByName(String name) {
        for (DataSource dataSource : values()) {
            if (dataSource.name().equalsIgnoreCase(name)) {
                return dataSource;
            }
        }
        return DataSource.SQLite;
    }
}
