package br.com.agmg.dsvendas.repositories;

import br.com.agmg.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
