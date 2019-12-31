package com.revenat.ext.register.business;

import com.revenat.ext.register.business.entity.MarriageCertificate;
import com.revenat.ext.register.business.model.MarriageRequest;
import com.revenat.ext.register.business.model.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

/**
 * Use case controller (interactor)
 * @author Vitaliy Dragun
 */
@Service
@Scope(SCOPE_SINGLETON)
public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

    private final MarriageDao marriageDao;

    @Autowired
    public MarriageManager(@Qualifier("springMarriageDao") final MarriageDao marriageDao) {
        this.marriageDao = requireNonNull(marriageDao);
    }

    @Transactional(readOnly = true)
    public MarriageResponse findMarriageCertificate(final MarriageRequest request) {
        LOGGER.info("Got MarriageRequest: {}", request);
        final Optional<MarriageCertificate> certificateOptional = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse(certificateOptional.isPresent());
    }
}
