package elakeel.services;
import javax.ejb.Stateless;
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
public class RunnerService implements RunnerServiceInterface {
    @PersistenceContext(unitName = "akeel")
    private EntityManager entityManager;

    public void markOrderAsDelivered(Long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        if (order != null && order.getStatus() == OrderStatus.PREPARING) {
            order.setStatus(OrderStatus.DELIVERED);
            entityManager.merge(order);

            Runner runner = order.getRunner();
            runner.setStatus(RunnerStatus.AVAILABLE);
            entityManager.merge(runner);
        }
    }

    public int getNumCompletedTripsByRunnerId(Long runnerId) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(o) FROM Order o WHERE o.runner.id = :runnerId AND o.status = :status", Long.class);
        query.setParameter("runnerId", runnerId);
        query.setParameter("status", OrderStatus.DELIVERED);
        return query.getSingleResult().intValue();
    }
}