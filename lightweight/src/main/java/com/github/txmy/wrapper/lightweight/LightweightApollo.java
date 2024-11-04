package com.github.txmy.wrapper.lightweight;


import com.github.txmy.wrapper.Channels;
import com.github.txmy.wrapper.lightweight.modules.*;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class LightweightApollo {

    private final LightweightPlayerManager playerManager;
    private final LightweightBeamModule beamModule;
    private final LightweightFireModule fireModule;
    private final LightweightBorderModule borderModule;
    private final LightweightChatModule chatModule;
    private final LightweightCooldownModule cooldownModule;
    private final LightweightGlowModule glowModule;

    public LightweightApollo(JavaPlugin plugin) {
        this.playerManager = new LightweightPlayerManager(plugin);

        PlayerUtils.setPlugin(plugin);

        this.beamModule = new LightweightBeamModule();
        this.fireModule = new LightweightFireModule();
        this.borderModule = new LightweightBorderModule();
        this.chatModule = new LightweightChatModule();
        this.cooldownModule = new LightweightCooldownModule();
        this.glowModule = new LightweightGlowModule();

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, Channels.PLAYER_LIGHTWEIGHT_CHANNEL);
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, Channels.PLAYER_LIGHTWEIGHT_CHANNEL, (s, player, bytes) -> {
        });
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, Channels.PLAYER_DETECTION_CHANNEL, (s, player, bytes) -> {
        });
    }


}
