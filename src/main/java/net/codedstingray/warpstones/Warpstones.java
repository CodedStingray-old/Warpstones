package net.codedstingray.warpstones;

import com.google.inject.Inject;
import net.codedstingray.warpstones.commands.CommandInitializer;
import org.jetbrains.annotations.Contract;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
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

    @Inject
    private Game game;

    public Warpstones() {
        instance = this;
    }

    @Listener
    public void onServerInit(GameInitializationEvent event) {
        logger.info("loading commands...");
        CommandInitializer.get().initCommands();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Hello there! Warpstones here!");
    }

    public Game getGame() {
        return game;
    }

    //singleton
    private static Warpstones instance;

    @Contract(pure = true)
    public static Warpstones get() {
        return instance;
    }
}
