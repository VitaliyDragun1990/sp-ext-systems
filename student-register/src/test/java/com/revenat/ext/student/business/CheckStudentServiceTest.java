package com.revenat.ext.student.business;

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
@DisplayName("a check student service")
class CheckStudentServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckStudentServiceTest.class);

    @Autowired
    private CheckStudentService checkStudentService;

    @Test
    void shouldBeInitialized() {
        assertNotNull(checkStudentService);
        LOGGER.debug("CheckStudentService has been successfully initialized");
    }
}