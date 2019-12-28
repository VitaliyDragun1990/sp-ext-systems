package com.revenat.ext.registeroffice.persistence;

import com.revenat.ext.registeroffice.business.entity.Person;
import com.revenat.ext.registeroffice.business.entity.PersonFemale;
import com.revenat.ext.registeroffice.business.entity.PersonMale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@DisplayName("a person dao")
class JPAPersonDaoTest {

    @Test
    void shouldFindAllPeople() {
        JPAPersonDao dao = new JPAPersonDao();

        final List<Person> people = dao.findPeople();

        assertThat(people, hasSize(3));
        people.forEach(person -> {
            System.out.println("First name: " + person.getFirstName());
            System.out.println("Name of the class: " + person.getClass().getSimpleName());
            System.out.println("Number of passports: " +  person.getPassports().size());
            System.out.println("Birth certificate: " +  person.getBirthCertificate());
            if (person instanceof PersonMale) {
                PersonMale male = (PersonMale) person;
                System.out.println("Male children birth certificates count: " + male.getBirthCertificates().size());
                System.out.println("Male marriage certificates count: " + male.getMarriageCertificates().size());
            } else {
                PersonFemale female = (PersonFemale) person;
                System.out.println("Female children birth certificates count: " + female.getBirthCertificates().size());
                System.out.println("Female marriage certificates count: " + female.getMarriageCertificates().size());
            }
        });
    }
}