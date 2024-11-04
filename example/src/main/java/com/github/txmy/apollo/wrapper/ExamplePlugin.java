package com.github.txmy.apollo.wrapper;

import com.github.txmy.wrapper.lightweight.LightweightApollo;
import com.github.txmy.wrapper.lightweight.utils.*;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightBeam;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightBorder;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightCooldown;
import com.github.txmy.wrapper.lightweight.wrappers.LightweightLiveMessage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.time.Duration;
import java.util.Arrays;

public class ExamplePlugin extends JavaPlugin implements Listener {

    private LightweightApollo apollo;

    @Override
    public void onEnable() {
        apollo = new LightweightApollo(this);

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        switch (event.getMessage()) {
            case "beam":
                player.getWorld().strikeLightningEffect(player.getLocation());

                apollo.getBeamModule().displayBeam(player, LightweightBeam.builder()
                        .location(Locations.ofBlock(player.getLocation()))
                        .id("test-beam")
                        .color(Colors.of(Color.BLUE))
                        .build());
                break;
            case "_beam":
                apollo.getBeamModule().resetBeam(player, "test-beam");
                break;
            case "2beam":
                apollo.getBeamModule().displayBeam(player, LightweightBeam.builder()
                        .location(Locations.ofBlock(player.getLocation()))
                        .id("test2-beam")
                        .color(Colors.of(Color.MAGENTA))
                        .build());
                break;
            case "_2beam":
                apollo.getBeamModule().resetBeam(player, "test2-beam");
                break;
            case "__beam":
                apollo.getBeamModule().resetBeams(player);
                break;
            case "livechat":
                new BukkitRunnable() {
                    int count = 0;

                    @Override
                    public void run() {
                        count++;
                        apollo.getChatModule().displayLiveChatMessage(player, LightweightLiveMessage.builder()
                                .id(1)
                                .text(Component.text("Hello, you have lived " + count + " seconds!").color(NamedTextColor.LIGHT_PURPLE))
                                .build());

                        if (count > 10) {
                            cancel();
                        }
                    }
                }.runTaskTimer(this, 20L, 20L);
                break;
            case "_livechat":
                apollo.getChatModule().removeLiveChatMessage(player, 1);
                break;
            case "cooldown":
                apollo.getCooldownModule().displayCooldown(player, LightweightCooldown.builder()
                        .name("test_cooldown")
                        .duration(Durations.of(Duration.ofSeconds(30)))
                        .icon(ItemIcon.of("GOLDEN_APPLE"))
                        /*.icon(ResourceIcon.simple()
                                .resourceLocation("lunar:logo/logo-200x182.svg")
                                .size(12)
                                .build())*/
                        .build());
                break;
            case "_cooldown":
                apollo.getCooldownModule().resetCooldown(player, "test_cooldown");
                break;
            case "glow":
                apollo.getGlowModule().displayGlow(Bukkit.getOnlinePlayers(), player, Color.GREEN);
                break;
            case "_glow":
                apollo.getGlowModule().resetGlow(Bukkit.getOnlinePlayers(), player);
                break;

            default:
                break;
        }

        String message = event.getMessage();
        if (message.startsWith("border")) {
            String[] split = message.split(" ");
            if (split.length == 0) {
                return;
            }

            split = Arrays.copyOfRange(split, 1, split.length);
            String world = split[0];
            int size = Integer.parseInt(split[1]);
            String hexColor = split[2];

            apollo.getBorderModule().displayBorder(player, LightweightBorder.builder()
                    .world(world)
                    .bounds(Cuboids.square(size).build())
                    .cancelEntry(false)
                    .cancelExit(true)
                    .canShrinkOrExpand(false)
                    .color(Colors.of(Color.decode(hexColor)))
                    .durationTicks(20000)
                    .build());
        }
    }
}
