package com.github.txmy.wrapper.modules;

import java.util.Set;


public interface ServerRulesModule<T> {

    void setAntiPortalTraps(boolean value);
    void setNametagRenderDistance(Set<T> viewers, int distance);
    void setNametagRenderDistance(int distance);
    void setDisableShaders(boolean value);
    void setDisableShaders(Set<T> viewers,boolean value);
    void setDisableChunkReloading(boolean value);
    void setDisableChunkReloading(Set<T> viewers,boolean value);
    void setDisableBroadcastKeybind(boolean value);
    void setDisableBroadcastKeybind(Set<T> viewers,boolean value);
    void setOverrideBrightness(boolean value);
    void setOverrideBrightness(Set<T> viewers,boolean value);
    void setBrightness(Set<T> players, int brightness);
    void setBrightness(int brightness);

}
