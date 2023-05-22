package elakeel.ejbs;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
