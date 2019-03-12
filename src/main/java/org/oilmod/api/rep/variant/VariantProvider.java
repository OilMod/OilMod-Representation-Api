package org.oilmod.api.rep.variant;

public interface VariantProvider<T extends IVariantable, V extends Variant> {
    V findVariant(VariantBuilder<T, V> info);

}
