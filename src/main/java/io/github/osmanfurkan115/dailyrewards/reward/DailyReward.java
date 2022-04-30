package io.github.osmanfurkan115.dailyrewards.reward;

import io.github.osmanfurkan115.dailyrewards.reward.type.Reward;

import java.util.ArrayList;
import java.util.List;

public class DailyReward {
    private final List<Reward> rewards = new ArrayList<>();
    private final int day;

    public DailyReward(int day) {
        this.day = day;
    }

    public void addReward(Reward reward) {
        this.rewards.add(reward);
    }

    public List<Reward> getRewards() {
        return this.rewards;
    }

    public int getDay() {
        return this.day;
    }
}
