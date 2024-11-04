package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.Set;
import java.util.UUID;


public interface NametagModule<T,J>{

    void displayNametag(Set<T> viewers, T player, J nametag) ;
    void displayNametag(T player, J nametag) ;
    void resetNametag(Set<T> viewers, T player) ;
    void resetNametag(T player) ;

    void displayNametag(Set<T> viewers, UUID uniqueId, J nametag) ;
    void displayNametag(UUID uniqueId, J nametag) ;
    void resetNametag(Set<T> viewers, UUID uniqueId) ;
    void resetNametag(UUID uniqueId) ;


}
