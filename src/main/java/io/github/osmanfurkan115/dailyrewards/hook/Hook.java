package io.github.osmanfurkan115.dailyrewards.hook;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

class Hook {
    private final String pluginName;
    private final boolean required;
    private final boolean enabled;

    public Hook(String pluginName, boolean required) {
        this.pluginName = pluginName;
        this.required = required;
        this.enabled = Bukkit.getPluginManager().isPluginEnabled(pluginName);
        checkHook();
    }

    private void checkHook() {
        Logger logger = Bukkit.getLogger();
        if (enabled) {
            logger.info(pluginName + " hook initialized.");
        } else if (required) {
            Bukkit.getServer().shutdown();
            logger.severe(pluginName + " plugin is required!");
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
}
