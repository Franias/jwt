package main.java.edu.ifrs;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.FormParam;
import io.quarkus.oidc.token.propagation.AccessToken;

import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RegisterRestClient()
@AccessToken
public interface ISecond {
    @GET
    @Path("/second/getSum")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "User" })
    int getSum(@FormParam("value1") int value1, @FormParam("value2") int value2);
}
