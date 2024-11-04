package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface DiscordPresenceModule<T,J> {

    void sendServerRichPresence(T player, J presence) ;
    void resetServerRichPresence(T player) ;

    void sendServerRichPresence(UUID uniqueId, J presence) ;
    void resetServerRichPresence(UUID uniqueId) ;
}
