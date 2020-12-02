package org.oilmod.api.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.oilmod.api.rep.inventory.InventoryRep;

import java.util.List;
import java.util.function.Consumer;

public class InventoryListBuilder<T> extends InventoryBuilder<InventoryListBuilder<T>> {
    private final Consumer<List<InventoryRep>> invListConsumer;
    private final T parent;
    private final List<InventoryRep> result = new ObjectArrayList<>();

    public InventoryListBuilder(Consumer<List<InventoryRep>> invListConsumer, InventoryRep invIn, T parent) {
        super(invIn);
        this.invListConsumer = invListConsumer;
        this.parent = parent;
    }

    @Override
    void accept(InventoryRep inv) {
        result.add(inv);
    }

    public T make() {
        invListConsumer.accept(result);
        return parent;
    }
}
