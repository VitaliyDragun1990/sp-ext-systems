package com.revenat.ext.registeroffice.business;

import com.revenat.ext.registeroffice.business.entity.MarriageCertificate;
import com.revenat.ext.registeroffice.business.model.MarriageRequest;
import com.revenat.ext.registeroffice.business.model.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Use case controller (interactor)
 * @author Vitaliy Dragun
 */
public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

    private final MarriageDao marriageDao;

    public MarriageManager(final MarriageDao marriageDao) {
        this.marriageDao = requireNonNull(marriageDao);
    }

    public MarriageResponse findMarriageCertificate(final MarriageRequest request) {
        LOGGER.info("Got MarriageRequest: {}", request);
        final Optional<MarriageCertificate> certificateOptional = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse(certificateOptional.isPresent());
    }
}
