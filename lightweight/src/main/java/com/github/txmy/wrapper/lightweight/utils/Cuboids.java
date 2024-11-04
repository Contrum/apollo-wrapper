package com.github.txmy.wrapper.lightweight.utils;

import com.google.gson.JsonObject;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = true)
@Setter
public class Cuboids {

    public static Cuboids newCuboid() {
        return new Cuboids();
    }

    public static Cuboids square(int size) {
        return new Cuboids(size);
    }


    private Cuboids() {
    }
    private Cuboids(int size) {
        this.maxX = size;
        this.minX = -size;
        this.maxZ = size;
        this.minZ = -size;
    }


    private double maxX;
    private double minX;
    private double maxZ;
    private double minZ;

    public JsonObject build() {
        JsonObject object = new JsonObject();
        object.addProperty("max_x", maxX);
        object.addProperty("min_x", minX);
        object.addProperty("max_z", maxZ);
        object.addProperty("min_z", minZ);
        return object;
    }

}
