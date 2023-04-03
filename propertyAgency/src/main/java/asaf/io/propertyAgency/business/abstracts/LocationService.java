package asaf.io.propertyAgency.business.abstracts;

import asaf.io.propertyAgency.business.requests.CreateLocationRequest;
import asaf.io.propertyAgency.business.requests.UpdateLocationRequest;
import asaf.io.propertyAgency.business.responses.GetByIdLocationResponse;

public interface LocationService {
	void add(CreateLocationRequest createLocationRequest);
	void update(UpdateLocationRequest updateLocationRequest);
	void delete(int id);
	
	GetByIdLocationResponse getByLocationId(int id);
}