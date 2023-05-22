package elakeel.services;

import java.util.List;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;

public interface customerserviceinterface {
	
	 Order createOrder(Long customerId, Long restaurantId, List<OrderItem> items);
	 List<Order> getOrdersByCustomerId(Long customerId);
}

