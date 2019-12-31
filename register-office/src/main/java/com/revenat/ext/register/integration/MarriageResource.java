package com.revenat.ext.register.integration;

import com.revenat.ext.register.business.MarriageManager;
import com.revenat.ext.register.business.model.MarriageRequest;
import com.revenat.ext.register.business.model.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

/**
 * REST endpoint resource
 *
 * @author Vitaliy Dragun
 */
@Service("marriageResource")
@Path("/mc")
public class MarriageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageResource.class);

    private final MarriageManager marriageManager;

    @Autowired
    public MarriageResource(final MarriageManager marriageManager) {
        this.marriageManager = requireNonNull(marriageManager);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MarriageResponse findMarriageCertificate(/*final MarriageRequest request*/) {
        LOGGER.info("Got MarriageRequest: "/*, request*/);
        return marriageManager.findMarriageCertificate(/*request*/null);
    }
}
