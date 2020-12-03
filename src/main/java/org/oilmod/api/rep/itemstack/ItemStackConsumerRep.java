package org.oilmod.api.rep.itemstack;

@FunctionalInterface
public interface ItemStackConsumerRep {
    int consume(ItemStackRep stack, int multiplier, boolean testRun);
}
