package io.github.osmanfurkan115.dailyrewards.parser;

import org.bukkit.configuration.ConfigurationSection;

public interface ConfigParser<T> {
    T parse(ConfigurationSection section);
}
