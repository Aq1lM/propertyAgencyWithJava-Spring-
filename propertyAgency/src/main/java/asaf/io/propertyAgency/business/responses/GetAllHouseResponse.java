package asaf.io.propertyAgency.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHouseResponse {
	private int id;
	
	private String houseNumber;
	
	private String kind;
	
	private String city;
	
	private String street;
	
	private double price;
}
