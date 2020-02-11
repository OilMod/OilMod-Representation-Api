package org.oilmod.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class APIBase {
    private List<Throwable> exceptions;

    protected void apiInit() {
        exceptions = new ArrayList<>();
    }

    protected void apiPostInit() {
        if (exceptions.size() > 0) {
            StringBuilder sb = new StringBuilder("Some entries were not correctly mapped to the provider:");
            class ExData {
                final Throwable ex;
                int count = 1;

                ExData(Throwable ex) {
                    this.ex = ex;
                }
            }

            Map<String, ExData> map = new Object2ObjectOpenHashMap<>();
            for (Throwable e:exceptions) {
                String testStr = e.toString();
                map.compute(testStr, (s, data) -> {
                    if (data == null) {
                        return new ExData(e);
                    }
                    data.count++;
                    return data;
                });
            }
            for(ExData entry:map.values()) {
                sb.append("\nThe following error occurred ");
                sb.append(entry.count);
                sb.append(" times: \"");
                sb.append(entry.ex.getMessage());
                sb.append('\"');
            }
            sb.append("\nWithin ");
            sb.append(exceptions.size());
            sb.append(", ");
            sb.append(map.size());
            sb.append(" unique exceptions occurred.");
            IllegalStateException ex = new IllegalStateException(sb.toString());
            for(ExData entry:map.values()) {
                ex.addSuppressed(entry.ex);
            }
            throw ex;
        }
        exceptions = null;
    }

    protected <T extends Throwable> void reportError(T e) throws T {
        if (exceptions == null)throw e;
        exceptions.add(e);
    }
}
