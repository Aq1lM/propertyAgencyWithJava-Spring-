package asaf.io.propertyAgency.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "houses")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class House {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToOne
	@JoinColumn(name = "kind_id")
	private Kind kind;
	
	@Column(name = "houseNumber")
	private String houseNumber;
	
	@OneToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	@Column(name = "price")
	private double price;
}
