package asaf.io.propertyAgency.business.abstracts;

import java.util.List;

import asaf.io.propertyAgency.business.requests.CreateKindRequest;
import asaf.io.propertyAgency.business.requests.UpdateKindRequest;
import asaf.io.propertyAgency.business.responses.GetAllKindResponse;
import asaf.io.propertyAgency.business.responses.GetByIdKindResponse;

public interface KindService {
	void add(CreateKindRequest createKindRequest);
	void update(UpdateKindRequest updateKindRequest);
	void delete(int id);
	
	GetByIdKindResponse getByIdKindResponse(int id);
	List<GetAllKindResponse> getAll();
}
