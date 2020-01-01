package com.revenat.ext.student.business;

import com.revenat.ext.student.business.model.StudentRequest;
import com.revenat.ext.student.business.model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Vitaliy Dragun
 */
@Service
public class CheckStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckStudentService.class);

    public StudentResponse checkStudent(StudentRequest request) {
        LOGGER.info("Got requestL {}", request);
        return new StudentResponse();
    }
}
