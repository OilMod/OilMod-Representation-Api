package org.oilmod.api.rep.block;

import org.oilmod.api.rep.item.BlockItemRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.variant.IVariantable;

public interface BlockRep{
    boolean hasItem();
    BlockItemRep getItem();
    BlockStateRep getStandardState();
}
