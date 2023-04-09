package asaf.io.propertyAgency.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLocationResponse {
	private int id;
	
	private String city;
	
	private String street;
	
}
