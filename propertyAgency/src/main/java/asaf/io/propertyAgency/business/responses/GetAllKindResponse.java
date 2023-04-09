package asaf.io.propertyAgency.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllKindResponse {
	private int id;
	
	private String name;
}
