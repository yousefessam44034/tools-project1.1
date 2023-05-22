package elakeel.resources;

import java.util.List;

import elakeel.ejbs.OrderItem;

public class OrderRequest {
    private Long restaurantId;
    private List<OrderItem> items;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
