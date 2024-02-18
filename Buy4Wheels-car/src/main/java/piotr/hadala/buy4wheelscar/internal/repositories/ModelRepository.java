package piotr.hadala.buy4wheelscar.internal.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import piotr.hadala.buy4wheelscar.internal.entities.ModelEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ModelRepository extends CrudRepository<ModelEntity, Integer>, JpaSpecificationExecutor<ModelEntity> {
    Optional<ModelEntity> findByName(String name);
    @Override
    List<ModelEntity> findAll();
    @Override
    @Modifying
    @Query("delete from ModelEntity m where m.id = :id")
    void deleteById(Integer id);
}
