package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightCooldown;
import com.github.txmy.wrapper.modules.CooldownModule;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LightweightCooldownModule implements CooldownModule<Player, LightweightCooldown> {
    @Override
    public void displayCooldown(Player player, LightweightCooldown cooldown) {
        PlayerUtils.send(player, Message.newMessage()
                .type("cooldown.v1.DisplayCooldownMessage")
                .property("name", cooldown.getName())
                .property("duration", cooldown.getDuration())
                .icon(cooldown.getIcon())
                .finish());
    }

    @Override
    public void resetCooldown(Player player, String name) {
        PlayerUtils.send(player, Message.newMessage()
                .type("cooldown.v1.RemoveCooldownMessage")
                .property("name", name)
                .finish());
    }

    @Override
    public void resetCooldowns(Player player) {
        PlayerUtils.send(player, Message.newMessage()
                .type("cooldown.v1.ResetCooldownsMessage")
                .finish());
    }

    @Override
    public void displayCooldown(UUID uniqueId, LightweightCooldown cooldown) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> displayCooldown(player, cooldown));
    }

    @Override
    public void resetCooldown(UUID uniqueId, String name) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> resetCooldown(player, name));
    }

    @Override
    public void resetCooldowns(UUID uniqueId) {
        PlayerUtils.attemptWithUuid(uniqueId, this::resetCooldowns);
    }
}
