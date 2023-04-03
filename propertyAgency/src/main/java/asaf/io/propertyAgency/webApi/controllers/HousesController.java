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

import asaf.io.propertyAgency.business.abstracts.HouseService;
import asaf.io.propertyAgency.business.requests.CreateHouseRequest;
import asaf.io.propertyAgency.business.requests.UpdateHouseRequest;
import asaf.io.propertyAgency.business.responses.GetAllHouseResponse;
import asaf.io.propertyAgency.business.responses.GetByIdHouseResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/houses")
@AllArgsConstructor
public class HousesController {
	private HouseService houseService;
	
	@GetMapping("/getAll")
	public List<GetAllHouseResponse> getAll() {
		return this.houseService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdHouseResponse getByIdHouseResponse(@PathVariable int id) {
		return this.houseService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateHouseRequest createHouseRequest) {
		this.houseService.add(createHouseRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateHouseRequest updateHouseRequest) {
		this.houseService.update(updateHouseRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.houseService.delete(id);
	}
}
