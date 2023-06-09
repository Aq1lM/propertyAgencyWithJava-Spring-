package asaf.io.propertyAgency.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.business.abstracts.HouseService;
import asaf.io.propertyAgency.business.requests.CreateHouseRequest;
import asaf.io.propertyAgency.business.requests.UpdateHouseRequest;
import asaf.io.propertyAgency.business.responses.GetAllHouseResponse;
import asaf.io.propertyAgency.business.responses.GetByIdHouseResponse;
import asaf.io.propertyAgency.core.utilities.mappers.ModelMapperService;
import asaf.io.propertyAgency.dataAccess.abstracts.HouseRepository;
import asaf.io.propertyAgency.entities.concretes.House;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HouseManager implements HouseService{
	
	private HouseRepository houseRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateHouseRequest createHouseRequest) {
		
		House house = this.modelMapperService.forRequest().map(createHouseRequest, House.class);
		
		this.houseRepository.save(house);
	}

	@Override
	public void update(UpdateHouseRequest updateHouseRequest) {
		
		House house = this.modelMapperService.forRequest().map(updateHouseRequest, House.class);
		
		this.houseRepository.save(house);
		
	}

	@Override
	public void delete(int id) {
		this.houseRepository.deleteById(id);
	}

	@Override
	public GetByIdHouseResponse getById(int id) {
		House house = this.houseRepository.findById(id).orElseThrow();
		
		GetByIdHouseResponse getByIdHouseResponse = this.modelMapperService.forResponse().map(house, GetByIdHouseResponse.class);
		return getByIdHouseResponse;
	}

	@Override
	public List<GetAllHouseResponse> getAll() {

		List<House> houses = this.houseRepository.findAll();
		
		List<GetAllHouseResponse> houseResponses = houses.stream()
				.map(house -> this.modelMapperService.forResponse().map(house, GetAllHouseResponse.class))
				.collect(Collectors.toList());
		
		return houseResponses;
	}

	@Override
	public List<GetAllHouseResponse> getByIdLocation(int locationId) {
		List<House> houses = this.houseRepository.findAll();
		
		List<GetAllHouseResponse> getByLocationIdResponses = houses.stream()
				.filter(house -> house.getLocation().getId() == locationId)
				.map(house -> this.modelMapperService.forResponse().map(house, GetAllHouseResponse.class))
				.collect(Collectors.toList());
		
		return getByLocationIdResponses;
	}

	@Override
	public List<GetAllHouseResponse> getByIdKindResponses(int kindId) {
		List<House> houses = this.houseRepository.findAll();
		
		List<GetAllHouseResponse> getByKindIdResponses = houses.stream()
				.filter(house -> house.getKind().getId() == kindId)
				.map(house -> this.modelMapperService.forResponse().map(house, GetAllHouseResponse.class))
				.collect(Collectors.toList());
		
		return getByKindIdResponses;
	}

	@Override
	public List<GetAllHouseResponse> getByIdSellerResponses(int sellerId) {
		List<House> houses = this.houseRepository.findAll();
		
		List<GetAllHouseResponse> getBySellerIdResponses = houses.stream()
				.filter(house -> house.getSeller().getId() == sellerId)
				.map(house -> this.modelMapperService.forResponse().map(house, GetAllHouseResponse.class))
				.collect(Collectors.toList());
		
		return getBySellerIdResponses;
	}
	
	
}
