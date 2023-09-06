package edu.ifrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.FormParam;

@Path("/second")
public class Second {
    
    @GET
    @Path("/getSum")
    @Produces(MediaType.TEXT_PLAIN)
    // @jakarta.annotation.security.RolesAllowed({ "User" })
    public int getSum(@FormParam("value1") int value1, @FormParam("value2") int value2){
        return value1 + value2;
    }
}
