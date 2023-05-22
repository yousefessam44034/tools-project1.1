package elakeel.resources;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import elakeel.ejbs.*;
import elakeel.ejbs.Customer;
import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Runner;
import elakeel.ejbs.RunnerStatus;
import elakeel.ejbs.User;
import elakeel.ejbs.UserRole;
import elakeel.services.AuthenticationService;
import elakeel.services.AutheticationServicesInterface;

import java.util.List;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {
    @EJB
    private AutheticationServicesInterface authenticationService;

    @POST
    @Path("/signup")
    public User signUp(User user) {
        return authenticationService.signUp(user);
    }

    @POST
    @Path("/login")
    public User login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        return authenticationService.login(username, password);
    }
}
