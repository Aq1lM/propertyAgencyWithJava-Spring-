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

import asaf.io.propertyAgency.business.abstracts.SellerService;
import asaf.io.propertyAgency.business.requests.CreateSellerRequest;
import asaf.io.propertyAgency.business.requests.UpdateSellerRequest;
import asaf.io.propertyAgency.business.responses.GetAllSellerResponse;
import asaf.io.propertyAgency.business.responses.GetByIdSellerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/sellers")
@AllArgsConstructor
public class SellersController {
	private SellerService sellerService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateSellerRequest createSellerRequest) {
		this.sellerService.add(createSellerRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateSellerRequest updateSellerRequest) {
		this.sellerService.update(updateSellerRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.sellerService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetByIdSellerResponse getByIdSellerResponse(@PathVariable int id) {
		return this.sellerService.getByIdSellerResponse(id);
	}
	
	@GetMapping("/getAll")
	public List<GetAllSellerResponse> getAllSellerResponses() {
		return this.sellerService.getAllSellerResponses();
	}
}
