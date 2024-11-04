package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;


public interface NotificationModule<T,J>{

    void displayNotification(T player, J notification) ;
    void resetNotifications(T player) ;

    void displayNotifications(UUID uniqueId, J notification) ;
    void resetNotifications(UUID uniqueId) ;
}
