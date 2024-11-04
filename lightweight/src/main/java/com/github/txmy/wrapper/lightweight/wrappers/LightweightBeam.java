package com.github.txmy.wrapper.lightweight.wrappers;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LightweightBeam {

    private String id;
    private JsonObject color;
    private JsonObject location;

}
