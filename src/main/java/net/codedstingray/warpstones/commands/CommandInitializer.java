package net.codedstingray.warpstones.commands;

import net.codedstingray.warpstones.Warpstones;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandInitializer {

    public void initCommands() {
        //create command
        CommandSpec cmdCreate = CommandSpec.builder()
                .description(Text.of("Create a warpstone at your position or at the specified position"))
                .permission("")

                .arguments(
                        GenericArguments.optional(GenericArguments.firstParsing(
                                //one of these 2 can be applied, but don't have to
                                GenericArguments.requiringPermission(GenericArguments.player(Text.of("player")), ""),
                                GenericArguments.requiringPermission(GenericArguments.location(Text.of("location")), "")
                        )),
                        GenericArguments.string(Text.of("warpstone name"))
                )

                .executor(new CmdCreate())
                .build();

        Sponge.getCommandManager().register(Warpstones.get(), cmdCreate, "createWarpstone"); //TODO: change to childcommand


        //TODO: get rid of this one and move it into its own plugin
        CommandSpec cmdGetKeys = CommandSpec.builder()
                .executor(new CmdGetKeys())
                .build();
        Sponge.getCommandManager().register(Warpstones.get(), cmdGetKeys, "getkeys");
    }

    //singleton
    private static CommandInitializer instance = new CommandInitializer();

    public static CommandInitializer get() {
        return instance;
    }
}
