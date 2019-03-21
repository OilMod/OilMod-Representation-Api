package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.providers.KeyedRequestBase;

public class MC112ItemReq extends KeyedRequestBase<MinecraftItem, MC112ItemReq> implements ItemRequest {
    private int data;

    public MC112ItemReq(MinecraftItem b) {
        key(b.toString().toLowerCase()); //should work at least currently
    }

    public MC112ItemReq data(int d) {
        this .data = d;
        return this;
    }

    public int getData() {
        return data;
    }
}
