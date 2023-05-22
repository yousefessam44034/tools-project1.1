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