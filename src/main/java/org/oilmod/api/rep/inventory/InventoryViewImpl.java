package org.oilmod.api.rep.inventory;

import org.oilmod.api.rep.itemstack.ItemStackRep;

public class InventoryViewImpl implements InventoryView {
    private final InventoryRep root;
    private final int leftOff;
    private final int topOff;
    private final int width;
    private final int height;
    private final boolean is2d;

    public InventoryViewImpl(InventoryRep root, int leftOff, int width, int topOff, int height) {
        this(root, leftOff, width, topOff, height, true);

    }
    private InventoryViewImpl(InventoryRep root, int leftOff, int width, int topOff, int height, boolean is2d) {
        //if (root instanceof InventoryView)throw new IllegalArgumentException("View has to be created with real root! root cannot be a view");
        this.root = root;
        this.leftOff = leftOff;
        this.topOff = topOff;
        this.width = width;
        this.height = height;
        this.is2d = is2d;
    }

    public InventoryViewImpl(InventoryRep root, int offset, int width, int height) {
        this(root, offset, width, 0, height, true);
    }

    public InventoryViewImpl(InventoryRep root, int offset, int size) {
        this(root, offset, size, 0, 0, false);
    }

    @Override
    public boolean is2d() {
        return is2d;
    }

    @Override
    public InventoryRep getRoot() {
        return root;
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    public int getLeftOff() {
        return leftOff;
    }

    public int getTopOff() {
        return topOff;
    }
}
