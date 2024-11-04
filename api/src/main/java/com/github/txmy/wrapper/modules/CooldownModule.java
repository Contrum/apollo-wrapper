package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface CooldownModule<T,J> {

    void displayCooldown(T player, J cooldown) ;
    void resetCooldown(T player, String name) ;
    void resetCooldowns(T player) ;

    void displayCooldown(UUID uniqueId, J cooldown) ;
    void resetCooldown(UUID uniqueId, String name) ;
    void resetCooldowns(UUID uniqueId) ;


}
