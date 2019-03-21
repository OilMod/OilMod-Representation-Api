package org.oilmod.api.rep.providers;

import java.util.Set;

public interface Request<TDep> {
    Set<TDep> getDependencies();
    void init(boolean hasCircleDep);
    boolean isInitialised();

}
