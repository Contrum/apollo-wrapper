package com.github.txmy.wrapper.lightweight.utils;

import com.google.gson.JsonObject;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class Locations {

    private Locations() {
    }

    private static JsonObject of(Location location, boolean doubles) {
        JsonObject object = new JsonObject();
        object.addProperty("world", location.getWorld().getName());
        object.addProperty("x", doubles ? location.getX() : location.getBlockX());
        object.addProperty("y", doubles ? location.getY() : location.getBlockY());
        object.addProperty("z", doubles ? location.getZ() : location.getBlockZ());
        return object;
    }


    public static JsonObject ofPlayer(Location location) {
        JsonObject object = new JsonObject();

        JsonObject locationObject = of(location, true);
        object.add("location", locationObject);
        object.addProperty("yaw", location.getYaw());
        object.addProperty("pitch", location.getPitch());

        return object;
    }

    public static JsonObject ofPlayer(Player player) {
        return ofPlayer(player.getLocation());
    }

    public static JsonObject ofBlock(Location location) {
        return of(location, false);
    }
}
