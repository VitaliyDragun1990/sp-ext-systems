package com.revenat.ext.registeroffice.business;

import com.revenat.ext.registeroffice.business.entity.MarriageCertificate;
import com.revenat.ext.registeroffice.business.model.MarriageRequest;

import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
public interface MarriageDao {

    Optional<MarriageCertificate> findMarriageCertificate(MarriageRequest request);
}
