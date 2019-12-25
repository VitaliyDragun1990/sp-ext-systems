package com.revenat.ext.cityregister.web;

import com.revenat.ext.cityregister.config.PoolConnectionBuilder;
import com.revenat.ext.cityregister.dao.PersonCheckerDao;
import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource class
 *
 * @author Vitaliy Dragun
 */
@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonService.class);

    private PersonCheckerDao dao;

    @PostConstruct
    void init() {
        LOGGER.info("CheckPersonService CREATED");
        dao = new PersonCheckerDao(new PoolConnectionBuilder());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(final PersonRequest request) throws PersonCheckerException {
        LOGGER.info("Got request:\n{}", request);
        return dao.checkPerson(request);
    }
}
