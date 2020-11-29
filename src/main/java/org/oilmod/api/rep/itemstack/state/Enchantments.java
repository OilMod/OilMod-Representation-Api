package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.states.implapi.IImplementation;
import org.oilmod.api.rep.states.implapi.ImplementationBase;
import org.oilmod.api.rep.states.implapi.StateImplementationResolver;
import org.oilmod.api.util.ReadSet;


public final class Enchantments {
    public final static StateImplementationResolver<EnchantmentHelper, ItemStackStateRep> RESOLVER = new StateImplementationResolver<>(ItemStackFactory.INSTANCE.STATE_COLLECTOR , new EnchantmentHelper[]{});

    /**
     * Gets the level of the specified enchantment on this item stack
     *
     * @param ench EnchantmentRep to check
     * @return Level of the enchantment, or 0
     */
    public static int getEnchantmentLevel(ItemStackStateProvider stateProv, EnchantmentRep ench) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).getEnchantmentLevel(state, ench);
    }

    /**
     * Adds the specified {@link EnchantmentRep} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     *
     * @param ench EnchantmentRep to add
     * @param level Level of the enchantment
     * @param force makes sure the enchantment is applied even if it doesnt fit or conflict
     * @throws IllegalArgumentException if enchantment null, or enchantment is
     *     not applicable
     */
    public static void add(ItemStackStateProvider stateProv, EnchantmentRep ench, int level, boolean force) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        RESOLVER.findApplicable(state).addEnchantment(state, ench, level, force);
    }


    /**
     * Removes the specified {@link EnchantmentRep} if it exists on this
     * ItemStack
     *
     * @param ench EnchantmentRep to remove
     * @return Previous level, or 0
     */
    public static int remove(ItemStackStateProvider stateProv, EnchantmentRep ench) {

        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).removeEnchantment(state, ench);
    }

    public static ReadSet<? extends EnchantmentRep> getAll(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).getEnchantments(state);
    }


    public static void removeAll(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        RESOLVER.findApplicable(state).removeAll(state);
    }

    public abstract static class EnchantmentHelper extends ImplementationBase<EnchantmentHelper, ItemStackStateRep> {

        protected abstract int getEnchantmentLevel(ItemStackStateRep state, EnchantmentRep ench);

        protected abstract void addEnchantment(ItemStackStateRep state, EnchantmentRep ench, int level, boolean force);

        protected abstract int removeEnchantment(ItemStackStateRep state, EnchantmentRep ench);

        protected abstract ReadSet<? extends EnchantmentRep> getEnchantments(ItemStackStateRep state);

        protected abstract void removeAll(ItemStackStateRep state);

        @Override
        public void apply(ItemStackStateRep from, ItemStackStateRep to, EnchantmentHelper toImpl, boolean additive, boolean force) {
            if (!additive)toImpl.removeAll(to);
            getAll(from).forEach(ench -> toImpl.addEnchantment(to, ench, getEnchantmentLevel(from, ench), !additive || force));
        }
    }
}