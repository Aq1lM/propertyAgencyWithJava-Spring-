package asaf.io.propertyAgency.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.business.abstracts.SellerService;
import asaf.io.propertyAgency.business.requests.CreateSellerRequest;
import asaf.io.propertyAgency.business.requests.UpdateSellerRequest;
import asaf.io.propertyAgency.business.responses.GetAllSellerResponse;
import asaf.io.propertyAgency.business.responses.GetByIdSellerResponse;
import asaf.io.propertyAgency.core.utilities.mappers.ModelMapperService;
import asaf.io.propertyAgency.dataAccess.abstracts.SellerRepository;
import asaf.io.propertyAgency.entities.concretes.Seller;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SellerManager implements SellerService{
	private SellerRepository sellerRepository;
	private ModelMapperService mapperService;
	
	
	@Override
	public void add(CreateSellerRequest createSellerRequest) {
		Seller seller = this.mapperService.forRequest().map(createSellerRequest, Seller.class);
		
		this.sellerRepository.save(seller);
	}

	@Override
	public void update(UpdateSellerRequest updateSellerRequest) {
		Seller seller = this.mapperService.forRequest().map(updateSellerRequest, Seller.class);
		
		this.sellerRepository.save(seller);
	}

	@Override
	public void delete(int id) {
		this.sellerRepository.deleteById(id);
	}

	@Override
	public GetByIdSellerResponse getByIdSellerResponse(int id) {
		Seller seller = this.sellerRepository.findById(id).orElseThrow();
		GetByIdSellerResponse getByIdSeller = this.mapperService.forResponse().map(seller, GetByIdSellerResponse.class);
		
		return getByIdSeller;
	}

	@Override
	public List<GetAllSellerResponse> getAllSellerResponses() {
		List<Seller> sellers = this.sellerRepository.findAll();
		List<GetAllSellerResponse> getAllSellers = sellers.stream()
				.map(seller -> this.mapperService.forResponse().map(seller, GetAllSellerResponse.class))
				.collect(Collectors.toList());
		return getAllSellers;
	}

}
