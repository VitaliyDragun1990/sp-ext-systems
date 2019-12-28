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

    public List<Person> findPeople() {
        final TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }
}
