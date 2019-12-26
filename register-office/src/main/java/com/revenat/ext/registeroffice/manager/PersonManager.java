package com.revenat.ext.registeroffice.manager;

import com.revenat.ext.registeroffice.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Vitaliy Dragun
 */
public class PersonManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonManager.class);

    public static void main(final String[] args) {
        final SessionFactory sf = buildSessionFactory();

        final Long id;
        try (final Session session = sf.openSession()) {
            session.getTransaction().begin();

            final Person p = new Person();
            p.setFirstName("Vasiliy");
            p.setLastName("Sidorov");

            id = (Long) session.save(p);
            LOGGER.info("Saved person with generated id: {}", id);

            session.getTransaction().commit();
        }

        try (final Session session = sf.openSession()) {
            final Person person = session.get(Person.class, id);
            LOGGER.info("Get person: {}", person);
        }

        try (final Session session = sf.openSession()) {
            final Query<Person> query = session.createQuery("FROM Person", Person.class);
            final List<Person> people = query.list();
            LOGGER.info("Get people: {}", people);
        }
    }

    private static SessionFactory buildSessionFactory() {
        try {
            final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            final Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (final Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
