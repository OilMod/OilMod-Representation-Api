package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.providers.RequestBase;

public class MC112ItemReq extends RequestBase<MinecraftItem, ItemRequest> implements ItemRequest {
    private String key;
    private int data;

    public MC112ItemReq(MinecraftItem b) {
        this.key = b.toString().toLowerCase(); //should work at least currently
    }


    public String getKey() {
        return key;
    }

    public MC112ItemReq key(String key) {
        this.key = key;
        return this;
    }

    public MC112ItemReq data(int d) {
        this .data = d;
        return this;
    }

    public int getData() {
        return data;
    }
}
