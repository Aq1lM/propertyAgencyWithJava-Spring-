package asaf.io.propertyAgency.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import asaf.io.propertyAgency.entities.concretes.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
