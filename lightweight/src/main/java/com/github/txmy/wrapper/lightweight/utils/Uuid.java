package com.github.txmy.wrapper.lightweight.utils;

import com.google.gson.JsonObject;
import org.bukkit.entity.Player;

import java.util.UUID;

public final class Uuid {

    private Uuid() {}

    public static JsonObject of(UUID uniqueId) {
        JsonObject object = new JsonObject();
        object.addProperty("high64", Long.toUnsignedString(uniqueId.getMostSignificantBits()));
        object.addProperty("low64", Long.toUnsignedString(uniqueId.getLeastSignificantBits()));
        return object;
    }

    public static JsonObject of(Player player) {
        return of(player.getUniqueId());
    }
}
