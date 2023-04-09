package asaf.io.propertyAgency.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHouseRequest {
	private int id;
	private String houseNumber;
	private int locationId;	
	private int kindId;	
	private int sellerId;	
	private double price;
}
