package com.github.txmy.wrapper.lightweight;

import com.github.txmy.wrapper.lightweight.listener.PlayerListener;
import com.github.txmy.wrapper.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.function.Consumer;


public class LightweightPlayerManager implements PlayerManager<Player> {

    public LightweightPlayerManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerListener(plugin, this), plugin);
    }

    @Override
    public boolean isRunningClient(UUID uniqueId) {
        return isRunningClient(Bukkit.getPlayer(uniqueId));
    }

    @Override
    public boolean isRunningClient(Player player) {
        return player.hasMetadata(PlayerManager.METADATA_KEY);
    }

    @Override
    public void perform(UUID uniqueId, Consumer<Player> consumer) {
        Player player = Bukkit.getPlayer(uniqueId);
        if (player != null) {
            consumer.accept(player);
        }
    }

    @Override
    public void performForEveryone(Consumer<Player> consumer) {
        Bukkit.getOnlinePlayers().stream().filter(this::isRunningClient).forEach(consumer);
    }

    @Override
    public void initPlayer(Player player) {
        LightweightModules.enableModules(player);
    }

}
