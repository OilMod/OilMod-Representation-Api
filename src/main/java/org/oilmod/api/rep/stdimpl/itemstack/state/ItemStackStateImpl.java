package org.oilmod.api.rep.stdimpl.itemstack.state;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.util.ReadSet;
import org.oilmod.api.util.WrappedReadSet;

import java.util.Map;
import java.util.Set;

//why again do we need this?
public class ItemStackStateImpl implements ItemStackStateRep {
    private ItemStateRep state;
    private int itemDamage;
    //private Map<EnchantmentRep, Integer> enchantments = new Object2ObjectOpenHashMap<>();

    //if we actually want to do this we need to provide an implementation for every state resolver that deals only with api-level data, probably well implementable by class->valueObject hashmap todo consider

    public ItemStackStateImpl(ItemStateRep state) {
        applyItemState(state);
    }

    public ItemStackStateImpl(ItemStackStateRep state) {
        state.applyTo(this, true, true);
    }


    @Override
    public ItemStateRep getItemState() {
        return state;
    }

    @Override
    public void applyItemState(ItemStateRep state) {
        this.state = state;
    }

    @Override
    public boolean isAttached() {
        return false;
    }

    @Override
    public void setItemDamage(int itemDamage) {
        this.itemDamage = itemDamage;
    }

    @Override
    public int getItemDamage() {
        return itemDamage;
    }

    /*@Override
    public int getEnchantmentLevel(EnchantmentRep ench) {
        return enchantments.get(ench);
    }

    @Override
    public void addEnchantment(EnchantmentRep ench, int level, boolean force) {
        enchantments.put(ench, applyEnchantment(ench, level, force));
    }

    protected int applyEnchantment(EnchantmentRep ench, int level, boolean force) {
        //todo check state - might not need to do that if we are clever with internal data structure. state test should really be done when this is applied to an actual stackstate
        return level;
    }

    @Override
    public int removeEnchantment(EnchantmentRep ench) {
        return enchantments.remove(ench);
    }*/

    @Override
    public boolean isSimilar(ItemStackStateProvider statePro) {
        ItemStackStateRep state = statePro.getProvidedItemStackState();
        return state.getItemDamage() == getItemDamage() &&
                state.getItemState().isSimilar(getItemState());// &&
                //state.getEnchantments().stream().allMatch(en -> getEnchantmentLevel(en) == state.getEnchantmentLevel(en));
    }

    /*@Override
    public ReadSet<EnchantmentRep> getEnchantments() {
        return new WrappedReadSet<>(enchantments.keySet());
    }*/
}
