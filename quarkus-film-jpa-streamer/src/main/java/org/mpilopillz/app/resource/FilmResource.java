package org.mpilopillz.app.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class FilmResource {

    @GET
    @Path("/sanityTest")
    @Produces(MediaType.TEXT_PLAIN)
    public String sanityTest() {
        return "The app is running!";
    }
}
