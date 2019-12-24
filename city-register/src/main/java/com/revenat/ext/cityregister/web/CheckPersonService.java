package com.revenat.ext.cityregister.web;

import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource class
 * @author Vitaliy Dragun
 */
@Path("/check")
public class CheckPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonService.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(final PersonRequest request) {
        LOGGER.info("Got person request:\n{}", request);

        return PersonResponse.permanentRegistration();
    }
}
