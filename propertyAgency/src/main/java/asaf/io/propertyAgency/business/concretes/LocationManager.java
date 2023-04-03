package asaf.io.propertyAgency.business.concretes;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.business.abstracts.LocationService;
import asaf.io.propertyAgency.business.requests.CreateLocationRequest;
import asaf.io.propertyAgency.business.requests.UpdateLocationRequest;
import asaf.io.propertyAgency.business.responses.GetByIdLocationResponse;
import asaf.io.propertyAgency.core.utilities.mappers.ModelMapperService;
import asaf.io.propertyAgency.dataAccess.abstracts.LocationRepository;
import asaf.io.propertyAgency.entities.concretes.Location;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationManager implements LocationService{
	
	private LocationRepository locationRepository;
	private ModelMapperService mapperService;

	@Override
	public void add(CreateLocationRequest createLocationRequest) {
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

}
