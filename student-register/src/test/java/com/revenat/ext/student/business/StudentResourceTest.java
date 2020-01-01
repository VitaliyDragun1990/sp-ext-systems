package com.revenat.ext.student.business;

import com.revenat.ext.student.integration.rest.StudentResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test (involving spring context start-up)
 * @author Vitaliy Dragun
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
@DisplayName("a student resource")
class StudentResourceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResourceTest.class);

    @Autowired
    private StudentResource studentResource;

    @Test
    void shouldBeInitialized() {
        assertNotNull(studentResource);
        LOGGER.debug("StudentResource has been successfully initialized");
    }
}