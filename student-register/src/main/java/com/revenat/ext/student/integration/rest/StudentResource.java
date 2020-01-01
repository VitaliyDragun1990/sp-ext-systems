package com.revenat.ext.student.integration.rest;

import com.revenat.ext.student.business.CheckStudentService;
import com.revenat.ext.student.business.model.StudentRequest;
import com.revenat.ext.student.business.model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * REST endpoint
 * @author Vitaliy Dragun
 */
@Path("/student")
@Component
public class StudentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);

    private final CheckStudentService checkStudentService;

    @Autowired
    public StudentResource(CheckStudentService checkStudentService) {
        this.checkStudentService = requireNonNull(checkStudentService);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentResponse> getStudentInfo(final StudentRequest request) {
        LOGGER.info("Get request: {}", request);
        return checkStudentService.checkStudent(request);
    }
}
