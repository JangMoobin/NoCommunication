package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NameTagListener implements Listener {

    private final NoCommunication plugin;

    public NameTagListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.getPlayer().playerListName(Component.empty());
    }
}
