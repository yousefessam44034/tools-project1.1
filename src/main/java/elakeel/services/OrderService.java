package elakeel.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Runner;
import elakeel.ejbs.RunnerStatus;
import elakeel.ejbs.User;
import elakeel.ejbs.UserRole;

import java.util.List;


@Stateless
public class OrderService implements OrderServiceInterface {
    @PersistenceContext(unitName = "akeel")
    private EntityManager entityManager;
    
    public Order getOrderById(Long orderId) {
        return entityManager.find(Order.class, orderId);
    }

    public User selectRandomAvailableRunner() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.role = :role AND u.status = :status", User.class);
        query.setParameter("role", UserRole.RUNNER);
        query.setParameter("status", RunnerStatus.AVAILABLE);
        query.setMaxResults(1);
        List<User> runners = query.getResultList();
        return runners.isEmpty() ? null : runners.get(0);
    }

    public Order createOrder(Order order) {
         Runner runner = (Runner) selectRandomAvailableRunner();
        if (runner != null) {
            order.setRunner(runner);
            order.setStatus(OrderStatus.PREPARING);
            entityManager.persist(order);
            runner.setStatus(RunnerStatus.BUSY);
            entityManager.merge(runner);
            return order;
        }
        return null;
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.customer.id = :customerId", Order.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    public void editOrder(Order order, List<OrderItem> newItems) {
        if (order.getStatus() != OrderStatus.CANCELED && order.getStatus() == OrderStatus.PREPARING) {
            order.setItems(newItems);
            order.setTotalPrice(calculateTotalPrice(newItems, order.getRestaurant().getDeliveryFees()));
            entityManager.merge(order);
        }
    }

    private double calculateTotalPrice(List<OrderItem> items, double deliveryFees) {
        double totalPrice = 0;

        for (OrderItem item : items) {
            totalPrice += item.getMeal().getPrice();
        }

        return totalPrice + deliveryFees;
    }
}
