package br.com.agmg.dsvendas.repositories;

import br.com.agmg.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
