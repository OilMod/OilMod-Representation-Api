package org.oilmod.api.rep.variant;

import java.util.Set;

public interface IVariantable<V extends Variant> {
    V getStandardVariant();
    Set<Property> getProperties();
    VariantProvider<?, V> getVariantProvider();
}
