package piotr.hadala.buy4wheelscar.internal.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piotr.hadala.buy4wheelscar.internal.entities.BrandEntity;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, Integer> {
    @Override
    List<BrandEntity> findAll();
    @Override
    @Modifying
    @Query("delete from BrandEntity m where m.id = :id")
    void deleteById(Integer id);
}
