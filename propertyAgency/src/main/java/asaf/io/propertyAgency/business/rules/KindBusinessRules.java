package asaf.io.propertyAgency.business.rules;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.core.utilities.exception.BusinessException;
import asaf.io.propertyAgency.dataAccess.abstracts.KindRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class KindBusinessRules {
	private KindRepository kindRepository;
	
	public void checkIfKindExists(String kind) {
		if(this.kindRepository.existByName(kind)) {
			throw new BusinessException("Kind already exists!");
		}
	}
}
