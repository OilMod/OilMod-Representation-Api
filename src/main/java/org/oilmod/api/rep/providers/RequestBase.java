package org.oilmod.api.rep.providers;

import gnu.trove.set.hash.THashSet;
import org.oilmod.api.rep.variant.Availability;

import java.util.Collections;
import java.util.Set;

@SuppressWarnings("unchecked")
public class RequestBase<TDep, TRequest extends Request<TDep, TRequest>> implements Request<TDep, TRequest> {
    protected final Set<TDep> deps = new THashSet<>();
    private final Set<TDep> depsRead = Collections.unmodifiableSet(deps);
    private boolean initialised;

    @Override
    public Set<TDep> getDependencies() {
        return depsRead;
    }

    @Override
    public void init(boolean hasCircleDep) {
        initialised = true;
    }

    @Override
    public boolean isInitialised() {
        return initialised;
    }



    private Availability availability = Availability.Fully;
    private TDep substitute;
    public Availability getAvailability() {
        return availability;
    }

    public TDep getSubstitute() {
        return substitute;
    }


    public boolean isSubstituted() {
        return substitute!=null;
    }



    public TRequest partially() {
        availability = Availability.Partially;
        return (TRequest) this;
    }
    public TRequest wellSub() {
        availability = Availability.WellSubstituted;
        return (TRequest) this;
    }
    public TRequest badSub() {
        availability = Availability.WeaklySubstituted;
        return (TRequest) this;
    }
    public TRequest unavailable() {
        availability = Availability.Unavailable;
        return (TRequest) this;
    }


    public TRequest partially(TDep substitute) {
        this.substitute = substitute;
        deps.add(substitute);
        return partially();
    }
    public TRequest wellSub(TDep substitute) {
        this.substitute = substitute;
        deps.add(substitute);
        return wellSub();
    }
    public TRequest badSub(TDep substitute) {
        this.substitute = substitute;
        deps.add(substitute);
        return badSub();
    }
    public TRequest unavailable(TDep substitute) {
        this.substitute = substitute;
        deps.add(substitute);
        return unavailable();
    }

}
