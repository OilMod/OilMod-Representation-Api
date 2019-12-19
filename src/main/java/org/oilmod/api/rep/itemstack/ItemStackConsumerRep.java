package org.oilmod.api.rep.itemstack;

@FunctionalInterface
public interface ItemStackConsumerRep {
    boolean consume(ItemStackRep stack, int multiplier, boolean testRun);
}
