package org.oilmod.api.rep.providers.minecraft;

import java.util.function.Function;

public class Blocks113 {
    
    public static Function<MinecraftBlock, BlockRequest> getLinker(MinecraftBlock b) {
        return Blocks113::m113;
    }


    private static MC113BlockReq m113(MinecraftBlock b) {
        return new MC113BlockReq(b);
    }
}
