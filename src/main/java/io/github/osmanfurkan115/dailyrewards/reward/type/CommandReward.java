package io.github.osmanfurkan115.dailyrewards.reward.type;

import io.github.osmanfurkan115.dailyrewards.parser.RewardParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandReward extends Reward implements RewardParser<CommandReward> {
    private final List<String> commands;

    public CommandReward(ConfigurationSection section) {
        CommandReward reward = parse(section);
        this.commands = reward.commands;
    }

    public CommandReward(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public void give(Player player) {
        for (String command : commands) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName()));
        }
    }

    @Override
    public CommandReward parse(ConfigurationSection section) {
        List<String> commands = section.getStringList("commands");
        return new CommandReward(commands);
    }
}
