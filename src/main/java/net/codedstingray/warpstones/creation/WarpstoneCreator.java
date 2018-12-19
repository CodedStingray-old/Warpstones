package net.codedstingray.warpstones.creation;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.block.AxisData;
import org.spongepowered.api.data.manipulator.mutable.block.DirectionalData;
import org.spongepowered.api.data.manipulator.mutable.block.SlabData;
import org.spongepowered.api.data.manipulator.mutable.block.StairShapeData;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.PortionTypes;
import org.spongepowered.api.data.type.SlabTypes;
import org.spongepowered.api.data.type.StairShapes;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.rotation.Rotations;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class WarpstoneCreator {

    //TODO: put this itno its own class or something; make it prettier
    private BlockState[][][] warpstoneStructure = new BlockState[3][7][3];
    {
        //corners
        for(int x = 0; x <= 2; x+=2) {
            for(int z = 0; z <= 2; z+=2) {
                warpstoneStructure[x][0][z] = BlockTypes.STONEBRICK.getDefaultState();
                warpstoneStructure[x][1][z] = BlockTypes.COBBLESTONE_WALL.getDefaultState();

                BlockState slab = BlockTypes.STONE_SLAB.getDefaultState();
                SlabData slabData = Sponge.getDataManager().getManipulatorBuilder(SlabData.class).get().create();
                slabData.set(Keys.SLAB_TYPE, SlabTypes.SMOOTH_BRICK);
                slab = slab.with(slabData.asImmutable()).get();
                warpstoneStructure[x][2][z] = slab;
            }
        }

        //edges
        BlockState stair = BlockTypes.STONE_BRICK_STAIRS.getDefaultState();

        warpstoneStructure[1][0][2] = warpstoneStructure[1][5][2] = stair.with(Keys.DIRECTION, Direction.NORTH).get();
        warpstoneStructure[1][2][2] = warpstoneStructure[1][3][2] = stair.with(Keys.DIRECTION, Direction.NORTH).get().with(Keys.PORTION_TYPE, PortionTypes.TOP).get();

        warpstoneStructure[0][0][1] = warpstoneStructure[0][5][1] = stair.with(Keys.DIRECTION, Direction.EAST).get();
        warpstoneStructure[0][2][1] = warpstoneStructure[0][3][1] = stair.with(Keys.DIRECTION, Direction.EAST).get().with(Keys.PORTION_TYPE, PortionTypes.TOP).get();

        warpstoneStructure[1][0][0] = warpstoneStructure[1][5][0] = stair.with(Keys.DIRECTION, Direction.SOUTH).get();
        warpstoneStructure[1][2][0] = warpstoneStructure[1][3][0] = stair.with(Keys.DIRECTION, Direction.SOUTH).get().with(Keys.PORTION_TYPE, PortionTypes.TOP).get();

        warpstoneStructure[2][0][1] = warpstoneStructure[2][5][1] = stair.with(Keys.DIRECTION, Direction.WEST).get();
        warpstoneStructure[2][2][1] = warpstoneStructure[2][3][1] = stair.with(Keys.DIRECTION, Direction.WEST).get().with(Keys.PORTION_TYPE, PortionTypes.TOP).get();


        warpstoneStructure[1][4][2] = warpstoneStructure[0][4][1] = warpstoneStructure[1][4][0]
                = warpstoneStructure[2][4][1] = BlockTypes.COBBLESTONE_WALL.getDefaultState();

        for(int y = 0; y < 7; y++) {
            warpstoneStructure[1][y][1] = BlockTypes.STONEBRICK.getDefaultState();
        }
        //TODO: add tile entity
        warpstoneStructure[1][1][1] = BlockTypes.IRON_BLOCK.getDefaultState();
    }

    public void createWarpstone(Location<World> location) {
        Vector3i pos = location.getBlockPosition();
        for(int y = 0; y < 7; y++) {
            for(int z = -1; z <= 1; z++) {
                for(int x = -1; x <= 1; x++) {
                    Location<World> newLocation = new Location<>(location.getExtent(), x + pos.getX(), y + pos.getY(), z + pos.getZ());
                    if(warpstoneStructure[x + 1][y][z + 1] != null) {
                        newLocation.setBlock(warpstoneStructure[x + 1][y][z + 1]);
                    }
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
