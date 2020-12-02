package org.oilmod.api.util;

import org.oilmod.api.rep.inventory.InventoryRep;

import java.util.List;
import java.util.function.Consumer;

import static org.oilmod.util.LamdbaCastUtils.cast;

public class InventoryBuilder<T> {
    private final Consumer<InventoryRep> invConsumer;
    private final T parent;
    private final InventoryRep invIn;


    InventoryBuilder(InventoryRep invIn) {
        this.invConsumer = null;
        this.invIn = invIn;
        this.parent = cast(this);
    }

    public InventoryBuilder(Consumer<InventoryRep> invConsumer, InventoryRep invIn, T parent) {
        this.invConsumer = invConsumer;
        this.invIn = invIn;
        this.parent = parent;
    }

    void accept(InventoryRep inv) {
        invConsumer.accept(inv);
    }


    public T raw() {
        invConsumer.accept(invIn);
        return parent;
    }

    public T view2d(int offset, int width, int height) {
        accept(invIn.createView2d(offset, width, height));
        return parent;
    }

    public T view2d(int left, int width, int top, int height) {
        accept(invIn.createView2d(left, width, top, height));
        return parent;
    }

    public T view2d(int width, int height) {
        return view2d(0, width, height);
    }

    public T view1d(int offset, int size) {
        accept(invIn.createView(offset, size));
        return parent;
    }

    public T view1d(int size) {
        return view1d(0, size);
    }

}
