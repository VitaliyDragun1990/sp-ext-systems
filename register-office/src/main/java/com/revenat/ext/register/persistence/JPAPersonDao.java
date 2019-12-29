package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
@Repository
public class JPAPersonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JPAPersonDao.class);

    @Value("${test.value}")
    private String testValue;

    private EntityManager entityManager;

    public JPAPersonDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public List<Person> findAllPeople() {
        LOGGER.info("test value: {}", testValue);
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
