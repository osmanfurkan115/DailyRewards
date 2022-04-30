package io.github.osmanfurkan115.dailyrewards.menu;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {
    private final Inventory inventory;
    private final MenuProvider menuProvider = MenuProvider.getInstance();
    private final Map<Integer, MenuItem> menuItems = new HashMap<>();

    public Menu() {
        this.inventory = Bukkit.createInventory(null, getSize(), getTitle());
    }

    public abstract String getTitle();

    public abstract int getSize();

    public abstract boolean isCloseable();

    public abstract ConfigurationSection getMenuSection();

    public Inventory getInventory() {
        return inventory;
    }

    public MenuItem getItem(int slot) {
        return menuItems.get(slot);
    }

    protected void setItem(int slot, @NotNull MenuItem item) {
        inventory.setItem(slot, item.getItemStack());
        menuItems.put(slot, item);
    }

    protected void addItem(@NotNull MenuItem menuItem) {
        setItem(inventory.firstEmpty(), menuItem);
    }

    protected void fill(@NotNull MenuItem item) {
        for (int i = 0; i < inventory.getSize(); i++) {
            setItem(i, item);
        }
    }

    protected abstract void setupMenu();

    public void open(Player player) {
        setupMenu();
        player.openInventory(inventory);
        menuProvider.addUUID(player.getUniqueId(), this);
    }
}
