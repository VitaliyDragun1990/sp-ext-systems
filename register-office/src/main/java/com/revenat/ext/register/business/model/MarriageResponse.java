package com.revenat.ext.register.business.model;

import java.io.Serializable;

/**
 * @author Vitaliy Dragun
 */
public class MarriageResponse implements Serializable {

    private boolean present;

    public MarriageResponse(boolean present) {
        this.present = present;
    }

    public MarriageResponse() {
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
