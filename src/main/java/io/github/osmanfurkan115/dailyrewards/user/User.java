package io.github.osmanfurkan115.dailyrewards.user;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class User {
    private final UUID uuid;
    private int lastDay = 0;
    private long nextReward = System.currentTimeMillis();

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public User(UUID uuid, int lastDay, long nextReward) {
        this.uuid = uuid;
        this.lastDay = lastDay;
        this.nextReward = nextReward;
    }

    public boolean canTakeReward() {
        return System.currentTimeMillis() >= nextReward;
    }

    public UUID getUUID() {
        return uuid;
    }

    public int getLastDay() {
        return lastDay;
    }

    public void setLastDay() {
        this.lastDay++;
    }

    public long getNextReward() {
        return nextReward;
    }

    public void setNextReward() {
        this.nextReward = nextReward + TimeUnit.DAYS.toMillis(1);
    }
}
