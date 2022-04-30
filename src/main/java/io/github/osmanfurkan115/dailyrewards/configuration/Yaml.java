package io.github.osmanfurkan115.dailyrewards.configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Yaml extends YamlConfiguration {
    private final JavaPlugin plugin;
    private final File file;

    public Yaml(JavaPlugin plugin, String fileName) {
        this(plugin, new File(plugin.getDataFolder(), fileName));
    }

    public Yaml(JavaPlugin plugin, File file) {
        this.plugin = plugin;
        this.file = file;

        createFile();
    }

    public void createFile() {
        if (!exists()) {
            if (!file.getParentFile().mkdirs()) throw new IllegalStateException("Could not create directories for " + file);
            plugin.saveResource(file.getName(), false);
        }
        reload();
    }

    public void reload() {
        try {
            load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean exists() {
        return file.exists();
    }
}