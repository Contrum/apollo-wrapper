package com.github.txmy.wrapper.lightweight;


import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LightweightApolloWrapper {



    private JavaPlugin plugin;
    private LightweightPlayerManager playerManager;

    public LightweightApolloWrapper(JavaPlugin plugin) {
        this.plugin = plugin;
        this.playerManager = new LightweightPlayerManager(plugin);

        // this.playerManager.init();
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "apollo:json");

        PlayerUtils.setPlugin(plugin);
    }

    public void send(Player player, JsonObject object) {
        player.sendPluginMessage(plugin, "apollo:json", object.toString().getBytes());
    }
}
