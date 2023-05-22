package elakeel.ejbs;

public class RestaurantReport {
    public RestaurantReport() {
		super();
	}
	public RestaurantReport(Restaurant restaurant, double totalEarnings, int completedOrdersCount,
			int canceledOrdersCount) {
		super();
		this.restaurant = restaurant;
		this.totalEarnings = totalEarnings;
		this.completedOrdersCount = completedOrdersCount;
		this.canceledOrdersCount = canceledOrdersCount;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public int getCompletedOrdersCount() {
		return completedOrdersCount;
	}
	public void setCompletedOrdersCount(int completedOrdersCount) {
		this.completedOrdersCount = completedOrdersCount;
	}
	public int getCanceledOrdersCount() {
		return canceledOrdersCount;
	}
	public void setCanceledOrdersCount(int canceledOrdersCount) {
		this.canceledOrdersCount = canceledOrdersCount;
	}
	private Restaurant restaurant;
    private double totalEarnings;
    private int completedOrdersCount;
    private int canceledOrdersCount;
    
}

}
