package net.codedstingray.warpstones.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class CmdCreate implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
//        Location<World> location;
//
//
//
//        if(src instanceof Locatable) {
//
//        }
        src.sendMessage(Text.of(TextStyles.BOLD, TextColors.DARK_GREEN, "Warpstone Created."));

        return CommandResult.success();
    }
}
