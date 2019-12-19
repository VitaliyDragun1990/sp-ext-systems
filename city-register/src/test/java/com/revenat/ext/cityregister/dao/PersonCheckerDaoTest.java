package com.revenat.ext.cityregister.dao;

import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;
import junit.addon.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(ReplaceCamelCase.class)
@DisplayName("a person checker dao")
class PersonCheckerDaoTest {

    @Test
    void shouldCheckPersonWithExtensionAndApartmentViaDataProvidedInTheRequest() throws PersonCheckerException {
        PersonRequest request = new PersonRequest();
        request.setSurName("Васильев");
        request.setGivenName("Павел");
        request.setPatronymic("Николаевич");
        request.setDateOfBirth(LocalDate.of(1995, 3, 18));
        request.setStringCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");

        PersonCheckerDao dao = new PersonCheckerDao();
        final PersonResponse response = dao.checkPerson(request);

        assertTrue(response.isRegistered());
        assertFalse(response.isTemporal());
    }

    @Test
    void shouldCheckPersonWithoutExtensionAndApartmentViaDataProvidedInTheRequest() throws PersonCheckerException {
        PersonRequest request = new PersonRequest();
        request.setSurName("Васильева");
        request.setGivenName("Ирина");
        request.setPatronymic("Петровна");
        request.setDateOfBirth(LocalDate.of(1997, 8, 21));
        request.setStringCode(1);
        request.setBuilding("5");

        PersonCheckerDao dao = new PersonCheckerDao();
        final PersonResponse response = dao.checkPerson(request);

        assertTrue(response.isRegistered());
        assertFalse(response.isTemporal());
    }
}