package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightBorder;
import com.github.txmy.wrapper.modules.BorderModule;
import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.function.Consumer;

public class LightweightBorderModule implements BorderModule<Player, LightweightBorder> {
    private String borderType(String packet) {
        return "border.v1." + packet;
    }

    @Override
    public void displayBorder(Player player, LightweightBorder border) {
        PlayerUtils.send(player, Message.newMessage()
                .type(borderType("DisplayBorderMessage"))
                .property("id", border.getId())
                .property("world", border.getWorld())
                .property("cancel_entry", border.isCancelEntry())
                .property("cancel_exit", border.isCancelExit())
                .property("can_shrink_or_expand", border.isCanShrinkOrExpand())
                .property("color", border.getColor())
                .property("bounds", border.getBounds())
                .property("duration_ticks", border.getDurationTicks())
                .finish());
    }

    @Override
    public void resetBorder(Player player, String border) {
        PlayerUtils.send(player, Message.newMessage()
                .type(borderType("RemoveBorderMessage"))
                .property("id", border)
                .finish());
    }

    @Override
    public void resetBorders(Player player) {
        PlayerUtils.send(player, Message.newMessage()
                .type(borderType("ResetBordersMessage"))
                .finish());
    }

    @Override
    public void displayBorder(UUID uniqueId, LightweightBorder border) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> displayBorder(player, border));
    }

    @Override
    public void resetBorder(UUID uniqueId, String border) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> resetBorder(player, border));
    }

    @Override
    public void resetBorders(UUID uniqueId) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> resetBorders(player));
    }

    @Override
    public void displayBorder(LightweightBorder border) {
        Bukkit.getOnlinePlayers().forEach(player -> displayBorder(player, border));
    }

    @Override
    public void resetBorders() {
        Bukkit.getOnlinePlayers().forEach(this::resetBorders);
    }

    @Override
    public void resetBorder(String border) {
        Bukkit.getOnlinePlayers().forEach(player -> resetBorder(player, border));
    }
}
