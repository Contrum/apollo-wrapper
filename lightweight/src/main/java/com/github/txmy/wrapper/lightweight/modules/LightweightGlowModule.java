package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.lightweight.utils.Colors;
import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.utils.Uuid;
import com.github.txmy.wrapper.modules.GlowModule;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.UUID;

public class LightweightGlowModule implements GlowModule<Player, Color> {

    @Override
    public void displayGlow(Iterable<? extends Player> viewers, Player player, Color color) {
        displayGlow(viewers, player.getUniqueId(), color);
    }

    @Override
    public void resetGlow(Iterable<? extends Player> viewers, Player player) {
        resetGlow(viewers, player.getUniqueId());
    }

    @Override
    public void displayGlow(Iterable<? extends Player> viewers, UUID uniqueId, Color color) {
        PlayerUtils.send(viewers, Message.newMessage()
                .type("glow.v1.OverrideGlowEffectMessage")
                .property("player_uuid", Uuid.of(uniqueId))
                .property("color", Colors.of(color))
                .finish());
    }

    @Override
    public void resetGlow(Iterable<? extends Player> viewers, UUID uniqueId) {
        PlayerUtils.send(viewers, Message.newMessage()
                .type("glow.v1.ResetGlowEffectMessage")
                .property("player_uuid", Uuid.of(uniqueId))
                .finish());
    }


}
