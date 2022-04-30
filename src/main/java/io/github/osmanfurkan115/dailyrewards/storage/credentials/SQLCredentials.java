package io.github.osmanfurkan115.dailyrewards.storage.credentials;

public class SQLCredentials extends DatabaseCredentials {
    private final String database;

    private SQLCredentials(String host, String port, String userName, String password, String database) {
        super(host, port, userName, password);
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }

    public static final class Builder {
        private String host;
        private String port;
        private String userName;
        private String password;
        private String database;

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public SQLCredentials build() {
            return new SQLCredentials(host, port, userName, password, database);
        }
    }
}
