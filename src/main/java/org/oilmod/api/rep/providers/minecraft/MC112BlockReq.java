package org.oilmod.api.rep.providers.minecraft;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import org.oilmod.api.rep.providers.KeyedRequestBase;
import org.oilmod.api.rep.providers.Request;
import org.oilmod.api.rep.providers.RequestBase;

import java.util.Set;

public class MC112BlockReq extends KeyedRequestBase<MinecraftBlock, MC112BlockReq> implements BlockRequest{
    private Set<Property> properties = new ObjectOpenHashSet<>();


    public MC112BlockReq(MinecraftBlock b) {
        key(b.toString().toLowerCase()); //should work at least currently
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public MC112BlockReq propTrue(String name) {
        return prop(name, "true");
    }


    public MC112BlockReq variant(String value) {
        return prop("variant", value);
    }
    public MC112BlockReq prop(String name, int value) {
        return prop(name, String.valueOf(value));
    }
    public MC112BlockReq prop(String name, String value) {
        properties.add(new Property(name, value));
        return this;
    }

    public static class Property{
        public final String name;
        public final String value;

        public Property(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
}
