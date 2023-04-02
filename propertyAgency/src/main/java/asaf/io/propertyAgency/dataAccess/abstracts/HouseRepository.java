package asaf.io.propertyAgency.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import asaf.io.propertyAgency.entities.concretes.House;

public interface HouseRepository extends JpaRepository<House, Integer>{
	
}
