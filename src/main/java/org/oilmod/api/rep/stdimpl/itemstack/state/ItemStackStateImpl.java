package org.oilmod.api.rep.stdimpl.itemstack.state;

import gnu.trove.map.hash.THashMap;
import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.util.ReadSet;
import org.oilmod.api.util.WrappedReadSet;

import java.util.Map;
import java.util.Set;

public class ItemStackStateImpl implements ItemStackStateRep {
    private ItemStateRep state;
    private int itemDamage;
    private Map<EnchantmentRep, Integer> enchantments = new THashMap<>();

    public ItemStackStateImpl(ItemStateRep state) {
        applyItemState(state);
    }

    public ItemStackStateImpl(ItemStackStateRep state) {
        state.applyTo(this);
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

    @Override
    public int getEnchantmentLevel(EnchantmentRep ench) {
        return enchantments.get(ench);
    }

    @Override
    public void addEnchantment(EnchantmentRep ench, int level, boolean force) {
        enchantments.put(ench, applyEnchantment(ench, level, force));
    }

    protected int applyEnchantment(EnchantmentRep ench, int level, boolean force) {
        //todo check state
        return level;
    }

    @Override
    public int removeEnchantment(EnchantmentRep ench) {
        return enchantments.remove(ench);
    }

    @Override
    public ReadSet<EnchantmentRep> getEnchantments() {
        return new WrappedReadSet<>(enchantments.keySet());
    }
}
