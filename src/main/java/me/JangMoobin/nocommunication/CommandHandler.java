package me.JangMoobin.nocommunication;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private final NoCommunication plugin;

    public CommandHandler(NoCommunication plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(Component.text("이 명령어는 관리자만 사용할 수 있습니다.", NamedTextColor.RED));
            return true;
        }

        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                plugin.reloadConfig();
                plugin.setEnabledPlugin(plugin.getConfig().getBoolean("enabled", true));
                sender.sendMessage(Component.text("설정을 다시 불러왔습니다.", NamedTextColor.GREEN));
                break;
            case "toggle":
                boolean newState = !plugin.isEnabledPlugin();
                plugin.setEnabledPlugin(newState);
                sender.sendMessage(Component.text("기능이 " + (newState ? "활성화" : "비활성화") + "되었습니다.", NamedTextColor.YELLOW));
                break;
            default:
                sendHelp(sender);
        }

        return true;
    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage(Component.text("/nocomm reload - 설정 다시 불러오기", NamedTextColor.GRAY));
        sender.sendMessage(Component.text("/nocomm toggle - 기능 켜기/끄기 전환", NamedTextColor.GRAY));
    }
}
