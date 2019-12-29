package com.revenat.ext.registeroffice.integration;

import com.revenat.ext.registeroffice.business.MarriageManager;
import com.revenat.ext.registeroffice.business.model.MarriageRequest;
import com.revenat.ext.registeroffice.business.model.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

/**
 * REST endpoint resource
 *
 * @author Vitaliy Dragun
 */
public class MarriageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageResource.class);

    private final MarriageManager marriageManager;

    public MarriageResource(final MarriageManager marriageManager) {
        this.marriageManager = requireNonNull(marriageManager);
    }

    public MarriageResponse findMarriageCertificate(final MarriageRequest request) {
        LOGGER.info("Got MarriageRequest: {}", request);
        return marriageManager.findMarriageCertificate(request);
    }
}
