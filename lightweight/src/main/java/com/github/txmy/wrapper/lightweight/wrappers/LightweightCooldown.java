package com.github.txmy.wrapper.lightweight.wrappers;

import com.github.txmy.wrapper.lightweight.utils.Icon;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LightweightCooldown {

    private final String name;
    private final String duration;
    private final Icon icon;

}
