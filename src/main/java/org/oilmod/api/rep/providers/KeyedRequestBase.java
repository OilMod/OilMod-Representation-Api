package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.providers.minecraft.MC113ItemReq;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;

@SuppressWarnings("unchecked")
public class KeyedRequestBase<TDep, TRequest extends Request<TDep>> extends RequestBase<TDep, TRequest> {
    private String key;
    private TDep keyParent;


    public String getKey() {
        return key;
    }
    public TDep getKeyParent() {
        return keyParent;
    }

    public TRequest key(String key) {
        this.key = key;
        return (TRequest) this;
    }
    public TRequest key(TDep key) {
        this.keyParent = key;
        deps.add(key);
        return (TRequest) this;
    }

    public boolean hasDependentKey() {
        return keyParent != null;
    }
}
