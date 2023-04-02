package asaf.io.propertyAgency.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseRequest {
	
	@NotNull
	private String houseNumber;
	
	@NotNull
	private double price;
	
	@NotNull
	private int locationId;
	
	@NotNull
	private int kindId;
	
	@NotNull
	private int sellerId;
}
