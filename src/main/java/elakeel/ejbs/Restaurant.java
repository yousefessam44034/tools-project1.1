package elakeel.ejbs;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable {
	
	@Column(nullable = false)
	private double deliveryFees;
	
	public Restaurant() {
		super();
	}

	public Restaurant(double deliveryFees, Long id, String name, RestaurantOwner owner, List<Meal> menu) {
		super();
		this.deliveryFees = deliveryFees;
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.menu = menu;
	}

	public double getDeliveryFees() {
		return deliveryFees;
	}

	public void setDeliveryFees(double deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantOwner getOwner() {
		return owner;
	}

	public void setOwner(RestaurantOwner owner) {
		this.owner = owner;
	}

	public List<Meal> getMenu() {
		return menu;
	}

	public void setMenu(List<Meal> menu) {
		this.menu = menu;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private RestaurantOwner owner;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meal> menu;

    
}
