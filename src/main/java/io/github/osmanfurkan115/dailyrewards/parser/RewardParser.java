package io.github.osmanfurkan115.dailyrewards.parser;

import org.bukkit.configuration.ConfigurationSection;

public interface RewardParser<T> {
    T parse(ConfigurationSection section);
}
