package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
    private final NoCommunication plugin;

    public JoinQuitListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.joinMessage(Component.text("사람이 들어왔다.", NamedTextColor.GREEN));
        event.getPlayer().playerListName(Component.empty());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.quitMessage(Component.text("사람이 나갔다.", NamedTextColor.RED));
    }
}
