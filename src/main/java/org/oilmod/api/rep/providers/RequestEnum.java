package org.oilmod.api.rep.providers;

import java.util.function.Function;

public interface RequestEnum<TEnum extends Enum<TEnum> & RequestEnum<TEnum, TRequest>, TRequest extends Request<TEnum, TRequest>> {
    InitState<TEnum, TRequest> getInitState();
    void saveRequest(TRequest request);
    void init();

    class InitState<TEnum extends Enum<TEnum> & RequestEnum<TEnum, TRequest>, TRequest extends Request<TEnum, TRequest>> {
        private boolean initialising = false;
        private boolean initialised = false;

        private final Function<TEnum, ? extends TRequest>[] linkers;
        private final TEnum parent;

        public InitState(TEnum parent, Function<TEnum, ? extends TRequest>... linkers) {
            this.linkers = linkers;
            this.parent = parent;
        }

        //todo per requestor type resolution
        public void init() {
            if (initialised) {
                return;
            }
            initialising = true;
            for (Function<TEnum, ? extends TRequest> linker:linkers) {
                TRequest request = linker.apply(parent);
                boolean hasCircleDep = false;
                for (TEnum dep:request.getDependencies()) {
                    InitState state = dep.getInitState();
                    if (state.initialised)continue;
                    if (state.initialising) {
                        hasCircleDep = true;
                        System.out.format("Initiation circle found involving at least the two links: %s, %s", this, dep); //todo use logging framework
                        continue;
                    }
                    state.init();
                }
                request.init(hasCircleDep);
                parent.saveRequest(request);
            }
            init();
            initialising = false;
            initialised = true;
        }
    }
}
