package com.github.txmy.wrapper.lightweight.utils;

import com.github.txmy.wrapper.Channels;
import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;

@UtilityClass
public class PlayerUtils {

    private static JavaPlugin plugin;

    public static void setPlugin(JavaPlugin plugin) {
        if (PlayerUtils.plugin != null) {
            throw new RuntimeException("PlayerUtils#plugin already set!");
        }

        PlayerUtils.plugin = plugin;
    }


    public void send(Player player, JsonObject object) {
        player.sendPluginMessage(plugin, Channels.PLAYER_LIGHTWEIGHT_CHANNEL, object.toString().getBytes());
    }

    public void send(Iterable<? extends Player> viewers, JsonObject object) {
        viewers.forEach(viewer -> send(viewer, object));
    }

    public void attemptWithUuid(UUID uniqueId, Consumer<Player> consumer) {
        Player player = Bukkit.getPlayer(uniqueId);
        Preconditions.checkNotNull(player, String.format("Player with uuid '%s' is offline!", uniqueId.toString()));

        consumer.accept(player);
    }

}
