package piotr.hadala.buy4wheels.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import piotr.hadala.buy4wheels.domain.car.carBrand.CarBrandService;
import piotr.hadala.buy4wheels.domain.car.carBrand.dto.CarBrandDto;
import piotr.hadala.buy4wheels.domain.car.carBrand.CarBrandDtoMapper;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/car-brands",
    produces = {
                "application/json",
                "application/xml"
        })
public class CarBrandController {
    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @GetMapping("/{id}")
    public CarBrandDto getCarBrand(@PathVariable Long id) {
       return carBrandService.findCarBrandById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car brand not found"));
    }

    @GetMapping
    public List<CarBrandDto> getCarBrandList() {
        return carBrandService.findAllCarBrands();
    }

    @PostMapping
    ResponseEntity<CarBrandDto> addCarBrand(@RequestBody CarBrandDto carBrandDto) {
        CarBrandDto addedCarBrand = carBrandService.createCarBrand(carBrandDto);
        URI savedJobOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedCarBrand.getId())
                .toUri();
        return ResponseEntity.created(savedJobOfferUri).body(addedCarBrand);
    }
}
