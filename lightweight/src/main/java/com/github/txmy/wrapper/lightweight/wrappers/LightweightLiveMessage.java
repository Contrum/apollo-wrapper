package com.github.txmy.wrapper.lightweight.wrappers;


import lombok.Builder;
import lombok.Getter;
import net.kyori.adventure.text.Component;

@Builder
@Getter
public class LightweightLiveMessage {

    private int id;
    private Component text;

}
