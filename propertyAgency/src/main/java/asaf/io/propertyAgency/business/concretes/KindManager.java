package asaf.io.propertyAgency.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asaf.io.propertyAgency.business.abstracts.KindService;
import asaf.io.propertyAgency.business.requests.CreateKindRequest;
import asaf.io.propertyAgency.business.requests.UpdateKindRequest;
import asaf.io.propertyAgency.business.responses.GetAllKindResponse;
import asaf.io.propertyAgency.business.responses.GetByIdKindResponse;
import asaf.io.propertyAgency.business.rules.KindBusinessRules;
import asaf.io.propertyAgency.core.utilities.mappers.ModelMapperService;
import asaf.io.propertyAgency.dataAccess.abstracts.KindRepository;
import asaf.io.propertyAgency.entities.concretes.Kind;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KindManager implements KindService{
	private KindRepository kindRepository;
	private ModelMapperService mapperService;
	private KindBusinessRules businessRules;

	@Override
	public void add(CreateKindRequest createKindRequest) {
		this.businessRules.checkIfKindExists(createKindRequest.getKind());
		
		Kind kind = this.mapperService.forRequest().map(createKindRequest, Kind.class);
		
		this.kindRepository.save(kind);
	}

	@Override
	public void update(UpdateKindRequest updateKindRequest) {		
		Kind kind = mapperService.forRequest().map(updateKindRequest, Kind.class);
		
		this.kindRepository.save(kind);
	}

	@Override
	public void delete(int id) {
		this.kindRepository.deleteById(id);		
	}

	@Override
	public GetByIdKindResponse getByIdKindResponse(int kindId) {
		Kind kind = this.kindRepository.findById(kindId).orElseThrow();
		
		GetByIdKindResponse getByIdKindResponse = this.mapperService.forResponse().map(kind, GetByIdKindResponse.class);
		
		return getByIdKindResponse;
	}

	@Override
	public List<GetAllKindResponse> getAll() {
		List<Kind> kinds = this.kindRepository.findAll();
		
		List<GetAllKindResponse> getAllKindResponses = kinds.stream()
				.map(kind -> this.mapperService.forResponse().map(kind, GetAllKindResponse.class))
				.collect(Collectors.toList());
		
		return getAllKindResponses;
	}

}
