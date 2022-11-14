package de.pfwd.scaffold.quarkusjdbi.web;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/auth")
@Authenticated
public class AuthenticationTestController {

  @Inject
  SecurityIdentity securityIdentity;

  @Inject
  JsonWebToken jwt;

  @GET
  @Path("/test")
  public User normalUser() {
    return new User(securityIdentity.getPrincipal().getName(), jwt.getClaim("username"));
  }

  @GET
  @RolesAllowed("admin")
  @Path("/only-admin")
  public User adminUser() {
    return new User(securityIdentity.getPrincipal().getName(), jwt.getClaim("username"));
  }

  public static class User {

    private final String cognitoId;

    private final String userName;

    public User(String cognitoId, String userName) {
      this.cognitoId = cognitoId;
      this.userName = userName;
    }

    public String getCognitoId() {
      return cognitoId;
    }

    public String getUserName() {
      return userName;
    }
  }

}
