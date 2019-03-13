package org.oilmod.api.rep;

public interface IKey {
    String getNamespace();
    String getKeyString();



    int hashCode();

    default boolean equals(IKey obj) {
        return getNamespace().equals(obj.getNamespace()) && getKeyString().equals(obj.getKeyString());
    }
}
