package com.revenat.ext.cityregister.web;

import com.revenat.ext.cityregister.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource class
 * @author Vitaliy Dragun
 */
@Path("/check")
public class CheckPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonService.class);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(@PathParam("id") int id, @QueryParam("name") String name) {
        LOGGER.info("'/rest/check/{}?name={}'", id, name);
        return new PersonResponse(true, false);
    }
}
