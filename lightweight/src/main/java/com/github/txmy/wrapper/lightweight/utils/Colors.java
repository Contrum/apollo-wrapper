package com.github.txmy.wrapper.lightweight.utils;

import com.google.gson.JsonObject;

public final class Colors {

    private Colors() {}

    public static JsonObject of(java.awt.Color color) {
        JsonObject object = new JsonObject();
        object.addProperty("color", color.getRGB());
        return object;
    }

}
