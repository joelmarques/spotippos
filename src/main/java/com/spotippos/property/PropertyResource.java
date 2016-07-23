package com.spotippos.property;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.spotippos.response.Response;

@ApplicationPath("/")
@Path("properties")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PropertyResource extends Application {
	
	@Inject
	PropertyRepository propertyRepository;
	
	@POST
	public Response persist(Property property) {
		return this.propertyRepository.persist(property);
	}
	
	@GET
	@Path("{id}")
	public Property find(@PathParam("id") Long id) {
		return this.propertyRepository.find(id);
	}
	
	@GET
	public Properties find(@QueryParam("ax") Integer ax, @QueryParam("ay") Integer ay,
					 @QueryParam("bx") Integer bx, @QueryParam("by") Integer by) {
		
		return new Properties();
	}

}