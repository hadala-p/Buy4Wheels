package piotr.hadala.buy4wheelscar.application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;

public interface  BrandController {
    @PostMapping("/brands")
    ResponseEntity<BrandResponseDTO> createBrand(@Valid @RequestBody BrandCreateRequestDTO brandCreateRequestDTO);

    @GetMapping("/brands")
    ResponseEntity<BrandListResponseDTO> getBrands();
}
