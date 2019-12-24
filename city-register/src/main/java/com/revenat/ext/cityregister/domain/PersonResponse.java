package com.revenat.ext.cityregister.domain;

/**
 * @author Vitaliy Dragun
 */
public final class PersonResponse {

    private boolean registered;

    private boolean temporal;

    private PersonResponse() {
    }

    public PersonResponse(final boolean registered, final boolean temporal) {
        this.registered = registered;
        this.temporal = temporal;
    }

    public static PersonResponse unregistered() {
        return new PersonResponse(false, false);
    }

    public static PersonResponse temporalRegistration() {
        return new PersonResponse(true, true);
    }

    public static PersonResponse permanentRegistration() {
        return new PersonResponse(true, false);
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(final boolean registered) {
        this.registered = registered;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(final boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "registered=" + registered +
                ", temporal=" + temporal +
                '}';
    }
}
