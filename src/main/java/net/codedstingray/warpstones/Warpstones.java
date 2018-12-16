package net.codedstingray.warpstones;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "warpstones",
        name = "Warpstones",
        description = "A plugin that allows players to find and build warpstones and warp to them at a certain cost in items or xp.",
        url = "www.CodedStingray.net",
        authors = {
                "CodedStingray"
        }
)
public class Warpstones {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Hello there! Warpstones here!");
    }
}
