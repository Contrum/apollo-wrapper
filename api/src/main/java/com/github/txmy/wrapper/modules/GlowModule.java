package com.github.txmy.wrapper.modules;

import java.util.UUID;


public interface GlowModule<T, J> {

    void displayGlow(Iterable<? extends T> viewers, T player, J color);

    void resetGlow(Iterable<? extends T> viewers, T player);

    void displayGlow(Iterable<? extends T> viewers, UUID uniqueId, J color);

    void resetGlow(Iterable<? extends T> viewers, UUID uniqueId);

}
