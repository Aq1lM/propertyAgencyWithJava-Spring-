package asaf.io.propertyAgency.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import asaf.io.propertyAgency.entities.concretes.Kind;

public interface KindRepository extends JpaRepository<Kind, Integer>{

}
