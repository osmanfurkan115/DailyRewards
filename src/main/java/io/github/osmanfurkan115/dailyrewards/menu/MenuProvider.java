package io.github.osmanfurkan115.dailyrewards.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class MenuProvider {
    private static MenuProvider instance;
    private final Map<UUID, Menu> menuRegistry = new HashMap<>();

    private MenuProvider() {
    }

    public static MenuProvider getInstance() {
        if (instance == null) instance = new MenuProvider();
        return instance;
    }

    public void addUUID(UUID uuid, Menu menu) {
        menuRegistry.put(uuid, menu);
    }

    public void removeUUID(UUID uuid) {
        menuRegistry.remove(uuid);
    }

    public boolean containsUUID(UUID uuid) {
        return menuRegistry.containsKey(uuid);
    }

    public Menu getMenu(UUID uuid) {
        return menuRegistry.get(uuid);
    }
}
