package io.github.osmanfurkan115.dailyrewards.storage.credentials;

public class DatabaseCredentials {
    private final String host;
    private final String port;
    private final String userName;
    private final String password;

    protected DatabaseCredentials(String host, String port, String userName, String password) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
