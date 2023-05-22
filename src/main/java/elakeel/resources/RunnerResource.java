package elakeel.resources;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import elakeel.services.RunnerService;
import elakeel.services.RunnerServiceInterface;

import java.util.List;

@Path("/runners")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RunnerResource {
    @EJB
    private RunnerServiceInterface runnerService;

    @PUT
    @Path("/{orderId}/deliver")
    public void markOrderAsDelivered(@PathParam("orderId") Long orderId) {
        runnerService.markOrderAsDelivered(orderId);
