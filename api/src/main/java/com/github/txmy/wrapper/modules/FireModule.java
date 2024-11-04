package com.github.txmy.wrapper.modules;

import java.awt.*;
import java.util.Collection;
import java.util.UUID;


public interface FireModule<T> {

    void changeFireColor(Collection<T> viewers, T player, Color color);

    void resetFireColor(Collection<T> viewers, T player);

    void changeFireColor(Collection<T> viewers, UUID uniqueId, Color color);

    void resetFireColor(Collection<T> viewers, UUID uniqueId);

    void resetFireForEveryone(Collection<T> viewers);
}
