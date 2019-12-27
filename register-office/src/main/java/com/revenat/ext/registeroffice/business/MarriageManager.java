package com.revenat.ext.registeroffice.business;

import com.revenat.ext.registeroffice.business.model.MarriageRequest;
import com.revenat.ext.registeroffice.business.model.MarriageResponse;

/**
 * @author Vitaliy Dragun
 */
public class MarriageManager {

    private final MarriageDao marriageDao;

    public MarriageManager(final MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(final MarriageRequest request) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
