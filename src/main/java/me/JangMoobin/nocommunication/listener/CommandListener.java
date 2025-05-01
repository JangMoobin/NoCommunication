package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class CommandListener implements Listener {
    private final NoCommunication plugin;

    private final List<String> blockedCommands = Arrays.asList(
            "/tell", "/msg", "/w", "/me", "/teammsg", "/tm", "/minecraft:tell", "/minecraft:msg", "/minecraft:w"
    );

    public CommandListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        String message = event.getMessage().toLowerCase().split(" ")[0];
        if (blockedCommands.contains(message)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Component.text("채팅이 금지되었습니다.", NamedTextColor.RED));
        }
    }
}
