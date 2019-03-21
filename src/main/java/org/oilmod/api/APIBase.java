package org.oilmod.api;

import jdk.nashorn.internal.ir.Block;
import org.apache.commons.lang3.Validate;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.providers.minecraft.MC112BlockReq;
import org.oilmod.api.rep.providers.minecraft.MinecraftBlock;
import org.oilmod.api.rep.variant.Availability;
import org.oilmod.api.rep.variant.Substitute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class APIBase {
    private List<Exception> exceptions;

    protected void apiInit() {
        exceptions = new ArrayList<>();
    }

    protected void apiPostInit() {
        if (exceptions.size() > 0) {
            StringBuilder sb = new StringBuilder("Some blocks were not correctly mapped to the provider:");
            for (Exception e:exceptions) {
                sb.append('\n');
                sb.append(e.getMessage());
            }
            IllegalStateException ex = new IllegalStateException(sb.toString());
            for (Exception e:exceptions) {
                ex.addSuppressed(e);
            }
            throw ex;
        }
        exceptions = null;
    }

    protected void reportError(Exception e) {
        exceptions.add(e);
    }
}
