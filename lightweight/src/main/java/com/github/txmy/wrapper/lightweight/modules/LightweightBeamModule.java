package com.github.txmy.wrapper.lightweight.modules;

import com.github.txmy.wrapper.errors.InvalidMinecraftClient;
import com.github.txmy.wrapper.lightweight.utils.Message;
import com.github.txmy.wrapper.lightweight.utils.PlayerUtils;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightBeam;
import com.github.txmy.wrapper.modules.BeamModule;
import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LightweightBeamModule implements BeamModule<Player, LightweightBeam> {
    private static final String TYPE = "beam.v1.";

    private String beamMessage(String packet) {
        return TYPE + packet;
    }

    @Override
    public void displayBeam(Player player, LightweightBeam beam)  {
        PlayerUtils.send(player, Message.newMessage()
                .type(beamMessage("DisplayBeaconBeamMessage"))
                .property("id", beam.getId())
                .property("color", beam.getColor())
                .property("location", beam.getLocation())
                .finish());
    }

    @Override
    public void resetBeams(Player player)  {
        PlayerUtils.send(player, Message.newMessage()
                .type(beamMessage("ResetBeaconBeamsMessage"))
                .finish());
    }

    @Override
    public void resetBeam(Player player, String id)  {
        PlayerUtils.send(player, Message.newMessage()
                .type(beamMessage("RemoveBeaconBeamMessage"))
                .property("id", id)
                .finish());
    }

    @Override
    public void displayBeam(UUID uniqueId, LightweightBeam beam)  {
        Player player = Bukkit.getPlayer(uniqueId);
        Preconditions.checkNotNull(player, "player is null!");

        displayBeam(player, beam);
    }

    @Override
    public void resetBeams(UUID uniqueId)  {
        Player player = Bukkit.getPlayer(uniqueId);
        Preconditions.checkNotNull(player, "player is null!");
        resetBeams(player);
    }

    @Override
    public void resetBeam(UUID uniqueId, String id)  {
        Player player = Bukkit.getPlayer(uniqueId);
        Preconditions.checkNotNull(player, "player is null!");

        resetBeam(player, id);
    }
}
