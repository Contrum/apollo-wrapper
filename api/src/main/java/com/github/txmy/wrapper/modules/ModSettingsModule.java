package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface ModSettingsModule<T,J> {

    void setModEnabled(T player, J mod, boolean value) ;
    void setModEnabled(J mod, boolean value) ;
    void setModEnabled(UUID uniqueId, J mod, boolean value) ;

}
