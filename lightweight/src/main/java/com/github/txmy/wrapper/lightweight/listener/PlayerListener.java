package com.github.txmy.wrapper.lightweight.listener;

import com.github.txmy.wrapper.Channels;
import com.github.txmy.wrapper.lightweight.Settings;
import com.github.txmy.wrapper.player.PlayerManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

@RequiredArgsConstructor
public class PlayerListener implements Listener {

    private final JavaPlugin plugin;
    private final PlayerManager<Player> playerManager;

    @EventHandler
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {
        Player player = event.getPlayer();
        String channel = event.getChannel();
        if (Settings.DEBUG) {
            Bukkit.getLogger().info(() -> String.format("[messenger] %s registered channel: %s", player.getName(), channel));
        }
        if (channel.startsWith(Channels.PLAYER_DETECTION_CHANNEL)) {
            player.setMetadata(PlayerManager.METADATA_KEY, new FixedMetadataValue(plugin, channel));
            playerManager.initPlayer(player);
        }
    }

    @EventHandler
    public void onPlayerUnRegisterChannel(PlayerUnregisterChannelEvent event) {
        Player player = event.getPlayer();
        String channel = event.getChannel();
        if (Settings.DEBUG) {
            Bukkit.getLogger().info(() -> String.format("[messenger] %s unregistered channel: %s", player.getName(), channel));
        }
        if (channel.startsWith(Channels.PLAYER_DETECTION_CHANNEL) && player.hasMetadata(PlayerManager.METADATA_KEY)) {
            player.removeMetadata(PlayerManager.METADATA_KEY, plugin);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.removeMetadata(PlayerManager.METADATA_KEY, plugin);
    }

}
