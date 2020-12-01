package org.oilmod.api.util;

import org.oilmod.api.rep.inventory.InventoryRep;

import java.util.function.Consumer;

public class InventoryBuilder<T> {
    private final Consumer<InventoryRep> invConsumer;
    private final T parent;
    private final InventoryRep invIn;

    public InventoryBuilder(Consumer<InventoryRep> invConsumer, InventoryRep invIn, T parent) {
        this.invConsumer = invConsumer;
        this.invIn = invIn;
        this.parent = parent;
    }

    public T raw() {
        invConsumer.accept(invIn);
        return parent;
    }

    public T view2d(int offset, int width, int height) {
        invConsumer.accept(invIn.createView2d(offset, width, height));
        return parent;
    }

    public T view2d(int left, int width, int top, int height) {
        invConsumer.accept(invIn.createView2d(left, width, top, height));
        return parent;
    }

    public T view2d(int width, int height) {
        return view2d(0, width, height);
    }

    public T view1d(int offset, int size) {
        invConsumer.accept(invIn.createView(offset, size));
        return parent;
    }

    public T view1d(int size) {
        return view1d(0, size);
    }
}
