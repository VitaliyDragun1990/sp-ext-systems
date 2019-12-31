package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.DaoException;
import com.revenat.ext.register.business.PersonDao;
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
public class JPAPersonDao implements PersonDao {

    private EntityManager entityManager;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAllPeople() {
        final TypedQuery<Person> query = entityManager.createNamedQuery(
                Person.FIND_ALL_PEOPLE,
                Person.class
        );
        return query.getResultList();
    }

    @Override
    public Person getById(Long personId) {
        try {
            final TypedQuery<Person> query = entityManager.createNamedQuery(
                    Person.FIND_PERSON_BY_ID,
                    Person.class
            );
            query.setParameter("personId", personId);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DaoException("Error while get person by id", e);
        }
    }

    @Override
    public Long addPerson(Person person) {
        try {
            entityManager.persist(person);
            entityManager.flush();

            return person.getPersonId();
        } catch (Exception e) {
            throw new DaoException("Can not add person: {}",e);
        }
    }
}
