package elakeel.services;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import elakeel.ejbs.*;
import elakeel.ejbs.Customer;
import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Runner;
import elakeel.ejbs.RunnerStatus;
import elakeel.ejbs.User;
import elakeel.ejbs.UserRole;
import java.util.List;


@Stateless
public class CustomerService implements customerserviceinterface{
    @PersistenceContext(unitName = "akeel")
    private EntityManager entityManager;
    @Inject
    private OrderServiceInterface orderService;
    public Order createOrder(Long customerId, Long restaurantId, List<OrderItem> items) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Restaurant restaurant = entityManager.find(Restaurant.class, restaurantId);

        if (customer != null && restaurant != null) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setRestaurant(restaurant);
            order.setItems(items);
            order.setTotalPrice(calculateTotalPrice(items, restaurant.getDeliveryFees()));

          
            return orderService.createOrder(order);
        }

        return null;
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.customer.id = :customerId", Order.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    private double calculateTotalPrice(List<OrderItem> items, double deliveryFees) {
        double totalPrice = 0;

        for (OrderItem item : items) {
            totalPrice += item.getMeal().getPrice();
        }

        return totalPrice + deliveryFees;
    }
}
