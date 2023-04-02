package asaf.io.propertyAgency.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@Column(name = "houseNumber")
	private String houseNumber;
	
	@JoinColumn(name = "location_id")
	private Location location;
	
	@JoinColumn(name = "kindId")
	private Kind kind;
	
	@JoinColumn(name = "sellerId")
	private Seller seller;
	
	@Column(name = "price")
	private double price;
}
