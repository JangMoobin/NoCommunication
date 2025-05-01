package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final NoCommunication plugin;

    public DeathListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.deathMessage(Component.text("사람이 죽었다.", NamedTextColor.RED));
    }
}
