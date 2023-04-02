package asaf.io.propertyAgency.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Location {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int locationId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
}
