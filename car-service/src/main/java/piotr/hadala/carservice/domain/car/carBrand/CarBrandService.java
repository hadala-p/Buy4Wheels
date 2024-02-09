package piotr.hadala.carservice.domain.car.carBrand;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piotr.hadala.carservice.domain.car.carBrand.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    @Transactional
    public CarBrandDto createCarBrand(CarBrandDto carBrandDto) {
        CarBrand carBrand = new CarBrand();
        carBrand.setName(carBrandDto.getName());
        carBrand.setCountry(carBrandDto.getCountry());
        carBrand.setDescription(carBrandDto.getDescription());
        carBrandRepository.save(carBrand);
        return CarBrandDtoMapper.map(carBrand);
    }

    public List<CarBrandDto> findAllCarBrands() {
        return StreamSupport.stream(carBrandRepository.findAll().spliterator(), false)
                .map(CarBrandDtoMapper::map)
                .toList();
    }

    public Optional<CarBrandDto> findCarBrandById(Long id) {
        return carBrandRepository.findById(id)
                .map(CarBrandDtoMapper::map);
    }

    public Optional<CarBrandDto> findCarBrandByName(String name) {
        return carBrandRepository.findByNameIgnoreCase(name)
                .map(CarBrandDtoMapper::map);
    }

    public Optional<CarBrandDto> findCarBrandByCountry(String country) {
        return carBrandRepository.findByCountryIgnoreCase(country)
                .map(CarBrandDtoMapper::map);
    }

    public CarBrandDto updateCarBrand(Long id, CarBrandDto carBrandDto) {
        CarBrand carBrand = carBrandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car brand not found"));
        carBrand.setName(carBrandDto.getName());
        carBrand.setCountry(carBrandDto.getCountry());
        carBrand.setDescription(carBrandDto.getDescription());
        carBrandRepository.save(carBrand);
        return CarBrandDtoMapper.map(carBrand);
    }

    public void deleteCarBrand(Long id) {
        carBrandRepository.deleteById(id);
    }
}
