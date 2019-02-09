package org.oilmod.api.rep.world;

import org.oilmod.api.rep.stdimpl.world.LocFactoryImpl;
import org.oilmod.api.rep.world.internal.GeneralVector;

public interface VectorRep extends GeneralVector {
    default VectorRep createVector(double x, double y, double z) {
        return LocFactoryImpl.INSTANCE.createVector(x, y, z);
    }

    default LocBuilder toBuilder() {
        return LocFactoryImpl.INSTANCE.createBuilder().add(this);
    }
}
