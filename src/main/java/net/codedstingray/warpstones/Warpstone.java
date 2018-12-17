package net.codedstingray.warpstones;

import net.codedstingray.warpstones.creation.WarpstoneCreator;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class Warpstone {

    private String name;
    private Location<World> position;

    public Warpstone(String name, Location<World> position, boolean needToCreate, Player owner) {
        this.name = name;
        this.position = position;

        if(needToCreate)
            WarpstoneCreator.get().createWarpstone(position);
    }

    public String getName() {
        return name;
    }

    public Location<World> getPosition() {
        return position;
    }
}
