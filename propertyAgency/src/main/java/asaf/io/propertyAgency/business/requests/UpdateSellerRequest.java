package asaf.io.propertyAgency.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSellerRequest {
	private int id;
	private String name;
	private String surname;
	private String phoneNumber;
}
