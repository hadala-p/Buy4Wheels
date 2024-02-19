package piotr.hadala.buy4wheelscar.internal.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import piotr.hadala.buy4wheelscar.application.controllers.BrandController;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandListResponseDTO;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandResponseDTO;
import piotr.hadala.buy4wheelscar.internal.services.BrandService;
import piotr.hadala.buy4wheelscar.application.dtos.brands.BrandCreateRequestDTO;

@RestController
@AllArgsConstructor
public class BrandControllerImpl implements BrandController {
    private final BrandService brandService;

    @Override
    public ResponseEntity<BrandResponseDTO> createBrand(BrandCreateRequestDTO brandCreateRequestDTO) {
        return ResponseEntity.ok(brandService.createBrand(brandCreateRequestDTO));
    }

    @Override
    public ResponseEntity<BrandListResponseDTO> getBrands() {
        return ResponseEntity.ok(brandService.getBrands());
    }
    @Override
    public ResponseEntity<BrandResponseDTO> getBrandById(@Valid @PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.getBrandById(id));
    }
}
