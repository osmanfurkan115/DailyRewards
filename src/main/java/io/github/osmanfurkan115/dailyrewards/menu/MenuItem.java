package io.github.osmanfurkan115.dailyrewards.menu;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class MenuItem {
    private final ItemStack itemStack;
    private final Consumer<InventoryClickEvent> clickAction;

    public MenuItem(ItemStack itemStack) {
        this(itemStack, (e) -> {});
    }

    public MenuItem(ItemStack itemStack, Consumer<InventoryClickEvent> clickAction) {
        this.itemStack = itemStack;
        this.clickAction = clickAction;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Consumer<InventoryClickEvent> getClickAction() {
        return clickAction;
    }

    @Override
    public MenuItem clone() {
        try {
            return (MenuItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
