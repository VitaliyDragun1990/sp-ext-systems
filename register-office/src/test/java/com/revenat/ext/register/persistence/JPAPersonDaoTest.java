package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.entity.Person;
import com.revenat.ext.register.business.entity.PersonFemale;
import com.revenat.ext.register.business.entity.PersonMale;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("a person dao")
class JPAPersonDaoTest {

    private static EntityManager entityManager;

    private static EntityManagerFactory factory;

    private JPAPersonDao dao;

    @BeforeAll
    static void beforeAll() {
        factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        entityManager.close();
        factory.close();
    }

    @BeforeEach
    void setUp() {
        dao = new JPAPersonDao();
        dao.setEntityManager(entityManager);
    }

    @Test
    void shouldFindAllPeople() {
        final List<Person> people = dao.findAllPeople();

        assertThat(people, hasSize(3));
        people.forEach(person -> {
            System.out.println();
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
            System.out.println();
        });
    }

    @Test
    void shouldGetPersonById() {
        final Person person = dao.getById(1L);

        assertNotNull(person, "Failed to find person by id");
    }
}