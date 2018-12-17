package net.codedstingray.warpstones.commands;

import net.codedstingray.warpstones.Warpstone;
import net.codedstingray.warpstones.management.WarpstoneManager;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;

public class CmdCreate implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Location<World> location;

        Optional<Player> playerOpt = args.getOne("player");
        Optional<Location<World>> locationOpt = args.getOne("location");
        if(playerOpt.isPresent()) {
            //we have a player, get its position
            location = playerOpt.get().getLocation();
        } else if(locationOpt.isPresent()) {
            //no player, but locaiton present
            location = locationOpt.get();
        } else if(src instanceof Locatable) {
            //neither player nor location given, but we can use the location of the command source
            location = ((Locatable) src).getLocation();
        } else {
            //neither player nor location given, and the source is not locatable, so we can't continue execution
            src.sendMessage(Text.of(TextStyles.BOLD, TextColors.DARK_RED,
                    "Could not create warpstone; please provide a player or location."));
            return CommandResult.empty();
        }

        String name = args.<String>getOne("warpstone name").get();

        //TODO: check for collision with other warpstones

        WarpstoneManager.get().registerWarpstone(new Warpstone(name, location, true, null));

        src.sendMessage(Text.of(TextStyles.BOLD, TextColors.DARK_GREEN, "Warpstone \"" + name + "\" created at " + location.getBlockPosition() + "."));

        return CommandResult.success();
    }
}
