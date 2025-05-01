package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AdvancementListener implements Listener {
    private final NoCommunication plugin;

    public AdvancementListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAdvancement(PlayerAdvancementDoneEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.message(null); // 메시지를 아예 없앰
    }
}
