package org.oilmod.api.rep.variant;

import java.util.Set;

public interface Variant<T extends IVariantable> {
    T get();
    Set<Property> getProperties();
    Set<Expression> getExpressions();
    Set<Expression> getExpressions(Property property);
    Availability getAvailability();
}
