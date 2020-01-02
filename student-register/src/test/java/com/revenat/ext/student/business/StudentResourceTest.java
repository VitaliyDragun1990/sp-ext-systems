package com.revenat.ext.student.business;

import com.revenat.ext.student.business.entity.EducationForm;
import com.revenat.ext.student.business.model.StudentRequest;
import com.revenat.ext.student.business.model.StudentResponse;
import com.revenat.ext.student.integration.rest.StudentResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration test (involving spring context start-up)
 *
 * @author Vitaliy Dragun
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:test-springContext.xml"})
@DisplayName("a student resource")
class StudentResourceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResourceTest.class);

    @Autowired
    private StudentResource studentResource;

    @Test
    void shouldBeInitialized() {
        assertNotNull(studentResource);
        LOGGER.debug("StudentResource has been successfully initialized");
    }

    @Test
    void shouldReturnEmptyListIfNoStudentInfoWasFound() {
        final StudentRequest request = buildRequest(
                "Андрей",
                "Прохоров",
                "Иванович",
                LocalDate.of(1995, 2, 12),
                "60000",
                "123123",
                LocalDate.of(2015, 2, 15)
        );

        final List<StudentResponse> result = studentResource.getStudentInfo(request);

        assertThat(result, hasSize(0));
    }

    @Test
    void shouldReturnStudentInfoIfStudentWasFount() {
        final StudentRequest request = buildRequest(
                "Олег",
                "Васильев",
                "Петрович",
                LocalDate.of(1998, 3, 24),
                "50000",
                "654321",
                LocalDate.of(2017, 6, 15)
        );

        final List<StudentResponse> result = studentResource.getStudentInfo(request);
        final List<StudentResponse> expected = List.of(
                new StudentResponse.Builder()
                        .withDocumentNumber("DOC123456")
                        .withIssueDate(LocalDate.of(2015, 10, 10))
                        .withExpireDate(LocalDate.of(2020, 10, 12))
                        .withFaculty("Машиностроение")
                        .withUniversityName("Санкт-Петербургский Государственный Университет")
                        .withEducationForm(EducationForm.FULL_TIME.name())
                        .build(),
                new StudentResponse.Builder()
                        .withDocumentNumber("DOC654321")
                        .withIssueDate(LocalDate.of(2017, 9, 5))
                        .withExpireDate(LocalDate.of(2021, 11, 25))
                        .withFaculty("Информационные системы")
                        .withUniversityName("Санкт-Петербургский Морской Технический Университет")
                        .withEducationForm(EducationForm.EVENING.name())
                        .build()
        );

        assertResponseEquals(expected, result);
    }

    private void assertResponseEquals(final List<StudentResponse> expected, final List<StudentResponse> actual) {
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.get(0), expected.get(1)));
    }

    private StudentRequest buildRequest(final String firstName,
                                        final String lastName,
                                        final String middleName,
                                        final LocalDate dateOfBirth,
                                        final String passportSeries,
                                        final String passportNumber,
                                        final LocalDate passportIssueDate) {
        return new StudentRequest.Builder().setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .setDateOfBirth(dateOfBirth)
                .setPassportSeries(passportSeries)
                .setPassportNumber(passportNumber)
                .setPassportIssueDate(passportIssueDate)
                .build();
    }
}