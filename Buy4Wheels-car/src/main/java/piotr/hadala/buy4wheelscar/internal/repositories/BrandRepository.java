package piotr.hadala.buy4wheelscar.internal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, Integer> {
    @Override
    List<BrandEntity> findAll();
}
