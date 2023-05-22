package elakeel.resources;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.services.OrderService;
import elakeel.services.OrderServiceInterface;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
@EJB
private OrderServiceInterface orderService;
    
@POST
public Order createOrder(Order order) {
return orderService.createOrder(order);
}
    
@GET
@Path("/customer/{customerId}")
public List<Order> getOrdersByCustomerId(@PathParam("customerId") Long customerId) {
return orderService.getOrdersByCustomerId(customerId);
}

@PUT
@Path("/{orderId}")
public void editOrder(@PathParam("orderId") Long orderId, List<OrderItem> newItems) {
Order order = orderService.getOrderById(orderId);
orderService.editOrder(order, newItems);
  }
}
