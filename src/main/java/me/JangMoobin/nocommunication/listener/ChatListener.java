package me.JangMoobin.nocommunication.listener;

import me.JangMoobin.nocommunication.NoCommunication;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import io.papermc.paper.event.player.AsyncChatEvent;

public class ChatListener implements Listener {
    private final NoCommunication plugin;

    public ChatListener(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        if (!plugin.isEnabledPlugin()) return;

        event.setCancelled(true);
        event.getPlayer().sendMessage(Component.text("채팅이 금지되었습니다.", NamedTextColor.RED));
    }
}
