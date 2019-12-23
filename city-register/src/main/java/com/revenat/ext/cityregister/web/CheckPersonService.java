package com.revenat.ext.cityregister.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource class
 * @author Vitaliy Dragun
 */
@Path("/check")
public class CheckPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonService.class);

    @GET
    public String checkPerson() {
        LOGGER.info("checkPerson REST web service called");
        return "Simple String";
    }
}
