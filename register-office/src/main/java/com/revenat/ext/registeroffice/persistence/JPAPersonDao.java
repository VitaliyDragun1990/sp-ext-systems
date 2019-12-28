package com.revenat.ext.registeroffice.persistence;

import com.revenat.ext.registeroffice.business.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
public class JPAPersonDao {

    private EntityManager entityManager;

    public JPAPersonDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

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
