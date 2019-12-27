package com.revenat.ext.registeroffice.manager;

import com.revenat.ext.registeroffice.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
public class PersonManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonManager.class);

    public static void main(final String[] args) {
//        sessionExample();
        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        // Save person
        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Person p = new Person();
            p.setFirstName("Anna");
            p.setLastName("Petrova");
            entityManager.persist(p);
            LOGGER.info("Person was saved: {}", p);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        // Get all people
        try {
            entityManager = factory.createEntityManager();

            final TypedQuery<Person> query = entityManager.createQuery("FROM Person", Person.class);
            final List<Person> people = query.getResultList();
            LOGGER.info("Get people: {}", people);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void sessionExample() {
        final SessionFactory sf = buildSessionFactory();

        Long id = null;
        Transaction transaction = null;
        // Save person
        try (Session session = sf.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            final Person p = new Person();
            p.setFirstName("Vasiliy");
            p.setLastName("Sidorov");

            id = (Long) session.save(p);
            p.setPersonId(id);
            LOGGER.info("Person was saved: {}", p);

            transaction.commit();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }

        // Get person
        try (final Session session = sf.openSession()) {
            final Person person = session.get(Person.class, id);
            LOGGER.info("Get person: {}", person);
        }

        // Get all people
        try (final Session session = sf.openSession()) {
            final Query<Person> query = session.createQuery("FROM Person", Person.class);
            final List<Person> people = query.list();
            LOGGER.info("Get people: {}", people);
        }
    }

    private static SessionFactory buildSessionFactory() {
        try {
            final StandardServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();
            final MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            final Metadata metadata = metadataSources.getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (final Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
