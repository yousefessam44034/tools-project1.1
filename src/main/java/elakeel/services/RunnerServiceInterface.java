package elakeel.services;

public interface RunnerServiceInterface {
	void markOrderAsDelivered(Long orderId);
	
	int getNumCompletedTripsByRunnerId(Long runnerId);

}
