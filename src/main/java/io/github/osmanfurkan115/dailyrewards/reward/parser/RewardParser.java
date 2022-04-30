package io.github.osmanfurkan115.dailyrewards.reward.parser;

import org.bukkit.configuration.ConfigurationSection;

public interface RewardParser<T> {
    T parse(ConfigurationSection section);
}
