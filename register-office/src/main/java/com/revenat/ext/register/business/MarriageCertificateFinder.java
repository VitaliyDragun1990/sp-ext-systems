package com.revenat.ext.register.business;

import com.revenat.ext.register.business.entity.MarriageCertificate;
import com.revenat.ext.register.business.model.MarriageRequest;

import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
public interface MarriageCertificateFinder {

    Optional<MarriageCertificate> findMarriageCertificate(MarriageRequest request);
}
