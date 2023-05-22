package elakeel.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Restaurant;
import elakeel.ejbs.RestaurantReport;
@Stateless
public class RestaurantService implements ResturantServiceInterface {
    @PersistenceContext(unitName = "akeel")
    private EntityManager entityManager;

    public Restaurant createRestaurant(Restaurant restaurant) {
        entityManager.persist(restaurant);
        return restaurant;
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        entityManager.merge(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return entityManager.find(Restaurant.class, restaurantId);
    }

    public RestaurantReport createRestaurantReport(Long restaurantId) {
        Restaurant restaurant = entityManager.find(Restaurant.class, restaurantId);
        if (restaurant != null) {
            List<Order> completedOrders = getCompletedOrdersByRestaurantId(restaurantId);
            double totalEarnings = 0;
            int numCompletedOrders = completedOrders.size();
            int numCanceledOrders = getNumCanceledOrdersByRestaurantId(restaurantId);

            for (Order order : completedOrders) {
                totalEarnings += order.getTotalPrice();
            }

            return new RestaurantReport(restaurant, totalEarnings, numCompletedOrders, numCanceledOrders);
        }
        return null;
    }


    private List<Order> getCompletedOrdersByRestaurantId(Long restaurantId) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.restaurant.id = :restaurantId AND o.status = :status", Order.class);
        query.setParameter("restaurantId", restaurantId);
        query.setParameter("status", OrderStatus.DELIVERED);
        return query.getResultList();
    }

    private int getNumCanceledOrdersByRestaurantId(Long restaurantId) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(o) FROM Order o WHERE o.restaurant.id = :restaurantId AND o.status = :status", Long.class);
        query.setParameter("restaurantId", restaurantId);
        query.setParameter("status", OrderStatus.CANCELED);
        return query.getSingleResult().intValue();
    }
}
