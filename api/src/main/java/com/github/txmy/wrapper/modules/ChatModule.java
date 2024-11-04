package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface ChatModule<T,J> {

    void displayLiveChatMessage(T player, J message) ;
    void removeLiveChatMessage(T player, int messageId) ;

    void displayLiveChatMessage(UUID uniqueId, J message) ;
    void removeLiveChatMessage(UUID uniqueId, int messageId) ;

}
