package asaf.io.propertyAgency.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import asaf.io.propertyAgency.business.abstracts.LocationService;
import asaf.io.propertyAgency.business.requests.CreateLocationRequest;
import asaf.io.propertyAgency.business.requests.UpdateLocationRequest;
import asaf.io.propertyAgency.business.responses.GetAllLocationResponse;
import asaf.io.propertyAgency.business.responses.GetByIdLocationResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationsController {
	private LocationService locationService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateLocationRequest createLocationRequest) {
		this.locationService.add(createLocationRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateLocationRequest updateLocationRequest) {
		this.locationService.update(updateLocationRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int locationId) {
		this.locationService.delete(locationId);
	}
	
	@GetMapping("/{id}")
	GetByIdLocationResponse getByIdLocationResponse(@PathVariable int locationId) {
		return this.getByIdLocationResponse(locationId);
	}
	
	@GetMapping("/getAll")
	List<GetAllLocationResponse> getAllLocationResponses() {
		return this.locationService.getAllLocationResponses();
	}
}
