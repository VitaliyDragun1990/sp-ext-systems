package com.revenat.ext.register.business;

import com.revenat.ext.register.business.entity.MarriageCertificate;

import java.util.List;

/**
 * @author Vitaliy Dragun
 */
public interface MarriageDao extends MarriageCertificateFinder {

    MarriageCertificate save(MarriageCertificate certificate);

    List<MarriageCertificate> findAll();
}
