package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface BeamModule<T,J> {

    void displayBeam(T player, J beam) ;
    void resetBeams(T player) ;
    void resetBeam(T player, String id) ;

    void displayBeam(UUID uniqueId, J beam) ;
    void resetBeams(UUID uniqueId) ;
    void resetBeam(UUID uniqueId, String id) ;

}
