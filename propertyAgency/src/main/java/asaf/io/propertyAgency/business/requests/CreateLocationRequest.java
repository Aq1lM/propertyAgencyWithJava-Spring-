package asaf.io.propertyAgency.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationRequest {
	
	@NotNull
	private String city;
	
	@NotNull
	private String street;
}
