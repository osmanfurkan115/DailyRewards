package io.github.osmanfurkan115.dailyrewards.menu.listener;

import io.github.osmanfurkan115.dailyrewards.menu.Menu;
import io.github.osmanfurkan115.dailyrewards.menu.MenuItem;
import io.github.osmanfurkan115.dailyrewards.menu.MenuProvider;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class MenuListener implements Listener {
    private final MenuProvider menuProvider = MenuProvider.getInstance();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        HumanEntity whoClicked = e.getWhoClicked();

        if (e.getClick().equals(ClickType.UNKNOWN)) return;
        if (e.getClickedInventory() == null || e.getClickedInventory().equals(whoClicked.getInventory())) return;
        if (!isOnMenu(whoClicked.getUniqueId())) return;
        e.setCancelled(true);

        Menu menu = menuProvider.getMenu(whoClicked.getUniqueId());
        MenuItem item = menu.getItem(e.getSlot());

        if (item == null) return;
        item.getClickAction().accept(e);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (!isOnMenu(player.getUniqueId())) return;

        Menu menu = menuProvider.getMenu(player.getUniqueId());
        if (menu.isCloseable()) {
            menuProvider.removeUUID(e.getPlayer().getUniqueId());
        } else {
            menu.open(player);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        menuProvider.removeUUID(e.getPlayer().getUniqueId());
    }

    private boolean isOnMenu(UUID uuid) {
        return menuProvider.containsUUID(uuid);
    }
}
