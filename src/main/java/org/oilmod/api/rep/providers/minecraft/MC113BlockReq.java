package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.providers.RequestBase;

public class MC113BlockReq extends RequestBase<MinecraftBlock, BlockRequest> implements BlockRequest {
    private String key;

    public MC113BlockReq(MinecraftBlock b) {
        this.key = b.toString().toLowerCase(); //should work at least currently
    }


    public String getKey() {
        return key;
    }

    public MC113BlockReq key(String key) {
        this.key = key;
        return this;
    }
}
