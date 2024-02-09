package piotr.hadala.carservice.domain.car.carBrand;

import piotr.hadala.carservice.domain.car.carBrand.dto.CarBrandDto;

public class CarBrandDtoMapper {
    static CarBrandDto map(CarBrand carBrand) {
        return new CarBrandDto(
                carBrand.getId(),
                carBrand.getName(),
                carBrand.getCountry(),
                carBrand.getDescription()
        );
    }
}
