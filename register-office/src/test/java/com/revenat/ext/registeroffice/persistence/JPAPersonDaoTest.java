package com.revenat.ext.registeroffice.persistence;

import com.revenat.ext.registeroffice.business.entity.Person;
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

        assertThat(people, hasSize(2));
        people.forEach(person -> {
            System.out.println("First name: " + person.getFirstName());
            System.out.println("Name of the class: " + person.getClass().getSimpleName());
            System.out.println("Number of passports: " +  person.getPassports().size());
        });
    }
}