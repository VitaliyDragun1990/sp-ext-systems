package com.revenat.ext.cityregister.dao;

import com.revenat.ext.cityregister.config.ConnectionBuilder;
import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;
import junit.addon.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(ReplaceCamelCase.class)
@DisplayName("a person checker dao")
class PersonCheckerDaoTest {

    private final ConnectionBuilder connectionBuilder = new DirectConnectionBuilder();

    @Test
    void shouldCheckPersonWithExtensionAndApartmentViaDataProvidedInTheRequest() throws PersonCheckerException {
        final PersonRequest request = new PersonRequest();
        request.setSurName("Васильев");
        request.setGivenName("Павел");
        request.setPatronymic("Николаевич");
        request.setDateOfBirth(LocalDate.of(1995, 3, 18));
        request.setStreetCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");

        final PersonCheckerDao dao = new PersonCheckerDao(connectionBuilder);
        final PersonResponse response = dao.checkPerson(request);

        assertTrue(response.isRegistered());
        assertFalse(response.isTemporal());
    }

    @Test
    void shouldCheckPersonWithoutExtensionAndApartmentViaDataProvidedInTheRequest() throws PersonCheckerException {
        final PersonRequest request = new PersonRequest();
        request.setSurName("Васильев");
        request.setGivenName("Николай");
        request.setPatronymic("Юриевич");
        request.setDateOfBirth(LocalDate.of(1971, 10, 10));
        request.setStreetCode(1);
        request.setBuilding("5");

        final PersonCheckerDao dao = new PersonCheckerDao(connectionBuilder);
        final PersonResponse response = dao.checkPerson(request);

        assertTrue(response.isRegistered());
        assertFalse(response.isTemporal());
    }
}