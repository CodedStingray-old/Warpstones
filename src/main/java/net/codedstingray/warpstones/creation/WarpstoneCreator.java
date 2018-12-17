package net.codedstingray.warpstones.creation;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class WarpstoneCreator {



    public void createWarpstone(Location<World> location) {
        Vector3i pos = location.getBlockPosition();
        for(int y = pos.getY(); y < pos.getY() + 7; y++) {
            for(int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
                for(int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
                    Location<World> newLocation = new Location<>(location.getExtent(), x, y, z);
                    newLocation.setBlockType(BlockTypes.STONEBRICK);
                }
            }
        }
    }

    public boolean detectWarpstone(String name) {
        return false;
    }


    //singleton
    private static WarpstoneCreator instance = new WarpstoneCreator();

    public static WarpstoneCreator get() {
        return instance;
    }
}
