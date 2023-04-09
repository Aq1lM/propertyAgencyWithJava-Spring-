package asaf.io.propertyAgency.business.rules;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.core.utilities.exception.BusinessException;
import asaf.io.propertyAgency.dataAccess.abstracts.LocationRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocationBusinessRules {
	private LocationRepository locationRepository;
	
	public void checkIfCityExists(String city) {
		if(this.locationRepository.existByName(city)) {
			throw new BusinessException("City already exists!");
		}
	}
}
