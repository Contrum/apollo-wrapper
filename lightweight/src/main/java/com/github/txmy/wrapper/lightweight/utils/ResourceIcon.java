package com.github.txmy.wrapper.lightweight.utils;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter(AccessLevel.PROTECTED)
public class ResourceIcon extends Icon {

    private String resourceLocation;
    private boolean advanced;
    // Simple
    private int size;
    // Advanced
    private float width;
    private float height;
    private float minU;
    private float maxU;
    private float minV;
    private float maxV;

    protected ResourceIcon() {
    }

    public static AdvancedBuilder advanced() {
        return new AdvancedBuilder();
    }

    public static SimpleBuilder simple() {
        return new SimpleBuilder();
    }

    @Getter
    @Setter
    @Accessors(fluent = true, chain = true)
    public static class AdvancedBuilder {
        private String resourceLocation;
        private float width;
        private float height;
        private float minU;
        private float maxU;
        private float minV;
        private float maxV;

        private AdvancedBuilder() {
        }

        public ResourceIcon build() {
            ResourceIcon icon = new ResourceIcon();
            icon.setAdvanced(true);
            icon.setResourceLocation(resourceLocation);
            icon.setWidth(width);
            icon.setHeight(height);
            icon.setMinU(minU);
            icon.setMaxU(maxU);
            icon.setMinV(minV);
            icon.setMaxV(maxV);
            return icon;
        }
    }

    @Getter
    @Setter
    @Accessors(fluent = true, chain = true)
    public static class SimpleBuilder {
        private String resourceLocation;
        private int size;

        private SimpleBuilder() {
        }

        public ResourceIcon build() {
            ResourceIcon icon = new ResourceIcon();
            icon.setResourceLocation(resourceLocation);
            icon.setSize(size);
            return icon;
        }
    }

    private JsonObject build() {
        Preconditions.checkNotNull(resourceLocation, "Resource Location must be specified!");

        JsonObject object = new JsonObject();
        object.addProperty("resource_location", resourceLocation);
        if (advanced) {
            Preconditions.checkArgument(width > 0, "Width must be greater than 0!");
            Preconditions.checkArgument(height > 0, "Height must be greater than 0!");
            Preconditions.checkArgument(minU >= 0.0 && minU <= 1.0, "minU must be in the range 0-1!");
            Preconditions.checkArgument(maxU >= 0.0 && maxU <= 1.0, "minU must be in the range 0-1!");
            Preconditions.checkArgument(minV >= 0.0 && minV <= 1.0, "minV must be in the range 0-1!");
            Preconditions.checkArgument(maxV >= 0.0 && maxV <= 1.0, "maxV must be in the range 0-1!");

            object.addProperty("width", width);
            object.addProperty("height", height);
            object.addProperty("min_u", minU);
            object.addProperty("max_u", maxU);
            object.addProperty("min_v", minV);
            object.addProperty("max_v", maxV);
        } else {
            Preconditions.checkArgument(size > 0, "Size must be greater than 0!");
            object.addProperty("size", size);
        }

        return object;
    }

    public void add(JsonObject object) {
        JsonObject wrapper = new JsonObject();
        wrapper.add(advanced ? "advanced_resource_location" : "simple_resource_location", build());
        object.add("icon", wrapper);
    }


}
