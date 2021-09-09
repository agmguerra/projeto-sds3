package br.com.agmg.dsvendas.services;

import br.com.agmg.dsvendas.dto.SaleDTO;
import br.com.agmg.dsvendas.entities.Sale;
import br.com.agmg.dsvendas.repositories.SaleRepository;
import br.com.agmg.dsvendas.repositories.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleService {

    private SaleRepository saleRepository;

    private SellerRepository sellerRepository;

    public SaleService(SaleRepository saleRepository, SellerRepository sellerRepository) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
    }

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {

        //Traz para memória e fica em cache. Evitas as consultas
        //ao seller um por um (uma das soluções. No meu entender ainda reuin
        sellerRepository.findAll();

        Page<Sale> result = saleRepository.findAll(pageable);

        return result.map(x -> new SaleDTO(x));
    }

}
