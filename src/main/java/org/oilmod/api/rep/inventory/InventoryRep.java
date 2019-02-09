package org.oilmod.api.rep.inventory;

import org.oilmod.api.rep.itemstack.ItemStackRep;

public interface InventoryRep {
    int getStorageSize();
    int getTotalSize();
    ItemStackRep getStored(int slot);
    void setStored(int slot);
    //todo add more stuff, accessible, special etc
}
