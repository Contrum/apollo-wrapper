package com.github.txmy.wrapper.errors;

public class InvalidMinecraftClient extends IllegalArgumentException {
    public InvalidMinecraftClient(String message) {
        super(message);
    }
}
