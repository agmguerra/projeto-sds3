package br.com.agmg.dsvendas.services;

import br.com.agmg.dsvendas.dto.SellerDTO;
import br.com.agmg.dsvendas.entities.Seller;
import br.com.agmg.dsvendas.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();

        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
