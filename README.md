# NoCommunication Plugin

**NoCommunication** is a minimalist Paper plugin for Minecraft 1.21.5 that disables all forms of player communication and suppresses certain server messages.

## 🔧 Features

- 🚫 Blocks all player chat messages and certain commands like `/tell`, `/msg`, `/w`, etc.
- 💀 Overrides death messages with a fixed red message: `"사람이 죽었다."`
- 🏆 Suppresses advancement (achievement) messages completely.
- 👥 Hides player names from the tab list.
- 🔔 Custom join and quit messages:
    - Green join message: `"사람이 들어왔다."`
    - Red quit message: `"사람이 나갔다."`
- 🔄 Admin commands to reload config and toggle the plugin on/off.

## 🧠 Commands

| Command             | Description                         | Permission |
|--------------------|-------------------------------------|------------|
| `/nocomm toggle`   | Toggles the plugin on or off        | OP only    |
| `/nocomm reload`   | Reloads the config                  | OP only    |

## 📁 Configuration

`config.yml`:

```yaml
enabled: true
