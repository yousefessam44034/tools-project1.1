package elakeel.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Restaurant;
import elakeel.ejbs.RestaurantReport;
import elakeel.services.RestaurantService;
import elakeel.services.ResturantServiceInterface;
@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {
    @EJB
    private ResturantServiceInterface restaurantService;

    @POST
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @PUT
    @Path("/{restaurantId}")
    public Restaurant updateRestaurant(@PathParam("restaurantId") Long restaurantId, Restaurant restaurant) {
        restaurant.setId(restaurantId);
        return restaurantService.updateRestaurant(restaurant);
    }
    @GET
    @Path("/{restaurantId}")
    public Restaurant getRestaurantById(@PathParam("restaurantId") Long restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @GET
    @Path("/{restaurantId}/report")
    public RestaurantReport createRestaurantReport(@PathParam("restaurantId") Long restaurantId) {
        return restaurantService.createRestaurantReport(restaurantId);
    }
}
