package elakeel.services;

import java.util.List;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.ejbs.User;


public interface OrderServiceInterface {
	Order getOrderById(Long orderId);
	
	User selectRandomAvailableRunner();
	
	Order createOrder(Order order);
	
	List<Order> getOrdersByCustomerId(Long customerId);
	
	void editOrder(Order order, List<OrderItem> newItems);

}
