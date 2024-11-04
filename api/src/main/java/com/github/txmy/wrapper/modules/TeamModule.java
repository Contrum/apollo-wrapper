package com.github.txmy.wrapper.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;

import java.util.Set;
import java.util.UUID;


public interface TeamModule<T,J> {

    void sendTeamMembers(T player, J... teamMembers) ;
    void sendTeamMembers(T player, Set<J> teamMembers) ;
    void resetTeamMembers(T player) ;
    void sendTeamMembers(UUID uniqueId, J... teamMembers) ;
    void sendTeamMembers(UUID uniqueId, Set<J> teamMembers) ;
    void resetTeamMembers(UUID uniqueId) ;

}
