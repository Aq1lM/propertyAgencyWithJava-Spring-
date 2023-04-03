package asaf.io.propertyAgency.business.abstracts;

import java.util.List;

import asaf.io.propertyAgency.business.requests.CreateHouseRequest;
import asaf.io.propertyAgency.business.requests.UpdateHouseRequest;
import asaf.io.propertyAgency.business.responses.GetAllHouseResponse;
import asaf.io.propertyAgency.business.responses.GetByIdHouseResponse;
import asaf.io.propertyAgency.business.responses.GetByIdLocationResponse;

public interface HouseService {
	void add(CreateHouseRequest createHouseRequest);
	void update(UpdateHouseRequest updateHouseRequest);
	void delete(int id);
	GetByIdHouseResponse getById(int id);
	List<GetAllHouseResponse> getAll();
	
	List<GetByIdLocationResponse> getByIdLocation(int locationId);
}
