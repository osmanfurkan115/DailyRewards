package io.github.osmanfurkan115.dailyrewards.util;

import org.bukkit.ChatColor;

public final class ColorUtils {
    private ColorUtils() {
    }

    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
