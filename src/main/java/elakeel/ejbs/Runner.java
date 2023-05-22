package elakeel.ejbs;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "runners")
public class Runner extends User implements Serializable {
    public Runner() {
		super();
	}

	public Runner(double deliveryFees, RunnerStatus status) {
		super();
		this.deliveryFees = deliveryFees;
		this.status = status;
	}

	public double getDeliveryFees() {
		return deliveryFees;
	}

	public void setDeliveryFees(double deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	public RunnerStatus getStatus() {
		return status;
	}

	public void setStatus(RunnerStatus status) {
		this.status = status;
	}

	@Column(nullable = false)
    private double deliveryFees;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RunnerStatus status;
 
}
