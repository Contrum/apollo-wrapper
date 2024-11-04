package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.UUID;

/*
 * This file is part of the apollo-wrapper project.
 * Copyright (c) 2022-2024. Contrum Services
 * Created by txmydev on 24/10/2024
 * Website: contrum.org
*/
public interface TitleModule<T,J> {

    void sendTitle(T player, J title) ;
    void resetTitles(T player) ;

    void sendTitle(UUID uniqueId, J title) ;
    void resetTitles(UUID uniqueId) ;

}
