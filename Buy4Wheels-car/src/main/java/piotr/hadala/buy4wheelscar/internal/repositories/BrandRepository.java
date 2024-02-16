package piotr.hadala.buy4wheelscar.internal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;

import java.util.UUID;

import java.util.List;
import java.util.UUID;
@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, UUID> {
    @Override
    List<BrandEntity> findAll();
}
