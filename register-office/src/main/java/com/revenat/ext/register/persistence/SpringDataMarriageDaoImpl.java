package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.MarriageCertificateFinder;
import com.revenat.ext.register.business.entity.MarriageCertificate;
import com.revenat.ext.register.business.model.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
public class SpringDataMarriageDaoImpl implements MarriageCertificateFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataMarriageDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<MarriageCertificate> findMarriageCertificate(final MarriageRequest request) {
        LOGGER.info("Got MarriageRequest: {}", request);
        final TypedQuery<MarriageCertificate> query =
                entityManager.createNamedQuery(MarriageCertificate.FIND_CERTIFICATE, MarriageCertificate.class);
        query.setParameter("hFirstName", request.getHusbandSureName());
        query.setParameter("hLastName", request.getHusbandGivenName());
        query.setParameter("hPatronymic", request.getHusbandPatronymic());
        query.setParameter("hPassportSeries", request.getHusbandPassportSeries());
        query.setParameter("hPassportNumber", request.getHusbandPassportNumber());
        query.setParameter("wFirstName", request.getWifeSureName());
        query.setParameter("wLastName", request.getWifeGivenName());
        query.setParameter("wPatronymic", request.getWifePatronymic());
        query.setParameter("wPassportSeries", request.getWifePassportSeries());
        query.setParameter("wPassportNumber", request.getWifePassportNumber());
        query.setParameter("certificateNumber", request.getMarriageCertificateNumber());
        query.setParameter("certificateIssueDate", request.getMarriageCertificateDate());

        final List<MarriageCertificate> result = query.getResultList();
        if (result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(result.get(0));
        }
    }
}
