/**
 * 
 */
package com.sap.sample.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Path("/checkConnection")
@Service
public interface SampleService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	Response checkConnection(@QueryParam("urlToCheck") String urlToCheck);
}