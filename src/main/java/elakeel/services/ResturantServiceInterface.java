package elakeel.services;

import elakeel.ejbs.Restaurant;
import elakeel.ejbs.RestaurantReport;

public interface ResturantServiceInterface {
	 Restaurant createRestaurant(Restaurant restaurant);
	 
	 Restaurant updateRestaurant(Restaurant restaurant);
	 
	 Restaurant getRestaurantById(Long restaurantId);
	 
	 RestaurantReport createRestaurantReport(Long restaurantId);

}
