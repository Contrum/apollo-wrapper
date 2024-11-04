package com.github.txmy.wrapper.player;

import java.util.UUID;
import java.util.function.Consumer;


public interface PlayerManager<T> {

    String METADATA_KEY = "apw_lunar";

    boolean isRunningClient(UUID uniqueId);
    boolean isRunningClient(T player);

    void perform(UUID uniqueId, Consumer<T> consumer);
    void performForEveryone(Consumer<T> consumer);

    void initPlayer(T player);

}
