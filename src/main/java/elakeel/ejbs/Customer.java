package elakeel.ejbs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "custmers")
public class Customer extends User  {
	
	 @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	    private List<Order> orders;
	 
	 public void addOrder(Order orderr) {
			this.orders.add(orderr);
			}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	 
}
