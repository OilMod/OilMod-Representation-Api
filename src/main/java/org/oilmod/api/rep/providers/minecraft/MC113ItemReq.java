package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.providers.RequestBase;

public class MC113ItemReq extends RequestBase<MinecraftItem, ItemRequest> implements ItemRequest {
    private String key;

    public MC113ItemReq(MinecraftItem b) {
        this.key = b.toString().toLowerCase(); //should work at least currently
    }


    public String getKey() {
        return key;
    }

    public MC113ItemReq key(String key) {
        this.key = key;
        return this;
    }
}
