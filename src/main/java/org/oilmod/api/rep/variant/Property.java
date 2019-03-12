package org.oilmod.api.rep.variant;

import java.util.Set;

public interface Property {
    /**
     *
     * @return whether expression are exclusive or add up
     */
    boolean isExclusive();
    default boolean isApplicable(Expression expression) {
        return getExpressions().contains(expression);
    }
    Set<Expression> getExpressions();
}
