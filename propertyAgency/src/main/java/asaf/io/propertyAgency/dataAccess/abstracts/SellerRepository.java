package asaf.io.propertyAgency.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import asaf.io.propertyAgency.entities.concretes.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{

}
