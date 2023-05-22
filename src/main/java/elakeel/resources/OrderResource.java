package elakeel.resources;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.services.OrderService;
import elakeel.services.OrderServiceInterface;

import java.util.List;
