package org.oilmod.api.rep.providers.minecraft;

import gnu.trove.set.hash.THashSet;
import org.oilmod.api.rep.providers.RequestBase;
import org.oilmod.api.rep.variant.Availability;

import java.util.HashSet;
import java.util.Set;

public class MC112BlockReq extends RequestBase<MinecraftBlock, BlockRequest> implements BlockRequest {
    private String key;
    private Set<Property> properties = new THashSet<>();


    public MC112BlockReq(MinecraftBlock b) {
        this.key = b.toString().toLowerCase(); //should work at least currently
    }

    public String getKey() {
        return key;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public MC112BlockReq key(String key) {
        this.key = key;
        return this;
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
