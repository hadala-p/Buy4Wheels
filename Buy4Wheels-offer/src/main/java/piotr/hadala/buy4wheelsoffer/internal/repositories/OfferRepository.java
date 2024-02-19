package piotr.hadala.buy4wheelsoffer.internal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import piotr.hadala.buy4wheelsoffer.internal.entities.OfferEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, UUID>{
    @Override
    List<OfferEntity> findAll();

}