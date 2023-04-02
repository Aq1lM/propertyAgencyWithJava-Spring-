package asaf.io.propertyAgency.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "sellers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Seller {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int sellerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
}
