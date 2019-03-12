package org.oilmod.api.rep.variant;

import java.util.Set;

public interface Expression {
    default boolean isApplicable(Property property) {
        return getProperties().contains(property);
    }

    Set<Property> getProperties();
}
