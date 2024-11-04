package com.github.txmy.wrapper.errors;

public class InvalidMinecraftClient extends RuntimeException {
  public InvalidMinecraftClient(String message) {
    super(message);
  }
}
