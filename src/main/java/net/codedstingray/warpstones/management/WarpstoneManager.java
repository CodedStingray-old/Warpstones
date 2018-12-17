package net.codedstingray.warpstones.management;

import net.codedstingray.warpstones.Warpstone;

import java.util.HashSet;

public class WarpstoneManager {

    private HashSet<Warpstone> warpstones = new HashSet<>();

    public void registerWarpstone(Warpstone warpstone) {
        warpstones.add(warpstone);
    }

    public boolean isWarpstonePresent(Warpstone warpstone) {
        return warpstones.contains(warpstone);
    }

    //singleton
    private static WarpstoneManager instance = new WarpstoneManager();

    public static WarpstoneManager get() {
        return instance;
    }
}
