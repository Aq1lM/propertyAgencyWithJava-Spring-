package asaf.io.propertyAgency.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.business.abstracts.LocationService;
import asaf.io.propertyAgency.business.requests.CreateLocationRequest;
import asaf.io.propertyAgency.business.requests.UpdateLocationRequest;
import asaf.io.propertyAgency.business.responses.GetAllLocationResponse;
import asaf.io.propertyAgency.business.responses.GetByIdLocationResponse;
import asaf.io.propertyAgency.business.rules.LocationBusinessRules;
import asaf.io.propertyAgency.core.utilities.mappers.ModelMapperService;
import asaf.io.propertyAgency.dataAccess.abstracts.LocationRepository;
import asaf.io.propertyAgency.entities.concretes.Location;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationManager implements LocationService{
	
	private LocationRepository locationRepository;
	private ModelMapperService mapperService;
	private LocationBusinessRules businessRules;

	@Override
	public void add(CreateLocationRequest createLocationRequest) {
		this.businessRules.checkIfCityExists(createLocationRequest.getCity());
		
		Location location = this.mapperService.forRequest().map(createLocationRequest, Location.class);
		
		this.locationRepository.save(location);
		
	}

	@Override
	public void update(UpdateLocationRequest updateLocationRequest) {
		Location location = this.mapperService.forRequest().map(updateLocationRequest, Location.class);
		
		this.locationRepository.save(location);
	}

	@Override
	public void delete(int id) {
		this.locationRepository.deleteById(id);
	}

	@Override
	public GetByIdLocationResponse getByLocationId(int id) {
		
		Location location = this.locationRepository.findById(id).orElseThrow();
		
		GetByIdLocationResponse getByIdLocationResponse = this.mapperService.forResponse()
				.map(location, GetByIdLocationResponse.class);
		
		return getByIdLocationResponse;
	}

	@Override
	public List<GetAllLocationResponse> getAllLocationResponses() {
		List<Location> locations = this.locationRepository.findAll();
		
		List<GetAllLocationResponse> getAllLocationResponses = locations.stream()
				.map(location -> this.mapperService.forResponse().map(location, GetAllLocationResponse.class))
				.collect(Collectors.toList());
		
		return getAllLocationResponses;
	}

}
