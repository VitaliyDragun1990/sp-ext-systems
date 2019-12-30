package com.revenat.ext.register.business;

import com.revenat.ext.register.business.entity.MarriageCertificate;
import com.revenat.ext.register.business.entity.Person;
import com.revenat.ext.register.business.entity.PersonFemale;
import com.revenat.ext.register.business.entity.PersonMale;
import com.revenat.ext.register.business.model.MarriageRequest;
import com.revenat.ext.register.business.model.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
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

    private final PersonDao personDao;

    @Autowired
    public MarriageManager(@Qualifier("springMarriageDao") final MarriageDao marriageDao,
                           final PersonDao personDao) {
        this.marriageDao = requireNonNull(marriageDao);
        this.personDao = requireNonNull(personDao);
    }

    @Transactional(readOnly = false)
    public MarriageResponse findMarriageCertificate(final MarriageRequest request) {
//        LOGGER.info("Got MarriageRequest: {}", request);
//        final Optional<MarriageCertificate> certificateOptional = marriageDao.findMarriageCertificate(request);
//
//        return new MarriageResponse(certificateOptional.isPresent());
        final PersonMale husband = buildMale();
        registerPerson(husband);
        LOGGER.info("Husband saved, id:{}", husband.getPersonId());
        final PersonFemale wife = buildFemale();
        registerPerson(wife);
        LOGGER.info("Wife saved, id:{}", wife.getPersonId());
        MarriageCertificate certificate = buildMarriageCertificate(husband, wife);
        marriageDao.save(certificate);
        LOGGER.info("Marriage Certificate saved, id:{}", certificate.getMarriageCertificateId());
        marriageDao.findAll().forEach(c -> LOGGER.info("Found certificate with id:{}",c.getMarriageCertificateId()));

        return new MarriageResponse(false);
    }

    private MarriageCertificate buildMarriageCertificate(PersonMale husband, PersonFemale wife) {
        MarriageCertificate certificate = new MarriageCertificate();

        certificate.setHusband(husband);
        certificate.setWife(wife);
        certificate.setIssueDate(LocalDate.now());
        certificate.setNumber("Marriage12345");
        certificate.setActive(true);

        return certificate;
    }

    private static PersonMale buildMale() {
        final PersonMale person = new PersonMale();
        person.setFirstName("John");
        person.setLastName("Snow");
        person.setPatronymic("Edward");
        person.setDateOfBirth(LocalDate.of(1992, 5, 5));
        return person;
    }

    private static PersonFemale buildFemale() {
        final PersonFemale person = new PersonFemale();
        person.setFirstName("Anna");
        person.setLastName("Stark");
        person.setPatronymic("Luisa");
        person.setDateOfBirth(LocalDate.of(1994, 7, 12));
        return person;
    }

    @Transactional
    public Long registerPerson(final Person person) {
        return personDao.addPerson(person);
    }
}
