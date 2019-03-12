package org.oilmod.api.rep.variant;

public class Substitute<T> {
    public final Availability availability;
    public final T value;

    public Substitute(Availability availability, T value) {
        this.availability = availability;
        this.value = value;
    }
}
