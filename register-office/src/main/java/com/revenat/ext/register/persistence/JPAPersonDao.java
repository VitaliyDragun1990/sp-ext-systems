package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
@Repository
public class JPAPersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAllPeople() {
        final TypedQuery<Person> query = entityManager.createNamedQuery(
                Person.FIND_ALL_PEOPLE,
                Person.class
        );
        return query.getResultList();
    }

    public Person getById(Long personId) {
        final TypedQuery<Person> query = entityManager.createNamedQuery(
                Person.FIND_PERSON_BY_ID,
                Person.class
        );
        query.setParameter("personId", personId);
        return query.getSingleResult();
    }
}
