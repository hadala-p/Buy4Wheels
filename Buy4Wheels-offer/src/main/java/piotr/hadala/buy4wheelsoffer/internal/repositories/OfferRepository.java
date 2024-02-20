package piotr.hadala.buy4wheelsoffer.internal.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, UUID>, JpaSpecificationExecutor<OfferEntity> {
    @Override
    List<OfferEntity> findAll();
    List<OfferEntity> findAllByYear(int year);
    List<OfferEntity> findAllByModel_Name(String modelName);
    List<OfferEntity> findAllByBrand_Name(String brandName);
    List<OfferEntity> findAllByBrand_NameAndModel_Name(String brandName, String modelName);
    List<OfferEntity> findAllByPriceBetween(double min, double max);
    List<OfferEntity> findAllByMileageLessThan(int max);
    List<OfferEntity> findAllByFuelType(String fuelType);
    List<OfferEntity> findAllByTransmission(String transmission);
    List<OfferEntity> findAllByEnginePowerBetween(int min, int max);
    List<OfferEntity> findAllByColor(String color);
    List<OfferEntity> findAllByIsAvailable(boolean isAvailable);



}
