package io.github.osmanfurkan115.dailyrewards.hook;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook extends Hook {
    private Economy economy;

    public VaultHook() {
        super("Vault", false);
        if (isEnabled()) this.economy = this.setupEconomy();
    }

    public Economy getEconomy() {
        return this.economy;
    }

    private Economy setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        return rsp.getProvider();
    }
}
