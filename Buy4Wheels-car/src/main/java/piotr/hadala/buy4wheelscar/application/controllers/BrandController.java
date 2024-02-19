package piotr.hadala.buy4wheelscar.application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;

public interface  BrandController {
    @PostMapping("/brands")
    ResponseEntity<BrandResponseDTO> createBrand(@Valid @RequestBody BrandCreateRequestDTO brandCreateRequestDTO);

    @GetMapping("/brands")
    ResponseEntity<BrandListResponseDTO> getBrands();

    @GetMapping("/brands/{id}")
    ResponseEntity<BrandResponseDTO> getBrandById(@Valid @RequestBody int id);
    @DeleteMapping("/brands/{id}")
    ResponseEntity<Void> deleteBrandById(@Valid @PathVariable int id);
}
