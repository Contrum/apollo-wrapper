package com.github.txmy.wrapper.lightweight.utils;

import com.github.txmy.wrapper.lightweight.Settings;
import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Message {

    private JsonObject object;

    private Message(JsonObject object) {
        this.object = object;
    }

    private Message() {
        this(new JsonObject());
    }

    public static Message newMessage() {
        return new Message();
    }

    public static Message of(JsonObject message) {
        return new Message(message);
    }

    public Message type(String type) {
        object.addProperty("@type", Settings.BASE_TYPE + type);
        return this;
    }

    public Message property(String property, JsonElement element) {
        object.add(property, element);
        return this;
    }

    public Message property(String property, String value) {
        object.addProperty(property, value);
        return this;
    }

    public Message property(String property, Number value) {
        object.addProperty(property, value);
        return this;
    }

    public Message property(String property, Boolean value) {
        object.addProperty(property, value);
        return this;
    }

    public Message property(String property, Character value) {
        object.addProperty(property, value);
        return this;
    }

    public JsonObject finish() {
        Preconditions.checkArgument(object.has("@type"), "missing @type property!");
        return object;
    }

    public Message icon(Icon icon) {
        icon.add(object);
        return this;
    }
}
