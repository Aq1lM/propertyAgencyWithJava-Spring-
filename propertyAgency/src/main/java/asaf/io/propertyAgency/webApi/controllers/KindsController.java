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

import asaf.io.propertyAgency.business.abstracts.KindService;
import asaf.io.propertyAgency.business.requests.CreateKindRequest;
import asaf.io.propertyAgency.business.requests.UpdateKindRequest;
import asaf.io.propertyAgency.business.responses.GetAllKindResponse;
import asaf.io.propertyAgency.business.responses.GetByIdKindResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kinds")
public class KindsController {
	private KindService kindService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateKindRequest createKindRequest) {
		this.kindService.add(createKindRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateKindRequest updateKindRequest) {
		this.kindService.update(updateKindRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.kindService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetByIdKindResponse getByIdKindResponse(@PathVariable int id) {
		return this.kindService.getByIdKindResponse(id);
	}
	
	@GetMapping("/getAll")
	public List<GetAllKindResponse> getAllKindResponses() {
		return this.kindService.getAll();
	}
}
