package org.oilmod.api.rep.item;

public interface ItemStateRep {
    boolean isReadOnly();
    ItemStateRep copy();
    ItemRep getItem();
}
