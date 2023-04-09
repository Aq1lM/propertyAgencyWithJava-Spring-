package asaf.io.propertyAgency.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSellerRequest {
	@NotNull
	@NotBlank
	private String name;
	
	@NotBlank
	@NotNull
	private String surname;
	
	@NotBlank
	@NotNull
	private String phoneNumber;
}
