package asaf.io.propertyAgency.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLocationRequest {
	private int id;
	
	private String city;
	
	private String street;
}
