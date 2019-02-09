package org.oilmod.api.rep.block;

public enum BlockFaceRep {
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0),
    UP(0, 1, 0),
    DOWN(0, -1, 0);

    private final int modX;
    private final int modY;
    private final int modZ;

    private BlockFaceRep(final int modX, final int modY, final int modZ) {
        this.modX = modX;
        this.modY = modY;
        this.modZ = modZ;
    }

    /**
     * Get the amount of X-coordinates to modify to get the represented block
     *
     * @return Amount of X-coordinates to modify
     */
    public int getModX() {
        return modX;
    }

    /**
     * Get the amount of Y-coordinates to modify to get the represented block
     *
     * @return Amount of Y-coordinates to modify
     */
    public int getModY() {
        return modY;
    }

    /**
     * Get the amount of Z-coordinates to modify to get the represented block
     *
     * @return Amount of Z-coordinates to modify
     */
    public int getModZ() {
        return modZ;
    }

    public BlockFaceRep getOppositeFace() {
        switch (this) {
            case NORTH:
                return BlockFaceRep.SOUTH;

            case SOUTH:
                return BlockFaceRep.NORTH;

            case EAST:
                return BlockFaceRep.WEST;

            case WEST:
                return BlockFaceRep.EAST;

            case UP:
                return BlockFaceRep.DOWN;

            case DOWN:
                return BlockFaceRep.UP;

        }
        throw new IllegalArgumentException("not a valid blockface");
    }
}
