package io.github.osmanfurkan115.dailyrewards.storage.credentials;

public class MongoCredentials extends DatabaseCredentials {
    //TODO add mongo credentials

    private MongoCredentials(String host, String port, String userName, String password) {
        super(host, port, userName, password);
    }
}
