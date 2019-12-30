package com.revenat.ext.register.business;

import com.revenat.ext.register.business.entity.Person;

import java.util.List;

/**
 * @author Vitaliy Dragun
 */
public interface PersonDao {
    List<Person> findAllPeople();

    Person getById(Long personId);

    Long addPerson(Person person);
}
