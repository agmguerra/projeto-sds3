package br.com.agmg.dsvendas.controllers;

import br.com.agmg.dsvendas.dto.SaleDTO;
import br.com.agmg.dsvendas.dto.SellerDTO;
import br.com.agmg.dsvendas.services.SaleService;
import br.com.agmg.dsvendas.services.SellerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
