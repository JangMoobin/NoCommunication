package me.JangMoobin.nocommunication;

import me.JangMoobin.nocommunication.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

public class NoCommunication extends JavaPlugin {

    private boolean enabled;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // config에서 상태 불러오기
        enabled = getConfig().getBoolean("enabled", true);

        registerEvents();
        getCommand("nocomm").setExecutor(new CommandHandler(this));
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new AdvancementListener(this), this);
        getServer().getPluginManager().registerEvents(new NameTagListener(this), this);
    }

    public boolean isEnabledPlugin() {
        return enabled;
    }

    public void setEnabledPlugin(boolean enabled) {
        this.enabled = enabled;
        // config에도 반영
        getConfig().set("enabled", enabled);
        saveConfig();
    }
}
