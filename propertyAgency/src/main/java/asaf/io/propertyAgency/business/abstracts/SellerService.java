package asaf.io.propertyAgency.business.abstracts;

import java.util.List;

import asaf.io.propertyAgency.business.requests.CreateSellerRequest;
import asaf.io.propertyAgency.business.requests.UpdateSellerRequest;
import asaf.io.propertyAgency.business.responses.GetAllSellerResponse;
import asaf.io.propertyAgency.business.responses.GetByIdSellerResponse;

public interface SellerService {
	void add(CreateSellerRequest createSellerRequest);
	void update(UpdateSellerRequest updateSellerRequest);
	void delete(int id);
	
	GetByIdSellerResponse getByIdSellerResponse(int id);
	List<GetAllSellerResponse> getAllSellerResponses();
}
