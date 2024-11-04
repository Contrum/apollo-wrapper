package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightLiveMessage;
import com.github.txmy.wrapper.modules.ChatModule;
import com.google.common.base.Preconditions;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LightweightChatModule implements ChatModule<Player, LightweightLiveMessage> {
    @Override
    public void displayLiveChatMessage(Player player, LightweightLiveMessage message) {
        Preconditions.checkNotNull(message, "Message cannot be null!");

        PlayerUtils.send(player, Message.newMessage()
                .type("chat.v1.DisplayLiveChatMessageMessage")
                .property("message_id", message.getId())
                .property("adventure_json_lines", GsonComponentSerializer.gson().serialize(message.getText()))
                .finish());
    }

    @Override
    public void removeLiveChatMessage(Player player, int messageId) {
        PlayerUtils.send(player, Message.newMessage()
                .type("chat.v1.RemoveLiveChatMessageMessage")
                .property("message_id", messageId)
                .finish());
    }


    @Override
    public void displayLiveChatMessage(UUID uniqueId, LightweightLiveMessage message) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> displayLiveChatMessage(player, message));
    }

    @Override
    public void removeLiveChatMessage(UUID uniqueId, int messageId) {
        PlayerUtils.attemptWithUuid(uniqueId, player -> removeLiveChatMessage(player, messageId));
    }
}
