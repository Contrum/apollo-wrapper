package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface StaffModule<T> {

    void enableStaffMods(T player) ;
    void enableStaffMods(UUID uniqueId) ;

    void disableStaffMods(T player) ;
    void disableStaffMods(UUID uniqueId) ;


}
