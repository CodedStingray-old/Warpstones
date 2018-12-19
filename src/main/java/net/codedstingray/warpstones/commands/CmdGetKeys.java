package net.codedstingray.warpstones.commands;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Just a temporary dev command for me.
 * TODO: make a separate plugin out of this
 */
public class CmdGetKeys implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        Player player;
        if(src instanceof Player) {
            player = (Player)src;
        } else {
            src.sendMessage(Text.of("Command only applicable to players"));
            return CommandResult.empty();
        }


        Location<World> playerLocation = player.getLocation();
        Location<World> blockLocation = playerLocation.add(0, -1, 0);

        BlockState state = blockLocation.getBlock();
        state.getKeys().stream().forEach(key -> {
            player.sendMessage(Text.of(key.getId()/* + " - " + state.getValue(key)*/));
        });

        return CommandResult.success();
    }
}
