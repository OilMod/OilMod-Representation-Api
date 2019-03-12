package org.oilmod.api.rep.variant;

public class VariantBuilder<T extends IVariantable, V extends Variant> {
    private final T Base;

    public VariantBuilder(T base) {
        Base = base;
    }

    public T getBase() {
        return Base;
    }


    public V build() {
        //noinspection unchecked
        return (V) getBase().getVariantProvider().findVariant(this);
    }

}
