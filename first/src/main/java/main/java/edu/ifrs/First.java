package main.java.edu.ifrs;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
// import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/first")
public class First {
    /* Rest client */
    @Inject
    @RestClient
    ISecond backend;

    @GET
    @Path("/sum")
    @Produces(MediaType.TEXT_PLAIN)
    public int sum(
        @FormParam("value1") int value1,    
        @FormParam("value2") int value2) {
        return backend.getSum(value1, value2);

    }
    
}
