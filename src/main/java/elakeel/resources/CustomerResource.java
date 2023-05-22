package elakeel.resources;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import elakeel.services.CustomerService;
import elakeel.services.customerserviceinterface;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @EJB
    private customerserviceinterface customerService;

    @POST
    @Path("/{customerId}/orders")
    public Order createOrder(@PathParam("customerId") Long customerId, OrderRequest orderRequest) {
        List<OrderItem> items = orderRequest.getItems();
        Long restaurantId = orderRequest.getRestaurantId();
        return customerService.createOrder(customerId, restaurantId, items);
    }

    @GET
    @Path("/{customerId}/orders")
    public List<Order> getOrdersByCustomerId(@PathParam("customerId") Long customerId) {
        return customerService.getOrdersByCustomerId(customerId);
    }
}
