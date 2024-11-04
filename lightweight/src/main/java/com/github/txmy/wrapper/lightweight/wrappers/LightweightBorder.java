package com.github.txmy.wrapper.lightweight.wrappers;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class LightweightBorder {

    private String id;
    private String world;
    private boolean cancelEntry;
    private boolean cancelExit;
    private boolean canShrinkOrExpand;
    private JsonObject color;
    private JsonObject bounds;
    private int durationTicks;

}
