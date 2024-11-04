package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.lightweight.utils.Colors;
import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.utils.Uuid;
import com.github.txmy.wrapper.modules.FireModule;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Collection;
import java.util.UUID;

public class LightweightFireModule implements FireModule<Player> {
    @Override
    public void changeFireColor(Collection<Player> viewers, Player player, Color color) {
        changeFireColor(viewers, player.getUniqueId(), color);
    }

    @Override
    public void resetFireColor(Collection<Player> viewers, Player player) {
        resetFireColor(viewers, player.getUniqueId());
    }

    @Override
    public void changeFireColor(Collection<Player> viewers, UUID uniqueId, Color color) {
        PlayerUtils.send(viewers, Message.newMessage()
                .type("coloredfire.v1.OverrideColoredFireMessage")
                .property("player_uuid", Uuid.of(uniqueId))
                .property("color", Colors.of(color))
                .finish());
    }

    @Override
    public void resetFireColor(Collection<Player> viewers, UUID uniqueId) {
        PlayerUtils.send(viewers, Message.newMessage()
                .type("coloredfire.v1.ResetColoredFireMessage")
                .property("player_uuid", Uuid.of(uniqueId))
                .finish());
    }

    @Override
    public void resetFireForEveryone(Collection<Player> viewers) {
        PlayerUtils.send(viewers, Message.newMessage()
                .type("coloredfire.v1.ResetColoredFiresMessage")
                .finish());
    }
}
