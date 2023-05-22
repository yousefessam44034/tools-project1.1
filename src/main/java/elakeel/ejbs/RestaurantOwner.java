package elakeel.ejbs;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_owners")
public class RestaurantOwner extends User implements Serializable {

}
