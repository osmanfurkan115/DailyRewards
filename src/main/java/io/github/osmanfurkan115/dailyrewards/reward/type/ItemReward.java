package io.github.osmanfurkan115.dailyrewards.reward.type;

import io.github.osmanfurkan115.dailyrewards.reward.parser.RewardParser;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemReward extends Reward implements RewardParser<ItemReward> {
    private final List<ItemStack> items;

    public ItemReward(ConfigurationSection section) {
        ItemReward reward = parse(section);
        this.items = reward.items;
    }

    public ItemReward(List<ItemStack> items) {
        this.items = items;
    }

    @Override
    public void give(Player player) {
        items.forEach(player.getInventory()::addItem);
    }

    @Override
    public ItemReward parse(ConfigurationSection section) {
        return null;
    }
}
