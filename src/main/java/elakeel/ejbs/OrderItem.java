package elakeel.ejbs;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



public class OrderItem implements Serializable {
    public OrderItem() {
		super();
	}

	public OrderItem(Long id, Order order, Meal meal) {
		super();
		this.id = id;
		this.order = order;
		this.meal = meal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

