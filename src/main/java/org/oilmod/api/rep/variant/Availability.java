package org.oilmod.api.rep.variant;

public enum Availability {
    /**All expresses requested expressions*/
    Fully,
    /**All expresses most required expressions*/
    Partially,
    /**Substituted to fulfil required purpose. - Might not conserve expressions or even variantable base*/
    WellSubstituted,
    /**Substituted functionally, but might be very unsuitable in most cases - Might not conserve expressions or even variantable base*/
    WeaklySubstituted,
    /**Unavailable and substituted to remotely similar - Might not conserve expressions or even variantable base*/
    Unavailable;

    public static Availability min(Availability a1, Availability a2) {
        return values()[Math.max(a1.ordinal(), a2.ordinal())];
    }
}
