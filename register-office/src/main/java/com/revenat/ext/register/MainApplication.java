package com.revenat.ext.register;

import com.revenat.ext.register.business.MarriageManager;
import com.revenat.ext.register.business.entity.Person;
import com.revenat.ext.register.business.entity.PersonMale;
import com.revenat.ext.register.business.model.MarriageRequest;
import com.revenat.ext.register.business.model.MarriageResponse;
import com.revenat.ext.register.integration.MarriageResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

/**
 * @author Vitaliy Dragun
 */
public class MainApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        final MarriageResource marriageResource = context.getBean("marriageResource", MarriageResource.class);

        final MarriageResponse response = marriageResource.findMarriageCertificate(buildMarriageRequest());
        LOGGER.info("Marriage certificate present: {}", response.isPresent());

        final MarriageManager marriageManager = context.getBean(MarriageManager.class);
        final Long personId = marriageManager.registerPerson(buildPerson());
        LOGGER.info("Saved new person with personId:{}", personId);
    }

    private static Person buildPerson() {
        final Person person = new PersonMale();
        person.setFirstName("John");
        person.setLastName("Snow");
        person.setPatronymic("Edward");
        person.setDateOfBirth(LocalDate.of(1992, 5, 5));
        return person;
    }

    private static MarriageRequest buildMarriageRequest() {
        final MarriageRequest request = new MarriageRequest();

        request.setHusbandSureName("Олег");
        request.setHusbandGivenName("Васильев");
        request.setHusbandPatronymic("Петрович");
        request.setHusbandPassportSeries("50000");
        request.setHusbandPassportNumber("654321");
        request.setHusbandPassportIssueDate(LocalDate.of(2017, 6, 15));

        request.setWifeSureName("Елена");
        request.setWifeGivenName("Васильева");
        request.setWifePatronymic("Сергеевна");
        request.setWifePassportSeries("40000");
        request.setWifePassportNumber("123456");
        request.setWifePassportIssueDate(LocalDate.of(2018, 4, 10));

        request.setMarriageCertificateNumber("123Marriage");
        request.setMarriageCertificateDate(LocalDate.of(2018, 10, 1));


        return request;
    }
}
