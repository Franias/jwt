package edu.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class Users {

    @GET
    @Path("/jwt")
    @PermitAll //metodos abertos que qualquer um pode tentar autenticar, criar o jwt
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {//apenas o issuer seria uma constante
        return Jwt.issuer("http://localhost:8080") //issuer:emissor, quem é que emite o jwt | nao deve ficar vazio mas pode ser qualquer coisa
                .upn("francielli@ifrs.dev") //id de usuario
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))//roles, é usuario e é administrador que vai conseguir entrar em endpoint marcado como user e admin
                .claim(Claims.full_name, "Francielli Dias")//payload, declarações e pode colocar quantos quiser
                .sign();//token assinado (pode ser criptografado
    }

}
