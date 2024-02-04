package piotr.hadala.buy4wheels.domain.car.carBrand;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarBrandRepository extends CrudRepository<CarBrand, Long> {
    Optional<CarBrand> findByNameIgnoreCase(String name);
    Optional<CarBrand> findByCountryIgnoreCase(String country);
}
