package org.oilmod.api.rep.item;

import org.oilmod.api.rep.block.BlockRep;

public interface BlockItemRep extends ItemRep {
    BlockItemStateRep getStandardState();
    BlockRep getBlock();
}
